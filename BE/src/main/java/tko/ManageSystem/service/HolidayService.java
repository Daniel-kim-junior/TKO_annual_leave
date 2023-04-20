package tko.ManageSystem.service;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import tko.ManageSystem.dto.HolidayDTO;
import tko.ManageSystem.repository.HolidayRepository;

@Service
public class HolidayService {
    @Autowired
    private HolidayRepository holidayRepository;

    @Value("${service-key}")
    private String serviceKey;

    private static List<HolidayDTO> result;
    private static final String array[] = {"response", "body", "items"};
    private static final ObjectMapper objectMapper = new ObjectMapper();


    // 통신 후 db update
    @Scheduled(cron = "0 0 0 1 1 *") // 매년 1월 1일
    public void getHolidayData() {

        try {
            // 크론 잡을 실행 시킬때 테이블에 있는 모든 데이터
            result = new ArrayList<>();

            // 데이터베이스에 있는 모든 데이터 삭제
            holidayRepository.removeHolidayTable();
            // 현재 년도 부터 다음해 12월까지
            int curYear = LocalDate.now().getYear();
            int nextYear = curYear + 1;
            int curMonth = 1;
            int month;
            JsonNode rootNode;
            while(curMonth < 26) {
                month = curMonth % 13;
                if(month == 0){
                    curMonth++;
                    continue;
                }

                if((curMonth - 1) / 12  == 0) {
                    // 올해
                    rootNode = getJsonNode(curYear, month);
                    findData(0, rootNode);

                } else {
                    // 내년
                    rootNode = getJsonNode(nextYear, month);
                    findData(0, rootNode);
                }
                curMonth++;
            }

            for(HolidayDTO hdt : result) {
                holidayRepository.insertHoliday(hdt);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private JsonNode getJsonNode(int year, int month) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        String monthStr = month < 10 ? "0"+month : String.valueOf(month);
        String URL = "http://apis.data.go.kr/B090041/openapi/service/SpcdeInfoService/getRestDeInfo?ServiceKey=" + serviceKey + "&";
        String query = URL + "solYear=" + year + "&" + "solMonth=" + monthStr;
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(query, HttpMethod.GET, entity, String.class);

        JsonNode rootNode = objectMapper.readTree(response.getBody());
        return rootNode;
    }




    private static void findData(int dep, JsonNode jsonNode) throws JsonProcessingException {
        if(dep == 3) {
            JsonNode jn = jsonNode.get("item");
            if(jn instanceof ArrayNode) {
                for(JsonNode tmp :jn) {
                    result.add(new HolidayDTO(tmp.get("dateName").toString(), tmp.get("locdate").toString()));
                }
            } else if(jn instanceof ObjectNode){
                result.add(new HolidayDTO(jn.get("dateName").toString(), jn.get("locdate").toString()));
            }
            return;
        }

        findData(dep + 1, jsonNode.get(array[dep]));
    }

    public List<HolidayDTO> holidayDBData(String strYear, String strMonth) {
        Map<String, String> map = new HashMap<>();
        int year = Integer.parseInt(strYear);
        int month = Integer.parseInt(strMonth);
        String monthStr = month < 10 ? "0"+month : String.valueOf(month);
        map.put("year", String.valueOf(year));
        map.put("month", monthStr);
        return holidayRepository.findHoliday(map);
    }



}
