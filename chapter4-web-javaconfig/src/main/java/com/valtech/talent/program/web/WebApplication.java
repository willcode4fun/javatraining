package com.valtech.talent.program.web;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@Slf4j
@WebListener
public class WebApplication implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        log.info("The application started");
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        log.info("The application stopped");
    }
}
