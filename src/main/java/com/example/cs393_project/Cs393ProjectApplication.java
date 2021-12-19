package com.example.cs393_project;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(version = "1.0",
        title = "Forum System API",
        description = "All Administration Operations" ))
public class Cs393ProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(Cs393ProjectApplication.class, args);
    }

}
