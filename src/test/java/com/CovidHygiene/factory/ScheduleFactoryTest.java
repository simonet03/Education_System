package com.CovidHygiene.factory;

import com.CovidHygiene.entity.Schedule;
import org.junit.Assert;
import org.junit.Test;
import java.time.LocalTime;

import static org.junit.Assert.*;

public class ScheduleFactoryTest {

    @Test
    public void buildSchedule() {
        Schedule s = ScheduleFactory.buildSchedule(30,LocalTime.of(10,30),LocalTime.of(16,30),true,false);
        Assert.assertNotNull(s);
    }
}