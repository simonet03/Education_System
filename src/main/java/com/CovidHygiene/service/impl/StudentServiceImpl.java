package com.CovidHygiene.service.impl;

import com.CovidHygiene.entity.Student;
import com.CovidHygiene.repository.user.StudentRepository;
import com.CovidHygiene.repository.user.impl.StudentRepositoryImpl;
import com.CovidHygiene.service.user.StudentService;

import java.util.Set;

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


    @Override
    public Set<Student> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Student create(Student student) {
        return this.repository.create(student);
    }

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
