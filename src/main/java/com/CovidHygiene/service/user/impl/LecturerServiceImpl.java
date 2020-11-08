package com.CovidHygiene.service.user.impl;

import com.CovidHygiene.entity.Lecturer;
import com.CovidHygiene.repository.user.LecturerRepository;
//import com.CovidHygiene.repository.user.impl.LecturerRepositoryImpl;
import com.CovidHygiene.service.user.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class LecturerServiceImpl implements LecturerService {


    @Autowired
    private LecturerRepository repository;

//    private LecturerServiceImpl(){
//        this.repository = LecturerRepositoryImpl.getLecturerRepository();
//    }
//    public static LecturerService getService(){
//        if(service == null){
//            service = new LecturerServiceImpl();
//        }
//        return service;
//    }


    @Override
    public Set<Lecturer> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
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
        return this.repository.save(lecturer);
    }

    @Override
    public Lecturer read(String s) {

        return this.repository.findById(s).orElseGet(null);
    }

    @Override
    public Lecturer update(Lecturer lecturer) {
        if(this.repository.existsById(lecturer.getLecturerNum())) {
            return this.repository.save(lecturer);
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        this.repository.deleteById(s);
        if (this.repository.existsById(s)) return false;
        else return true;
    }
}
