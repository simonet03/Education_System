package com.CovidHygiene;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;


@Component
@SpringBootApplication
public class CovidHygiene {
    public static void main(String[] args) {
        SpringApplication.run(CovidHygiene.class,args);
    }
}
