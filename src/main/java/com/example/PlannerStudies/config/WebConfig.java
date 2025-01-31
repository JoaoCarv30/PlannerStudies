package com.example.PlannerStudies.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

public class WebConfig extends WebMvcConfigurationSupport {

    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }

}
