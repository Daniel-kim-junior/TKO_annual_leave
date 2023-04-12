package tko.ManageSystem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import tko.ManageSystem.dto.UserDTO;

@Mapper
@Repository
public interface UserMapper {
    List<UserDTO> findAll();
}
