package com.CovidHygiene.service.user;

import com.CovidHygiene.entity.Lecturer;
import com.CovidHygiene.entity.LecturerSchedule;
import com.CovidHygiene.service.IService;

import java.util.Set;

public interface LecturerScheduleService extends IService<LecturerSchedule, String> {
    Set<LecturerSchedule> getAll();
}
