package com.CovidHygiene.repository.user.impl;

import com.CovidHygiene.entity.Temperature;
import com.CovidHygiene.factory.TemperatureFactory;
import com.CovidHygiene.repository.user.TemperatureRepository;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class TemperatureRepositoryImplTest {

    private static TemperatureRepository tempRepo = TemperatureRepositoryImpl.getTempRepo();
    private static Temperature temperature = TemperatureFactory.buildTemperature(37.2);



    @Test
    public void a_create() {
        Temperature created = tempRepo.create(temperature);
        Assert.assertNotNull(String.valueOf(temperature.getEnteringTemp()), created.getEnteringTemp());
        System.out.println("Created: " + created);
    }

    @Test
    public void b_read() {
        Temperature read = tempRepo.read(temperature.getEnteringTemp());
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update() {
        Temperature updated;
        updated = new Temperature.Builder().copy(temperature).setEnteringTemp(37.2).build();
        updated = tempRepo.update(updated);
        System.out.println("Updated: "+ updated);
    }

    @Test
    public void d_getAll() {
        System.out.println("Get All: "+ tempRepo.getAll());
    }


    @Test
    public void e_delete() {
        boolean deleted = tempRepo.delete(temperature.getEnteringTemp());
        Assert.assertTrue(deleted);
    }
}