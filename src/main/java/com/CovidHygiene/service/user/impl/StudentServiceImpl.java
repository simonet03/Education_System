package com.CovidHygiene.service.user.impl;

import com.CovidHygiene.entity.Student;
import com.CovidHygiene.repository.user.StudentRepository;
import com.CovidHygiene.repository.user.impl.StudentRepositoryImpl;
import com.CovidHygiene.service.user.StudentService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class StudentServiceImpl implements StudentService {

    private static StudentService service = null;
    private StudentRepository repository;

    private StudentServiceImpl(){
        this.repository = StudentRepositoryImpl.getStudentRepository();
    }

    public static StudentService getService(){
        if(service == null) {
            service = new StudentServiceImpl();
        }
        return service;
    }

    // GET http method
    @Override
    public Set<Student> getAll() {
        return this.repository.getAll();
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
        return this.repository.create(student);
    }

    //
    @Override
    public Student read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Student update(Student student) {
        return this.repository.update(student);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }
}
