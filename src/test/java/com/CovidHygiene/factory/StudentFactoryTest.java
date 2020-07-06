package com.CovidHygiene.factory;

import com.CovidHygiene.entity.Student;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentFactoryTest {


    @Test
    public void createStudent() {

        Student student = StudentFactory.createStudent("Damien", "Mally", "Cape Town, South Africa, Earth");

        assertNotNull(student);

        System.out.println(student.toString());
    }


    @Test
    public void studentNumberCheck() {

        Student student = StudentFactory.createStudent("Damien", "Mally", "Cape Town, South Africa, Earth");

        assertNotNull(student.getStudentNum());

        System.out.println(student.getStudentNum());
    }


    @Test
    public void testEquals() {

        Student student1 = StudentFactory.createStudent("Damien", "Mally", "Cape Town, South Africa, Earth");

        Student student2 = StudentFactory.createStudent("Damien", "Mally", "Cape Town, South Africa, Earth");

        student1.equals(student2);
    }

}