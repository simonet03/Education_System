package com.CovidHygiene.entity;

//Damien Mally - 216279585

import com.CovidHygiene.util.Generate;
import org.junit.Test;

public class StudentTest {

    @Test
    public void testCreate(){
        Student stud = new Student.Builder()
                .setStudentNum(Generate.getRandomStudentNumber())
                .setFirstName("Damien")
                .setLastName("Mally")
                .setAddress("Cput, Cape Town, 1234")
                .build();




        System.out.println(stud.toString());
    }

}