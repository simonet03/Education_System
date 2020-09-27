package com.CovidHygiene.controller.user;

import com.CovidHygiene.entity.Temperature;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/temperature")
public class TemperatureController {

    @RequestMapping(value = "/create", method = RequestMethod.GET)
 //   @PostMapping("/create")
public String create (){
        return "called";
    }
}
