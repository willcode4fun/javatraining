package com.valtech.talent.program.libraries;

import com.valtech.talent.program.libraries.database.DbConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(DbConfiguration.class)
@ComponentScan("com.valtech.talent.program.libraries.database")
public class SpringSample {

    public static void main(String[] args) {
        SpringApplication.run(SpringSample.class, args);
    }
}
