package com.willCompany.socialmediaapi.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@CrossOrigin
public class CorsConfig implements WebMvcConfigurer {

    @Value("${ANGULAR_URL_LOCAL}")
    private String allowedOriginsLocal;

    @Value("${ANGULAR_URL_RW}")
    private String allowedOriginsRailway;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(allowedOriginsLocal, allowedOriginsRailway)
                .allowedMethods("GET", "POST", "PATCH", "DELETE")
                .allowedHeaders("*");
        ;
    }

}