package com.CovidHygiene.repository.user;

import com.CovidHygiene.entity.Lecturer;
import com.CovidHygiene.repository.IRepository;

import java.util.Set;

public interface LecturerRepository extends IRepository <Lecturer, String> {
    Set<Lecturer> getAll();
}
