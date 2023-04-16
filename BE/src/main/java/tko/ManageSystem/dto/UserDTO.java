package tko.ManageSystem.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * Daniel kim
 * DTO : Test DTO repository와 Service Controller에서 쓸 DTO를 정의하는 패키지이다.
 * 2023-04-12
 */

@Getter
@NoArgsConstructor @ToString @RequiredArgsConstructor
public class UserDTO {

    @NonNull private String userId;
    @NonNull private String password;


}
