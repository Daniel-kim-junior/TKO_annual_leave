package tko.ManageSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tko.ManageSystem.dto.UserDTO;
import tko.ManageSystem.repository.UserMapper;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<UserDTO> findAll() {
        return userMapper.findAll();
    }
}
