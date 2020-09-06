package com.CovidHygiene.service.user;

import com.CovidHygiene.entity.Lecturer;
import com.CovidHygiene.service.IService;

import java.util.Set;

public interface LecturerService extends IService<Lecturer, String> {
    Set<Lecturer> getAll();
//    Set<Lecturer> getLecturerByFirstName(String name);
//    Set<Lecturer> getLecturerByLastName(String name);
//    Set<Lecturer> getNamesStartWith(String a);
}
