package com.CovidHygiene.repository.user;

import com.CovidHygiene.entity.Schedule;
import com.CovidHygiene.repository.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
}
