package com.CovidHygiene.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping({"/", "/home.com"})
    String home(){
        return "Covid Hygiene Application Demo!";
    }
}
