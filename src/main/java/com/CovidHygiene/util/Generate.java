package com.CovidHygiene.util;

public class Generate {

    public static String getRandomStudentNumber(){
        int min = 100000;
        int max = 299999;
        String studentNumber;

        int number = (int)(Math.random() * (max - min + 1) + min);

        studentNumber = "SS" + Integer.toString(number);

        return studentNumber;
    }

    public static String getRandomLecturerNumber(){
        int min = 300000;
        int max = 499999;
        String Lecturer;

        int number = (int)(Math.random() * (max - min + 1) + min);

        Lecturer = "LL" + Integer.toString(number);

        return Lecturer;
    }

    public static String getRandomAdminNumber(){
        int min = 500000;
        int max = 699999;
        String AdminNumber;

        int number = (int)(Math.random() * (max - min + 1) + min);

        AdminNumber = "AA" + Integer.toString(number);

        return AdminNumber;
    }

    public static String getRandomCleanerNumber(){
        int min = 700000;
        int max = 899999;
        String CleanerNumber;

        int number = (int)(Math.random() * (max - min + 1) + min);

        CleanerNumber = "CC" + Integer.toString(number);

        return CleanerNumber;
    }
}
