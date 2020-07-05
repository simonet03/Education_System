/*
    Author:Ethan Petersen(217140807)
    This is the test class for the classroom entity
 */
package com.CovidHygiene.entity;

import org.junit.Test;

import static org.junit.Assert.*;

public class ClassroomTest {
    @Test
    public void testCreate() {
        Classroom c = new Classroom.Builder()
                .setClassroomNum(7)
                .setBooked(false)
                .setNumOfSeats(25)
                .setSanitizingStation(true)
                .build();

        System.out.println(c.toString());

    }

}