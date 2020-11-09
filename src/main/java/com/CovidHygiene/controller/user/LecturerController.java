package com.CovidHygiene.controller.user;

import com.CovidHygiene.entity.Lecturer;
import com.CovidHygiene.factory.LecturerFactory;
import com.CovidHygiene.service.user.impl.LecturerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/lecturer")

public class LecturerController {

    @Autowired
    private LecturerServiceImpl service;

    @PostMapping("/create")
    public Lecturer create (@RequestBody Lecturer lecturer){
        Lecturer lecturer1 = LecturerFactory.buildLecturer(lecturer.getLecturerNum(), lecturer.getFirstName(), lecturer.getLastName(), lecturer.getAddress());
        return service.create(lecturer1);
    }

    @GetMapping("/read/{ID}")
    public Lecturer read (@PathVariable String ID){
        return service.read(ID);
    }

<<<<<<< HEAD
    @PostMapping("/update")
    public Lecturer update(@RequestBody Lecturer lecturer){
        return service.update(lecturer);
    }

    @PostMapping("/delete/{ID}")
=======

    @PostMapping("/update")
    public Lecturer update(@RequestBody Lecturer lecturer){

        return service.update(lecturer);
    }

    @DeleteMapping("/delete/{ID}")
>>>>>>> upstream/master
    public String delete(@PathVariable String ID){
        boolean result = service.delete(ID);
        if(result == true){
            return "deleted";
        }
        else {
            return "did not delete";
        }
    }

    @GetMapping("/get/all")
    public Set<Lecturer> getAll(){
        return service.getAll();
    }

//    @GetMapping("/get/firstNames/{names}")
//    public Set<Lecturer> getFirstNames(@PathVariable String name){
//        return service.getLectureName(name);
//    }


}
