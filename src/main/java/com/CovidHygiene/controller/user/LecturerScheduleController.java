package com.CovidHygiene.controller.user;

import com.CovidHygiene.entity.LecturerSchedule;
import com.CovidHygiene.service.user.impl.LecturerScheduleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@RestController
@RequestMapping("/lecturerSchedule")
public class LecturerScheduleController {

    @Autowired
    private LecturerScheduleServiceImpl service;

    @PostMapping("/create")
    public LecturerSchedule create(@RequestBody LecturerSchedule schedule){
        return service.create(schedule);
    }

    @GetMapping("/read/{id}")
    public LecturerSchedule read(@PathVariable String id){
        return service.read(id);
    }

    @PostMapping("/update")
    public LecturerSchedule update(@RequestBody LecturerSchedule schedule){
        return service.update(schedule);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return service.delete(id);
    }

    @GetMapping("/all")
    public Set<LecturerSchedule> getAll(){
        return service.getAll();
    }

}
