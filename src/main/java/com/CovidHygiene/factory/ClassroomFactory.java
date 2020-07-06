/*
    Author:Ethan Petersen(217140807)
    This class contains the classroom entity using factory pattern
 */
package com.CovidHygiene.factory;

import com.CovidHygiene.entity.Classroom;

public class ClassroomFactory {
    public static Classroom createClassroom(int classroomNum, boolean booked, int numOfSeats, boolean sanitizingStation){
        Classroom crC =  new Classroom.Builder()
                .setClassroomNum(classroomNum)
                .setBooked(booked)
                .setNumOfSeats(numOfSeats)
                .setSanitizingStation(sanitizingStation)
                .build();

        return crC;
    }
}
