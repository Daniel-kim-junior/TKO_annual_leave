package tko.ManageSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tko.ManageSystem.dto.HolidayDTO;
import tko.ManageSystem.response.CalendarResponse;
import tko.ManageSystem.service.CalendarService;
import tko.ManageSystem.service.HolidayService;

@RestController
@RequestMapping("/calendar")
@CrossOrigin
class CalendarController {

    @Autowired
    private CalendarService calendarService;
    @Autowired
    private HolidayService holidayService;

    @GetMapping
    String getCalendar(@RequestParam(defaultValue = "2023" ,required = false) String year, @RequestParam(defaultValue = "5", required = false) String month)
            throws JsonProcessingException {

        List<Integer> calRst = calendarService.updateCalendar(year, month);
        List<HolidayDTO> holRst = holidayService.holidayDBData(year, month);
        ObjectMapper objectMapper = new ObjectMapper();
        String result = objectMapper.writeValueAsString(new CalendarResponse(calRst, holRst));
        return result;
    }
}
