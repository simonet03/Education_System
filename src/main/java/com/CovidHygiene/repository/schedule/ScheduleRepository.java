package com.CovidHygiene.repository.schedule;

import com.CovidHygiene.entity.Schedule;
import com.CovidHygiene.repository.IRepository;

import java.util.List;

public interface ScheduleRepository extends IRepository<Schedule, Integer> {
    List<Schedule> getAll();
}
