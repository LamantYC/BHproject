package com.bh.bhlibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.bh")
public class BhlibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(BhlibraryApplication.class, args);
    }

}
