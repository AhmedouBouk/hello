package com.example.hello_world.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "hello";  // Correspond à hello.html dans /templates/
    }
}
