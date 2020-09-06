package com.CovidHygiene.service.impl;

import com.CovidHygiene.entity.Student;
import com.CovidHygiene.factory.StudentFactory;
import com.CovidHygiene.service.user.StudentService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)


public class StudentServiceImplTest {

    private static StudentService service = StudentServiceImpl.getService();
    private static Student student = StudentFactory.createStudent("Damian", "Mallie", "420420, Cape Town, South Africa, Earth");
    private static Student student1 = StudentFactory.createStudent("Jason", "Small", "651351, Cape Town, South Africa, Earth");
    private static Student student2 = StudentFactory.createStudent("daniel", "Long", "313510, Cape Town, South Africa, Earth");
    @Test
    public void a_create() {
        Student created = service.create(student);
        Assert.assertNotNull(student.getStudentNum());
        System.out.println("Created: " + created) ;

        //add extra students into repository
        service.create(student1);
        service.create(student2);
    }

    @Test
    public void b_read() {
        Student read = service.read(student.getStudentNum());
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update() {
        Student updated = new Student.Builder().copy(student).setFirstName("Damien").setLastName("Mally").build();
        updated = service.update(updated);
        System.out.println("Updated: "+ updated);
    }

    @Test
    public void d_getAll() {
        System.out.println("Get All: "+ service.getAll());
    }

    @Test
    public void e_delete() {
        boolean deleted = service.delete(student.getStudentNum());
        Assert.assertTrue(deleted);
    }
}