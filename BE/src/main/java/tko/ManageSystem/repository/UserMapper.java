package tko.ManageSystem.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import tko.ManageSystem.dto.UserDTO;

@Mapper
public interface UserMapper {
    List<UserDTO> findAll();
}
