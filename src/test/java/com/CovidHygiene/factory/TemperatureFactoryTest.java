package com.CovidHygiene.factory;


import com.CovidHygiene.entity.Temperature;
import org.junit.Assert;
import org.junit.Test;

import static java.lang.String.valueOf;
import static org.junit.Assert.*;

public class TemperatureFactoryTest {

    @Test
    public void buildTemperature(){
        Temperature temp = TemperatureFactory.buildTemperature(37.2, 37.3);
        Assert.assertNotNull(temp);

    }

}