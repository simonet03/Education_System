package com.CovidHygiene.service.user.impl;

import com.CovidHygiene.entity.Student;
import com.CovidHygiene.factory.StudentFactory;
import com.CovidHygiene.service.user.StudentService;
import com.CovidHygiene.service.user.impl.StudentServiceImpl;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)


public class StudentServiceImplTest {

    private static StudentService service = StudentServiceImpl.getService();

    private static Student student = StudentFactory.createStudent("Damian", "Mallie", "420420, Cape Town, South Africa, Earth");
    private static Student student1 = StudentFactory.createStudent("Jason", "Small", "651351, Cape Town, South Africa, Earth");
    private static Student student2 = StudentFactory.createStudent("daniel", "Long", "313510, Cape Town, South Africa, Earth");

    Set<Student> studentSet = service.getAll();

    @Test
    public void a_create() {
        Student created = service.create(student);
        Assert.assertNotNull(student.getStudentNum());
        System.out.println("Created: " + "\n" + created + "\n") ;

        //add extra students into repository
        service.create(student1);
        service.create(student2);
    }

    @Test
    public void b_read() {
        Student read = service.read(student.getStudentNum());
        System.out.println("Read: " + "\n" + read + "\n");
    }

    @Test
    public void c_update() {
        Student updated = new Student.Builder().copy(student).setFirstName("Damien").setLastName("Mally").build();
        updated = service.update(updated);
        System.out.println("Updated: " + "\n" +updated + "\n");
    }

    @Test
    public void d_getAll() {
        Assert.assertEquals(3, studentSet.size());
        System.out.println("Get All: " + "\n" + service.getAll() + "\n");
    }



    @Test
    public void h_delete() {
        boolean deleted = service.delete(student.getStudentNum());
        Assert.assertTrue(deleted);
    }

    @Test
    public void e_getStudentsByFirstName() {
        Assert.assertEquals(1, service.getStudentsByFirstName("damien").size());
        System.out.println("Name that starts with: " + "\n" + service.getStudentsByFirstName("damien") + "\n");
    }

    @Test
    public void f_getStudentsByLastName() {
        Assert.assertEquals(1, service.getStudentsByLastName("long").size());
        System.out.println("Surname that starts with: " + "\n" + service.getStudentsByLastName("long") + "\n");
    }

    @Test
    public void g_getNamesThatStartWith() {
        Assert.assertEquals(2, service.getNamesThatStartWith("damien").size());
        System.out.println("Names that start with the Letter: " + "\n" + service.getNamesThatStartWith("damien") + "\n");
    }
}