package tko.ManageSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tko.ManageSystem.dto.UserDTO;
import tko.ManageSystem.repository.UserMapper;


/**
 * Daniel kim
 * MapperScan : basePackageClass와 동일한 패키지 혹은 하위 패키지들의 @Mapper 클래스들을 탐색
 * 2023-04-12
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<UserDTO> findAll() {
        return userMapper.findAll();
    }
}
