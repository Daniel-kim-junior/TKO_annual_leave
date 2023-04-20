package tko.ManageSystem.service;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HolidayServiceTest {
    @Autowired
    private HolidayService holidayService;


//    @Test (DB에 휴일 정보 삽입)
//    void 휴일_정보_가져오기() {
//        holidayService.getHolidayData();
//    }

    @Test
    void 휴일_정보_가져오기() {
        String year = "2023";
        String month = "05";
        holidayService.holidayDBData(year, month);
    }
}