package com.CovidHygiene.service.user.impl;

import com.CovidHygiene.entity.Student;
import com.CovidHygiene.repository.user.StudentRepository;
import com.CovidHygiene.service.user.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {


    @Autowired
    private StudentRepository repository;




    @Override
    public Set<Student> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Set<Student> getStudentsByFirstName(String name) {
        Set<Student> studentNames = getAll();
        Set<Student> studentNew = new HashSet<>();

        for (Student a : studentNames){
            if(a.getFirstName().trim().equalsIgnoreCase(name)){
                studentNew.add(a);
            }
        }
        return studentNew;
    }

    @Override
    public Set<Student> getStudentsByLastName(String name) {
        Set<Student> studentSurnames = getAll();
        Set<Student> studentNew = new HashSet<>();

        for (Student b : studentSurnames){
            if(b.getLastName().trim().equalsIgnoreCase(name)){
                studentNew.add(b);
            }
        }
        return studentNew;
    }

    @Override
    public Set<Student> getNamesThatStartWith(String a) {
        Set<Student> students = getAll();
        Set<Student> studentNew = new HashSet<>();

        char letter = a.charAt(0);
        String newLetter = Character.toString(letter);

        for (Student c : students){
            if(c.getFirstName().toLowerCase().startsWith(newLetter)){
                studentNew.add(c);
            }
        }
        return studentNew;
    }

    //POST http method ,because of creation
    @Override
    public Student create(Student student) {
        return this.repository.save(student);
    }

    //
    @Override
    public Student read(String s) {
        return this.repository.findById(s).orElseGet(null);
    }

    @Override
    public Student update(Student student) {
        //must check with IF Statement first
        if (this.repository.existsById(student.getStudentNum())) {
            return this.repository.save(student);
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        this.repository.deleteById(s);

        if (this.repository.existsById(s)){
            return false;
        }
        return true;
    }
}
