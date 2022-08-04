package ca.destiny.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "ca.destiny")
public class DestinyApplication {

    public static void main(String[] args) {
        SpringApplication.run(DestinyApplication.class, args);
    }
}