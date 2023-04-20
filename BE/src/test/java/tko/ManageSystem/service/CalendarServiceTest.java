package tko.ManageSystem.service;


import static org.assertj.core.api.Assertions.*;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


class CalendarServiceTest {
    private static CalendarService calendarService;
    @BeforeAll
    static void beforeAll() {
        calendarService = new CalendarService();
    }

    @Test
    /**
     *  달력 만드는 메소드
     */
    void 달력_list_계산() {
        List<Integer> list1 = calendarService.updateCalendar("2023", "5");
        List<Integer> testArray = new ArrayList<>();
        testArray.add(30);
        IntStream.range(1, 32).forEach(i -> testArray.add(i));
        IntStream.range(1, 4).forEach(i -> testArray.add(i));
        Assertions.assertEquals(list1, testArray);

//         fail case
//        List<Integer> list1 = calendarService.updateCalendar(2023, 5);
//        List<Integer> testArray = new ArrayList<>();
//        testArray.add(30);
//        IntStream.range(1, 33).forEach(i -> testArray.add(i));
//        IntStream.range(1, 4).forEach(i -> testArray.add(i));
//        Assertions.assertEquals(list1, testArray);
    }


    @Test
    /**
     * 전달의 마지막 날 계산 (저번달의 도착점)
     */
    void 전달_끝점_계산() {
        int preMonthEnd1 = calendarService.calendarEnd(2023, 3);
        assertThat(preMonthEnd1).isEqualTo(31);

        int preMonthEnd2 = calendarService.calendarEnd(2023, 2);
        assertThat(preMonthEnd2).isEqualTo(28);

        int preMonthEnd3 = calendarService.calendarEnd(2023, 1);
        assertThat(preMonthEnd3).isEqualTo(31);
    }

    @Test
    /**
     * 달의 시작 1일의 요일 계산 (시작점 1일)
     */
    void 시작점_계산() {

        // 2023년 4월 시작일 토요일

        int saturday = DayOfWeek.SATURDAY.getValue();
        assertThat(saturday).isEqualTo(calendarService.getThisMonthOneDay(2023, 4));

        // 2023년 10월 시작일 일요일

        int sunday = 0;
        assertThat(sunday).isEqualTo(calendarService.getThisMonthOneDay(2023, 10));


    }



    /**
     * 윤년 계산 메소드
     * 테스트 연도
     * 2016, 2100, 2000
     */
    @Test
    void 윤년_계산() {
        // 2000년은 4로 나누어 떨어지고 100으로 나누어 떨어져도 400으로 나누어 떨어지기 때문에 윤년
        int month[] = {2016, 2000, 1904, 1908, 1912, 1916, 1920, 1924, 1928, 1932, 1936, 1940, 1944};
        boolean isLeap = Arrays.stream(month).allMatch(e -> calendarService.getLeapYear(e));
        assertThat(isLeap).isTrue();


        // 2100은 4로 나누어 떨어져도 100으로 떨어져서 평년
        assertThat(calendarService.getLeapYear(2100)).isFalse();
    }
}