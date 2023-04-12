package tko.ManageSystem.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString @RequiredArgsConstructor
public class UserDTO {
    private int id;
    @NonNull private String resCode;


}
