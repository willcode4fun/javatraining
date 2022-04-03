package com.valtech.talent.program.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@Slf4j
@RestController
public class HelloController {

    @PostConstruct
    public void init(){
        log.info("PostConstruct init");
    }

    @GetMapping("greet")
    public String greet() {
        log.info("HelloController : greet ");
        return "Greetings Valtech !";
    }

    @GetMapping
    public String defaultAnswer() {
        log.info("HelloController : defaultAnswer ");
        return "Default : Hello Valtech !";
    }
}
