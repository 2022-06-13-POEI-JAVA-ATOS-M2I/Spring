package fr.m2i.spring.lesson.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping({"/", "/hello"})
    public String showWelcomePage(ModelMap model) {
        model.addAttribute("message", "Hello Spring MVC Framework");
        return "hello";
    }
}
