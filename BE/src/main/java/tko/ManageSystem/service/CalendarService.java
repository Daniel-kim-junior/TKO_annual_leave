package tko.ManageSystem.service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class CalendarService {
    public List<Integer> updateCalendar(String strYear, String strMonth) {
        List<Integer> result = new ArrayList<>();
        int year = Integer.parseInt(strYear);
        int month = Integer.parseInt(strMonth);

        // 현재 달 정보
        int dayIdx = 1;
        int curDay = getThisMonthOneDay(year, month);
        int curEnd = calendarEnd(year, month);

        // 전 달의 정보
        int preEnd = calendarEnd(year, month - 1);
        int preStart = preEnd - curDay + 1;


        // 다음 달 표시 정보 (0 일때는 6 1일때는 5개 2일때는 4개 ... 5일때는 1 6일때는 0)
        // 1일부터 시작
        int nextDay = 1;
        int nextEnd = 6 - curEndDayOfWeek(year, month);


        // 전달 정보 넣기
        while(preStart <= preEnd) result.add(preStart++);

        // 이번달 정보 넣기
        while(dayIdx <= curEnd) result.add(dayIdx++);

        // 다음달 정보 넣기
        while(nextDay <= nextEnd) result.add(nextDay++);


        return result;
    }

    private int curEndDayOfWeek(int year, int month) {
        int idx = LocalDate.of(year, month, calendarEnd(year, month)).getDayOfWeek().getValue();
        return idx == 7 ? 0 : idx;
    }

    public int calendarEnd(int year, int month) {
        // 윤년이면
        if(getLeapYear(year) && month == 2) return 29;

        if(month == 2) return 28;

        if(month < 8 && month % 2 == 1) return 31;

        if(month >= 8 && month % 2 == 0) return 31;

        return 30;
    }

    public int getThisMonthOneDay(int year, int month) {
        int dayIdx = LocalDate.of(year, month, 1).getDayOfWeek().getValue();

        return dayIdx == 7 ? 0 : dayIdx;
    }
    public boolean getLeapYear(int year) {
        if(year % 4 == 0) {
            if(year % 100 == 0) {
                if(year % 400 == 0) return true;

                return false;
            }
            return true;
        }
        return false;
    }
}
