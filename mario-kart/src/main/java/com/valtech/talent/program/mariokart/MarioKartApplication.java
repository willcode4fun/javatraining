package com.valtech.talent.program.mariokart;

import com.valtech.talent.program.mariokart.configuration.DatabaseConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(DatabaseConfiguration.class)
public class MarioKartApplication {
    public static void main(String[] args) {
        SpringApplication.run(MarioKartApplication.class, args);
    }
}
