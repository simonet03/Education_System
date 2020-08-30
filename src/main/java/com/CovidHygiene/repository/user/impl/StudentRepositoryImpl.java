package com.CovidHygiene.repository.user.impl;

import com.CovidHygiene.entity.Student;
import com.CovidHygiene.repository.user.StudentRepository;

import java.util.HashSet;
import java.util.Set;

public class StudentRepositoryImpl implements StudentRepository {

    //===========================================================

    private static StudentRepository studentRepository = null;
    private Set<Student> studentDB;

    private StudentRepositoryImpl(){
        this.studentDB = new HashSet<>();
    }

    //==============================================================


    public static StudentRepository getStudentRepository(){
        if(studentRepository == null){
            studentRepository = new StudentRepositoryImpl();
        }
        return studentRepository;
    }


    @Override
    public Student create(Student student) {
        this.studentDB.add(student);
        return student;
    }


    @Override
    public Student read(String ID) {

        for(Student student : this.studentDB){
            if(student.getStudentNum().equalsIgnoreCase(ID)){
                return student;
            }
        }

        return null;
    }


    @Override
    public Student update(Student student) {
        boolean deleteStudent = delete(student.getStudentNum());

        if(deleteStudent){
            this.studentDB.add(student);
            return student;
        }

        return null;
    }


    @Override
    public boolean delete(String ID) {
        Student student = read(ID);

        if(student != null){
            this.studentDB.remove(student);
            return true;
        }

        return false;
    }


    @Override
    public Set<Student> getAll() {
        return studentDB;
    }
}
