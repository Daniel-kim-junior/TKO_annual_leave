package tko.ManageSystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tko.ManageSystem.dto.UserDTO;
import tko.ManageSystem.service.UserService;

/**
 * Daniel kim
 * controller : 외부에서 요청을 받는 클래스들을 정의하는 패키지
 * 2023-04-12
 */
@Controller
@RequestMapping(path = "/")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping
    public String viewForm(Model model, UserDTO UserDTO) {
        model.addAttribute("UserDTO", UserDTO);
        return "Calander";
    }


    @PostMapping("/user-form")
    public String login(Model model) {
        model.getAttribute("userId");
        model.getAttribute("password");

        return "";
    }

}
