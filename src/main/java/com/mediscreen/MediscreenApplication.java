package com.mediscreen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Locale;

@SpringBootApplication
@EnableFeignClients("com")
public class MediscreenApplication {

    public static void main(String[] args) {

        SpringApplication.run(MediscreenApplication.class, args);
    }

}
