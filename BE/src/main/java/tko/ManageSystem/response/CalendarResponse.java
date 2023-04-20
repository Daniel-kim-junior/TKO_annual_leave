package tko.ManageSystem.response;

import java.util.List;

import lombok.Getter;

import tko.ManageSystem.dto.HolidayDTO;

@Getter
public class CalendarResponse {
    private List<Integer> calRst;
    private List<HolidayDTO> holRst;

    public CalendarResponse(List<Integer> calRst, List<HolidayDTO> holRst) {
        this.calRst = calRst;
        this.holRst = holRst;
    }
}
