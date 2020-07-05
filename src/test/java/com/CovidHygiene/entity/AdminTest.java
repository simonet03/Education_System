package com.CovidHygiene.entity;

import org.junit.Test;

import static org.junit.Assert.*;

public class AdminTest {
    @Test
    public void testCreate(){
        Admin a = new Admin.Builder()
                .setAdminNum("A001")
                .setFirstName("Daphney")
                .setLastName("Kgosiejang")
                .setAddress("Cput,Cape Town,7925")
                .build();

        System.out.println(a.toString());
    }

}