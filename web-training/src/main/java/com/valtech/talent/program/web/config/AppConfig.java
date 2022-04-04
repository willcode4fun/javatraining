package com.valtech.talent.program.web.config;

import com.valtech.talent.program.ws.ConversionConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.valtech.talent.program.web.controller")
//@Import(ConversionConfig.class)
public class AppConfig {
}
