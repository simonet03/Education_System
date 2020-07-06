package com.CovidHygiene.factory;

import java.time.LocalDate;
import java.time.LocalTime;
import com.CovidHygiene.entity.Schedule;

public class ScheduleFactory {
    public static Schedule buildSchedule(int classroomNum, LocalTime startTime, LocalTime endTime,boolean bookedForTeaching,boolean bookedForSanitizing){
        LocalDate localDate = LocalDate.now();

        return new Schedule.ScheduleBuilder()
                .setClassroomNum(classroomNum)
                .setDayPicked(localDate)
                .setStatTime(startTime)
                .setEndTime(endTime)
                .setBookedForTeach(bookedForTeaching)
                .setBookedForSanti(bookedForSanitizing)
                .build();


    }
}
