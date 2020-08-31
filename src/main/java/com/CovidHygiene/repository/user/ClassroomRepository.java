package com.CovidHygiene.repository.user;

import com.CovidHygiene.entity.Classroom;
import com.CovidHygiene.repository.IRepository;

import java.util.Set;

public interface ClassroomRepository extends IRepository<Classroom, Integer> {

    Set<Classroom> getAll();
}
