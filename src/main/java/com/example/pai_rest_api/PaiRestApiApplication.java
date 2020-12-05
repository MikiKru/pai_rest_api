package com.example.pai_rest_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2         // localhost:8080/swagger-ui.html
@SpringBootApplication
public class PaiRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaiRestApiApplication.class, args);
    }

}
