package com.valtech.talent.program.web;

import com.valtech.talent.program.web.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(AppConfig.class)
public class TrainingApp {
    public static void main(String[] args) {
        SpringApplication.run(TrainingApp.class, args);
    }
}
