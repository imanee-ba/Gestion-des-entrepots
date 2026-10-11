package com.example.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.sprongframework.servlet.config.annoation.WebMvcConfigurer;
@Configuration public class WebConfig implements WebMvcConfigurer{
    @Override public void addCorsMappings(CorsRegistry registry){registry.addMapping("/api/**").allowOrigins("http://localhost:5173").allowMethods("GET","POST","PUT","PATCH","DELETE");}
}