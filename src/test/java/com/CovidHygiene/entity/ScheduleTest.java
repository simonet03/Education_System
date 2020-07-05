package com.CovidHygiene.entity;


import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.Assert.*;

public class ScheduleTest {
    private int classroomNum;
    private LocalDate dayPicked;
    private LocalTime statTime;
    private LocalTime endTime;
    private boolean bookedForTeach;
    private boolean bookedForSanti;

    @Test
    public void testCreate() {
        Schedule.ScheduleBuilder scheduleBuilder = new Schedule.ScheduleBuilder();
        scheduleBuilder.setClassroomNum(32).
                setBookedForTeach(true).
                setStatTime(LocalTime.of(12, 30)).
                setEndTime(LocalTime.of(13, 30));
        Schedule schedule = scheduleBuilder.build();

        System.out.println(schedule.toString());

    }
}