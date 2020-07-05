package com.CovidHygiene.entity;

import org.junit.Test;

public class CleanerTest {

    @Test
    public void testCreate() {
        Cleaner cl = new Cleaner.Builder()
                .setCleanerNum(10)
                .setFirstName("Nazeerah")
                .setLastName("Carr")
                .setAddress("2 Newfields Road")
                .build();

        System.out.println(cl.toString());

    }
}
