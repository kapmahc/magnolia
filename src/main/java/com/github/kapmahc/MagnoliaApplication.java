package com.github.kapmahc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:spring/*.xml")
public class MagnoliaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MagnoliaApplication.class, args);
    }
}
