package com.CovidHygiene.factory;

import com.CovidHygiene.entity.Student;
import com.CovidHygiene.util.Generate;

public class StudentFactory {



        public static Student createStudent(String firstName, String lastName, String address) {

            String studentNumber = Generate.getRandomStudentNumber();

            Student student = new Student.Builder()
                    .setStudentNum(studentNumber)
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setAddress(address)
                    .build();

            return student;
        }




}
