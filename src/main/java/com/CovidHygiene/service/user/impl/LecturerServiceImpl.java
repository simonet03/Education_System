package com.CovidHygiene.service.user.impl;

import com.CovidHygiene.entity.Lecturer;
import com.CovidHygiene.repository.user.LecturerRepository;
import com.CovidHygiene.repository.user.impl.LecturerRepositoryImpl;
import com.CovidHygiene.service.user.LecturerService;

import java.util.Set;

public class LecturerServiceImpl implements LecturerService {
    private static LecturerService service = null;
    private LecturerRepository repository;

    private LecturerServiceImpl(){
        this.repository = LecturerRepositoryImpl.getLecturerRepository();
    }
    public static LecturerService getService(){
        if(service == null){
            service = new LecturerServiceImpl();
        }
        return service;
    }


    @Override
    public Set<Lecturer> getAll() {
        return this.repository.getAll();
    }
//
//    @Override
//    public Set<Lecturer> getLecturerByFirstName(String name) {
//        return null;
//    }
//
//    @Override
//    public Set<Lecturer> getLecturerByLastName(String name) {
//        return null;
//    }
//
//    @Override
//    public Set<Lecturer> getNamesStartWith(String a) {
//        return null;
//    }

    @Override
    public Lecturer create(Lecturer lecturer) {
        return this.repository.create(lecturer);
    }

    @Override
    public Lecturer read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Lecturer update(Lecturer lecturer) {
        return this.repository.update(lecturer);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }
}
