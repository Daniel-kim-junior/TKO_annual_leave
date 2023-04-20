package tko.ManageSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CalendarIndexController {

    @GetMapping("/v1")
    String get() {
        return "/index";
    }
}
