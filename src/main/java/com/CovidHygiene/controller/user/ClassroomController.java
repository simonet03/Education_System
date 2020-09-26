/*
    Author:Ethan Petersen(217140807)
    This class contains the classroom controller
 */

package com.CovidHygiene.controller.user;

import com.CovidHygiene.entity.Classroom;
import com.CovidHygiene.factory.ClassroomFactory;
import com.CovidHygiene.service.user.impl.ClassroomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@EnableAutoConfiguration
@RequestMapping("/classroom")
public class ClassroomController {

    @Autowired
    private ClassroomServiceImpl classroomService;

    @PostMapping("/create")
    public Classroom create(@RequestBody Classroom cr){
        Classroom c = ClassroomFactory.createClassroom(cr.getClassroomNum(),cr.getBooked(),cr.getNumOfSeats(),cr.getSanitizingStation());
        return classroomService.create(c);
    }

    @GetMapping("/read/{classNum}")
    public Classroom read(@PathVariable Integer classNum){
        return classroomService.read(classNum);
    }

    @PostMapping("/update")
    public Classroom update(@RequestBody Classroom cr){
        return classroomService.update(cr);
    }

    @GetMapping("/getAll")
    public Set<Classroom> getAll(){
        return classroomService.getAll();
    }

    @GetMapping("/getAllSanitizedClassrooms")
    public Set<Classroom> allSanitizedClassrooms(){
        return classroomService.allSanitizedClassrooms();
    }

    @GetMapping("/getAllNotSanitizedClassrooms")
    public Set<Classroom> allNotSanitizedClassrooms(){
        return classroomService.allNotSanitizedClassrooms();
    }

    @GetMapping("/getAllBookedClassrooms")
    public Set<Classroom> allBookedClassrooms(){
        return classroomService.allBookedClassrooms();
    }

    @GetMapping("/getAllNotBookedClassrooms")
    public Set<Classroom> allNotBookedClassrooms(){
        return classroomService.allNotBookedClassrooms();
    }

    @DeleteMapping("/delete/{classNum}")
    public boolean delete(@PathVariable Integer classNum){
        return classroomService.delete(classNum);
    }
}

