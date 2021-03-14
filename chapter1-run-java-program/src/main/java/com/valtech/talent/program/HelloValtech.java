package com.valtech.talent.program;

import com.valtech.talent.program.ws.ConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class HelloValtech implements CommandLineRunner {

    @Autowired
    ConversionService conversionService;



    @Override
    public void run(String... args) throws Exception {

        String fakeArgs[] = new String[]{"1234"};
        for(String argument : fakeArgs) {

            System.out.println(argument + ":" +conversionService.convert(Integer.valueOf(argument)));
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloValtech.class, args);
    }

}
