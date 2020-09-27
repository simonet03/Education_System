package com.CovidHygiene.controller.user;

import com.CovidHygiene.entity.Schedule;
import com.CovidHygiene.service.user.impl.ScheduleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleServiceImpl service;

    @PostMapping("/create")
    public Schedule create(@RequestBody Schedule schedule){
        return service.create(schedule);
    }

    @GetMapping("/read/{id}")
    public Schedule read(@PathVariable Integer id){
        return service.read(id);
    }

    @PostMapping("/update")
    public Schedule update(@RequestBody Schedule schedule){
        return service.update(schedule);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Integer id){
        return service.delete(id);
    }

    @GetMapping("/all")
    public List<Schedule> getAll(){
        return service.getAll();
    }

}
