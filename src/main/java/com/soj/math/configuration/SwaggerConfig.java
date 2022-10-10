package com.soj.math.configuration;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi publicApi(){
        return GroupedOpenApi.builder()
                .group("Math API")
                .packagesToScan("com.soj.math")
                .pathsToMatch("/soj/**")
                .build();
    }
}
