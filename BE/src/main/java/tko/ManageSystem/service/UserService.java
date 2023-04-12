package tko.ManageSystem.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tko.ManageSystem.dto.UserDTO;
import tko.ManageSystem.mapper.UserMapper;

@Service
public class UserService {
    @Autowired
    private SqlSessionTemplate sqlSession;

    public List<UserDTO> findAll() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        return userMapper.findAll();
    }
}
