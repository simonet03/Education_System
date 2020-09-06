package com.CovidHygiene.entity;

import org.junit.Test;

import static org.junit.Assert.*;

public class LecturerTest {
    @Test
    public void testCreate(){
        Lecturer l = new Lecturer.Builder().setLecturerNum("12345678").setFirstName("Leon").setLastName("Small").setAddress("02, Adderley St").build();

        System.out.println(l.toString());
    }
}