package tko.ManageSystem.dto;

import lombok.Getter;
import lombok.ToString;

@ToString @Getter
public class HolidayDTO {
    private String locdate;
    private String dateName;

    public HolidayDTO(String dateName, String locdate) {
        this.locdate = locdate;
        this.dateName = dateName;
    }
}