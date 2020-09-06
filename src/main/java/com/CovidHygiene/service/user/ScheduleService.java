package com.CovidHygiene.service.user;

import com.CovidHygiene.entity.Schedule;
import com.CovidHygiene.service.IService;

import java.util.List;

public interface ScheduleService extends IService<Schedule, Integer> {
    List<Schedule> getAll();
}
