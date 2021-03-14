package com.valtech.talent.program.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("hello")
public class HelloController {

    @GetMapping("/test/")
    public String index() {

        return "hello valtech !";
    }
}
