package com.CovidHygiene.service.user;

import com.CovidHygiene.entity.Classroom;
import com.CovidHygiene.service.IService;


import java.util.Set;

public interface ClassroomService extends IService<Classroom, Integer> {

    Set<Classroom> getAll();
    Set<Classroom> allSanitizedClassrooms();
}
