package tko.ManageSystem.repository;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import tko.ManageSystem.dto.UserDTO;

/**
 * Daniel kim
 * repository: Mybatis와 xml로 연결되어 있는 interface
 * Mapper 메소드를 정의하는 것은 인터페이스이고
 * 이 레포지토리에 있는 모든 Mapper는 Interface로 정의해야 한다.
 * resources/mapper/ 하위의 모든 "xml id"는 메소드의 이름과 동일해야 한다.
 * 2023-04-12
 */
@Mapper
@Repository
public interface UserMapper {
    List<UserDTO> findAll();
}
