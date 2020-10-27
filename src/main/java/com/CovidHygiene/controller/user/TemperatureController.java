package com.CovidHygiene.controller.user;

import com.CovidHygiene.entity.Temperature;
import com.CovidHygiene.factory.TemperatureFactory;
import com.CovidHygiene.service.user.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/temperature")
public class TemperatureController {

    @Autowired
    private TemperatureService service;

    @PostMapping("/create")
    public Temperature create (@RequestBody Temperature temperature){
        Temperature temperature1 = TemperatureFactory.buildTemperature(temperature.getEnteringTemp());
        return service.create(temperature1);
    }

    @GetMapping("/read/temperature")
    public Temperature read (@PathVariable String temperature){
        return  service.read(Double.valueOf(temperature));
    }

    @PostMapping("/update")
    public Temperature update(@RequestBody Temperature temperature){
        return  service.update(temperature);
    }

    @DeleteMapping("/delete/temperature")
    public String delete(@PathVariable Double temperature){
        boolean result = service.delete(temperature);
        if(result == true){
            return "success";
        }
        else {
            return "something went wrong";
        }
    }

    @GetMapping("/getAll/temperature")
    public Set<Temperature> getAll(){
        return service.getAll();
    }

   /** @GetMapping("/getAboveAvg")
    public Set<Temperature> getAboveAvg(){
        return service.getAboveAvg();
    }**/

}
