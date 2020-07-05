package com.CovidHygiene.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class GenerateTest {

    //Generate a random number between 100 000 - 299 999 with 'SS' in infront of the number
    //Returns String
    @Test
    public void getRandomStudentNumber() {
        String randomStudentNumber = Generate.getRandomStudentNumber();
        System.out.println(randomStudentNumber);
    }



    //Generate a random number between 300 000 - 499 999 with 'LL' in infront of the number
    //Returns String
    @Test
    public void getRandomLecturerNumber() {
        String randomLecturerNumber = Generate.getRandomLecturerNumber();
        System.out.println(randomLecturerNumber);
    }



    //Generate a random number between 500 000 - 699 999 with 'AA' in infront of the number
    //Returns String
    @Test
    public void getRandomAdminNumber() {
        String randomAdminNumber = Generate.getRandomAdminNumber();
        System.out.println(randomAdminNumber);
    }



    //Generate a random number between 700 000 - 899 999 with 'CC' in infront of the number
    //Returns String
    @Test
    public void getRandomCleanerNumber() {
        String randomCleanerNumber = Generate.getRandomCleanerNumber();
        System.out.println(randomCleanerNumber);
    }
}