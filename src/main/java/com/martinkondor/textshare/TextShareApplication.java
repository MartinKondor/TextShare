package com.martinkondor.textshare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.martinkondor.textshare"})
public class TextShareApplication {

    public static void main(String[] args) {
        SpringApplication.run(TextShareApplication.class, args);
    }

}
