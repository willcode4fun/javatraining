package com.valtech.talent.program.patterns;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@SpringBootApplication
public class SingletonExampleWithSpring implements CommandLineRunner {



    @Autowired
    private Controller controller;

    @Component
    public class Controller {
        @Autowired
        private ServiceSample service;

        public void callService(){
            service.callComponent();
        }
    }

    @Service
    public class ServiceSample {

        @Autowired
        private ComponentSample component;

        public void callComponent(){
            component.sayHello();
        }
    }


    @Component
    public class ComponentSample {
        public void sayHello(){
            System.out.println("Hello Valtech");
        }
    }

    @Override
    public void run(String... args) throws Exception {
        controller.callService();
    }

    public static void main(String[] args) {
        SpringApplication.run(SingletonExampleWithSpring.class, args);
    }

}
