package tko.ManageSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tko.ManageSystem.dto.UserDTO;
import tko.ManageSystem.service.UserService;

@RestController
@RequestMapping(value = "/api/v1")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "findAll", method = RequestMethod.POST)
    public List<UserDTO> findAll() {
        return userService.findAll();
    }

}
