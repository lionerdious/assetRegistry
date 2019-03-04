package com.springboot.init;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    @GetMapping({"/", "/home"})
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="user") String name) {
        model.addAttribute("name", name);
        return "index";
    }
}
