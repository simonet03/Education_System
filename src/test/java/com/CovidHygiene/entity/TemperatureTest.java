package com.CovidHygiene.entity;

import org.junit.Test;

import static org.junit.Assert.*;

public class TemperatureTest {

    @Test
    public void testCreate(){
        Temperature t = new Temperature.Builder().setEnteringTemp(12.2).build();

        System.out.println(t);
    }

}