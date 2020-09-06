package com.CovidHygiene.service.user.impl;

import com.CovidHygiene.entity.Temperature;
import com.CovidHygiene.factory.TemperatureFactory;
import com.CovidHygiene.service.user.TemperatureService;
import com.CovidHygiene.service.user.impl.TemperatureServiceImpl;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TemperatureServiceImplTest {

    private static TemperatureService temperatureService = TemperatureServiceImpl.getTempService();
    private static Temperature temperature = TemperatureFactory.buildTemperature(37.2);

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
}