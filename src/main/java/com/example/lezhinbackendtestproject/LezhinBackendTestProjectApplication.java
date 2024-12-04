package com.example.lezhinbackendtestproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EntityScan(basePackages = {"com.example.lezhinbackendtestproject"})
@EnableJpaRepositories(basePackages = "com.example.lezhinbackendtestproject.repository")
@EnableJpaAuditing
@SpringBootApplication
public class LezhinBackendTestProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(LezhinBackendTestProjectApplication.class, args);
    }

}
