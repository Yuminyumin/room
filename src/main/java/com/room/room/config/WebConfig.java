package com.room.room.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping(("/**"))
                .allowedOrigins("http://localhost:3000")//들어오는 url로 지정
                .allowedMethods("*");
    }
}
