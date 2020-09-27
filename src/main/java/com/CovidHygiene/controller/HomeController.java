package com.CovidHygiene.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class HomeController {

    @RequestMapping({"/", "/home.com"})
    String home(){
        return "Covid Hygiene Application Demo!";
    }
}
