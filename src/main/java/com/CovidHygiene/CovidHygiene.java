package com.CovidHygiene;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



// @SpringBootApplication gets rid of 404 error
//must use SpringBootApplication
@SpringBootApplication
public class CovidHygiene {
    public static void main(String[] args) {
        SpringApplication.run(CovidHygiene.class,args);
    }
}
