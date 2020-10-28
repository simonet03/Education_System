/*
    Author:Ethan Petersen(217140807)
    This class contains classroom service
 */

package com.CovidHygiene.service.user.impl;

import com.CovidHygiene.entity.Classroom;
import com.CovidHygiene.repository.user.ClassroomRepository;
import com.CovidHygiene.service.user.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ClassroomServiceImpl implements ClassroomService {
    @Autowired
    private ClassroomRepository repository;


    @Override
    public Set<Classroom> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    public Classroom create(Classroom classroom) {
        return this.repository.save(classroom);
    }


    public Classroom read(Integer integer) {
        return this.repository.findById(integer).orElseGet(null);
    }


    public Classroom update(Classroom classroom) {
        return this.repository.save(classroom);
    }


    public boolean delete(Integer integer) {

        this.repository.deleteById(integer);
        if(repository.existsById(integer)){return false;}
        return true;
    }

    @Override
    //Business Logic: Showing all classes that are sanitized
    public Set<Classroom> allSanitizedClassrooms(){
        Set<Classroom> sanitized = new HashSet();
        Set<Classroom> classroomDb = getAll();

        for(Classroom  classroom: classroomDb){
            if(classroom.getSanitizingStation().equals(true)){
                sanitized.add(classroom);
            }
        }
        return sanitized;
    }

    public Set<Classroom> allNotSanitizedClassrooms(){
        Set<Classroom> notSanitized = new HashSet();
        Set<Classroom> classroomDb = getAll();

        for(Classroom  classroom: classroomDb){
            if(classroom.getSanitizingStation().equals(false)){
                notSanitized.add(classroom);
            }
        }
        return notSanitized;
    }

    @Override
    public Set<Classroom> allBookedClassrooms(){
        Set<Classroom> bookedClassrooms = new HashSet();
        Set<Classroom> classroomDb = getAll();

        for(Classroom  classroom: classroomDb){
            if(classroom.getBooked().equals(true)){
                bookedClassrooms.add(classroom);
            }
        }
        return bookedClassrooms;
    }

    @Override
    public Set<Classroom> allNotBookedClassrooms(){
        Set<Classroom> notBookedClassrooms = new HashSet();
        Set<Classroom> classroomDb = getAll();

        for(Classroom  classroom: classroomDb){
            if(classroom.getBooked().equals(false)){
                notBookedClassrooms.add(classroom);
            }
        }
        return notBookedClassrooms;
    }
}
