package com.CovidHygiene.service.user.impl;

import com.CovidHygiene.entity.Temperature;
import com.CovidHygiene.factory.TemperatureFactory;
import com.CovidHygiene.service.user.TemperatureService;
import com.CovidHygiene.service.user.impl.TemperatureServiceImpl;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Iterator;

import java.util.Set;
import java.util.TreeSet;


import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TemperatureServiceImplTest {

    private static TemperatureService temperatureService = TemperatureServiceImpl.getTempService();
    private static Temperature temperature = TemperatureFactory.buildTemperature(37.00);

    @Test
    public void d_getAll() {
        Set<Temperature> temperature = temperatureService.getAll();
        assertEquals(1, temperature.size());
        System.out.println("All temperatures: "+ temperature);

    }

    @Test
    public void a_create() {
        Temperature created = temperatureService.create(temperature);
        Assert.assertNotNull(String.valueOf(temperature.getEnteringTemp()), created.getEnteringTemp());
        System.out.println("Created: " + created);
    }

    @Test
    public void b_read() {
        Temperature read = temperatureService.read(temperature.getEnteringTemp());
        System.out.println("Read: " + read);

    }

    @Test
    public void c_update() {
        Temperature updated;
        updated = new Temperature.Builder().copy(temperature).setEnteringTemp(37.2).build();
        updated = temperatureService.update(updated);
        System.out.println("Updated: "+ updated);
    }

    @Test
    public void e_delete() {
        boolean deleted = temperatureService.delete(temperature.getEnteringTemp());
        Assert.assertTrue(deleted);
    }

    //ClassCastException
    //solutions:
    // 1. should work when db filled
    //2. proposed fix = spring boot?
    //otherwise - confused >.<
    @Test
    public void d_getAboveAvg() {
        Set<Temperature> temps= temperatureService.getAboveAvg();
            //create hashset to treeSet
        TreeSet<Temperature> treeTemp = new TreeSet<>(temps);
            //create tailSet tree
        TreeSet<Temperature> tail_set = new TreeSet<Temperature>();
            //limit to
        tail_set = (TreeSet<Temperature>)treeTemp.tailSet(temperature);
            //create iterator
        Iterator iterate;
        iterate = tail_set.iterator();
        //display
        System.out.println("Temperatures to be concerned about are as follows: ");
        //go through tailSet
        while(iterate.hasNext()){
            System.out.println(iterate.next()+ "");
        }

    }
}