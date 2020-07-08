package com.CovidHygiene.entity;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.Assert.*;

public class ScheduleTest {
    @Test
    public void testCreate() {
        Schedule scheduleBuilder = new Schedule.ScheduleBuilder()
                .setClassroomNum(32)
                .setBookedForTeach(true)
                .setBookedForSanti(false)
                .setDayPicked(LocalDate.of(2020,06,7))
                .setStatTime(LocalTime.of(12, 30))
                .setEndTime(LocalTime.of(13, 30))
                .build();

        System.out.println(scheduleBuilder.toString());

    }

}