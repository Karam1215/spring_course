package ru.karam.springcourse.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "name",required = false) String name,
                           @RequestParam(value = "surname",required = false) String surname,
                           Model model) {
        //System.out.println("Hello, "+name + " " + surname);
        if(name != null && surname != null) {
            model.addAttribute("message", "Hello, "+ name + " " + surname);
        }else if(name != null && surname == null) {
            model.addAttribute("message", "Hello, " + name);
        }else if(name == null && surname != null) {
            model.addAttribute("message", "Hello, Mr'" + surname);
        }
        return "first/hello_world";
    }
    @GetMapping("/bye")
    public String bye(){
        return "first/bye";
    }

}