package com.CovidHygiene.repository.user.impl;

import com.CovidHygiene.entity.Student;
import com.CovidHygiene.factory.StudentFactory;
import com.CovidHygiene.repository.user.StudentRepository;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class StudentRepositoryImplTest {

    private static StudentRepository studentRepository = StudentRepositoryImpl.getStudentRepository();
    private static Student student = StudentFactory.createStudent("Damian", "Mallie", "420420, Cape Town, South Africa, Earth");


    @Test
    public void a_create() {
        Student created = studentRepository.create(student);
        Assert.assertNotNull(student.getStudentNum());
        System.out.println("Created: " + created);
    }

    @Test
    public void b_read() {
        Student read = studentRepository.read(student.getStudentNum());
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update() {
        Student updated = new Student.Builder().copy(student).setFirstName("Damien").setLastName("Mally").build();
        updated = studentRepository.update(updated);
        System.out.println("Updated: "+ updated);
    }

    @Test
    public void d_getAll() {
        System.out.println("Get All: "+ studentRepository.getAll());
    }

    @Test
    public void e_delete() {
        boolean deleted = studentRepository.delete(student.getStudentNum());
        Assert.assertTrue(deleted);
    }


}