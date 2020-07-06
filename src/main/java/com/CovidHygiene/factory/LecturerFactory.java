package com.CovidHygiene.factory;

import com.CovidHygiene.entity.Lecturer;

public class LecturerFactory {
    public static Lecturer buildLecturer(long lecturerNum, String firstName, String lastName, String address){
        return new Lecturer.Builder().setLecturerNum(lecturerNum).setFirstName(firstName).setLastName(lastName).setAddress(address).build();
    }
}
