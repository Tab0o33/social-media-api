package com.willCompany.socialmediaapi.configuration;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(info = @Info(title = "social-media-api", version = "1.2", description = "API REST mettant à disposition les différents endpoints pour gérer l'application."))
public class OpenAPIConfig {
}