package com.CovidHygiene.service.user.impl;

import com.CovidHygiene.entity.Schedule;
import com.CovidHygiene.repository.user.ScheduleRepository;
import com.CovidHygiene.service.user.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository repository;

    @Override
    public List<Schedule> getAll() {
        return repository.findAll();
    }

    @Override
    public Schedule create(Schedule schedule) {
        return repository.save(schedule);
    }

    @Override
    public Schedule read(Integer classNum) {
        return repository.findById(classNum).orElse(null);
    }

    @Override
    public Schedule update(Schedule schedule) {
        return repository.save(schedule);
    }

    @Override
    public boolean delete(Integer classNum) {
        repository.deleteById(classNum);
        return repository.existsById(classNum);
    }
}
