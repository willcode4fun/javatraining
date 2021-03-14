package com.valtech.talent.program.patterns;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class DependencyInjectionExercise implements CommandLineRunner {


    @Autowired
    private ControllerSample controller;

    public interface ControllerSample {
        void callService();
    }
    public interface ControllerSample2 {
        void callMyService();
    }
    public interface ControllerSample3 {
        void callTHePresident();
    }






    @Component
    public class ControllerImpl implements ControllerSample, ControllerSample2, ControllerSample3 {

        private ServiceSample service;

        @Autowired
        public ControllerImpl(ServiceSample service) {
            this.service = service;
        }

        public void callService(){
            service.callComponent();
        }

        @Override
        public void callMyService() {

        }

        @Override
        public void callTHePresident() {

        }
    }


    public interface ServiceSample {
        void callComponent();
    }





    @Component
    public class ServiceSampleImpl implements ServiceSample{

        private ComponentSample component;

        @Autowired
        public ServiceSampleImpl(ComponentSample component) {
            this.component = component;
        }

        public void callComponent(){
            component.sayHello();
        }
    }





    public class ServiceLiskovBreak extends ServiceSampleImpl {

        public ServiceLiskovBreak(ComponentSample component) {
            super(component);
        }

        public void callComponent(){
            throw new RuntimeException();
        }
    }





    public interface ComponentSample {
        void sayHello();
    }

    @Component
    public class ComponentSampleImpl implements ComponentSample {
        public void sayHello(){
            System.out.println("Hello Valtech");
        }
    }

    public void run(String... args) throws Exception {
        System.out.println("RUN");
        controller.callService();
    }

    public static void main(String[] args) {
        SpringApplication.run(DependencyInjectionExercise.class, args);
    }
}
