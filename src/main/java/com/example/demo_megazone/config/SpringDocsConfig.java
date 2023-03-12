package com.example.demo_megazone.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SpringDocsConfig {

    @Bean
    public OpenAPI openAPI(){
        Info info = new Info()
                .title("megazone 과제 API")
                .version("v1")
                .description("API 명세");

        return new OpenAPI()
                .addServersItem(new Server().url("/"))
                .info(info);
    }
}
