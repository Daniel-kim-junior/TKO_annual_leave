package tko.ManageSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



/**
 * Daniel kim
 * controller : 외부에서 요청을 받는 클래스들을 정의하는 패키지
 * 2023-04-12
 */
@Controller
@RequestMapping(path = "/")
public class UserController {

    @GetMapping("text-basic")
    public String textBasic(Model model) {
        model.addAttribute("result", "hello Spring");
        return "index.html";
    }

}
