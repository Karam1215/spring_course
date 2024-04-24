package ru.karam.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class Calculator {

    @GetMapping("/calculator")
    public String calculate(@RequestParam("a") Integer a,
                            @RequestParam("b") Integer b,
                            @RequestParam("action") String action,
                            Model model) {
        double result = 0;
        switch (action) {
            case "multiplication":
                result = a * b;
                break;
            case "division":
                result = a / b;
                break;
            case "subtraction":
                result = a - b;
                break;
            case "addition":
                result = a + b;
                break;
            default:
                result = 0;
                break;
        }

        model.addAttribute("result", "The result is: "+ result);
        return "first/calculator";
    }

}
