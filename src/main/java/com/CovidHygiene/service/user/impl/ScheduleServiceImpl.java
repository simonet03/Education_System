package com.CovidHygiene.service.user.impl;

import com.CovidHygiene.entity.Schedule;
import com.CovidHygiene.repository.user.ScheduleRepository;
import com.CovidHygiene.repository.user.impl.ScheduleRepositoryImpl;
import com.CovidHygiene.service.user.ScheduleService;

import java.util.List;

public class ScheduleServiceImpl implements ScheduleService {

    private static ScheduleService service = null;
    private ScheduleRepository repository = ScheduleRepositoryImpl.getScheduleRepository();

    public static ScheduleService getService() {
        if (service == null)
            service = new ScheduleServiceImpl();
        return service;
    }

    @Override
    public List<Schedule> getAll() {
        return repository.getAll();
    }

    @Override
    public Schedule create(Schedule schedule) {
        return repository.create(schedule);
    }

    @Override
    public Schedule read(Integer classNum) {
        return repository.read(classNum);
    }

    @Override
    public Schedule update(Schedule schedule) {
        return repository.update(schedule);
    }

    @Override
    public boolean delete(Integer classNum) {
        return repository.delete(classNum);
    }
}
