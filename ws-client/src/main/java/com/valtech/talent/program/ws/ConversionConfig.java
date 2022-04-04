package com.valtech.talent.program.ws;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConversionConfig {
    @Bean
    public ConversionService conversionService(){
        return new ConversionServiceImpl();
    }
}
