package ru.litavrina.mvc_thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloRestController {
    @RequestMapping("/hello/rest")
    public String sayHello() {
        return "Hello!";
    }
}
