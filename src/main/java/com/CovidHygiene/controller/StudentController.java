package com.CovidHygiene.controller;


import com.CovidHygiene.entity.Student;
import com.CovidHygiene.factory.StudentFactory;
import com.CovidHygiene.service.user.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Set;

@RestController
@RequestMapping("/student")
public class StudentController {

    //if error, annotate @service to impl
    @Autowired
    private StudentServiceImpl service;



    @PostMapping("/create")
    public Student create (@RequestBody Student student){

        Student student1 = StudentFactory.createStudent(student.getFirstName(), student.getLastName(), student.getAddress());

        return service.create(student1);
    }



    @GetMapping("/read/{ID}")
    public Student read (@PathVariable String ID){
        return service.read(ID);
    }



    @PostMapping("/update")
    public Student update(@RequestBody Student student){

        return service.update(student);
    }



    @DeleteMapping("/delete/{ID}")
    public String delete(@PathVariable String ID){
        boolean result = service.delete(ID);
        if(result == true){
            return "success";
        }
        else{
            return "something went wrong";
        }
    }



    @GetMapping("/get/all")
    public Set<Student> getAll(){
        return service.getAll();
    }


    @GetMapping("/get/firstnames/{name}")
    public Set<Student> getFirstNames(@PathVariable String name){
        return service.getStudentsByFirstName(name);
    }


    @GetMapping("/get/lastnames/{name}")
    public Set<Student> getLastNames(@PathVariable String name){
        return service.getStudentsByLastName(name);
    }


    @GetMapping("/get/nameswithletter/{letter}")
    public Set<Student> getNamesThatStart(@PathVariable String letter){
        return service.getNamesThatStartWith(letter);
    }

}
