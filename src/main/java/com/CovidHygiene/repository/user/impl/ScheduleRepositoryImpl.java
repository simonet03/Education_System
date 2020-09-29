package com.CovidHygiene.repository.user.impl;

import com.CovidHygiene.entity.Schedule;
import com.CovidHygiene.repository.user.ScheduleRepository;

import java.util.ArrayList;
import java.util.List;

public class ScheduleRepositoryImpl implements ScheduleRepository{
    private List<Schedule> schedules;
    private static ScheduleRepository scheduleRepository = null;

    public ScheduleRepositoryImpl() {
        this.schedules = new ArrayList<>();
    }

    public static ScheduleRepository getScheduleRepository(){
        if (scheduleRepository == null)
            scheduleRepository = new ScheduleRepositoryImpl();
        return scheduleRepository;
    }

    @Override
    public Schedule create(Schedule schedule){
        schedules.add(schedule);
        return schedule;
    }

    @Override
    public Schedule read(String classNum){
        return schedules.stream().filter(schedule -> schedule.getClassroomNum() == classNum).
                findAny().orElse(null);
    }


    @Override
    public Schedule update(Schedule schedule){
        Schedule oldSchedule = read(schedule.getClassroomNum());
        if (oldSchedule != null){
            schedules.remove(oldSchedule);
            schedules.add(schedule);
        }

        return schedule;
    }

    @Override
    public boolean delete(Integer classNum){
        Schedule oldSchedule = read(classNum);
        if (oldSchedule != null) {
            schedules.remove(oldSchedule);
            return true;
        }
        return false;

    }

    @Override
    public List<Schedule> getAll() {
        return schedules;
    }
}
