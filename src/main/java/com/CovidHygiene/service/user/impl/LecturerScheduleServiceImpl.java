package com.CovidHygiene.service.user.impl;

import com.CovidHygiene.entity.LecturerSchedule;
import com.CovidHygiene.repository.user.LecturerScheduleRepository;
import com.CovidHygiene.service.user.LecturerScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class LecturerScheduleServiceImpl implements LecturerScheduleService {

    @Autowired
    private LecturerScheduleRepository repository;

    @Override
    public Set<LecturerSchedule> getAll() {
        return (Set<LecturerSchedule>) repository.findAll();
    }

    @Override
    public LecturerSchedule create(LecturerSchedule schedule) {
        return repository.save(schedule);
    }

    @Override
    public LecturerSchedule read(String lecturerNum) {
        return repository.findById(lecturerNum).orElse(null);
    }

    @Override
    public LecturerSchedule update(LecturerSchedule schedule) {
        return repository.save(schedule);
    }

    @Override
    public boolean delete(String lecturerNum) {
        repository.deleteById(lecturerNum);
        return repository.existsById(lecturerNum);
    }

}
