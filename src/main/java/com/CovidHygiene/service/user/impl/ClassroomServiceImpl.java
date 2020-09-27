/*
    Author:Ethan Petersen(217140807)
    This class contains classroom service
 */

package com.CovidHygiene.service.user.impl;

import com.CovidHygiene.entity.Classroom;
import com.CovidHygiene.repository.user.ClassroomRepository;
import com.CovidHygiene.repository.user.impl.ClassroomRepositoryImp;
import com.CovidHygiene.service.user.ClassroomService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ClassroomServiceImpl implements ClassroomService {
    private static ClassroomService service = null;
    private ClassroomRepository repository;

    private ClassroomServiceImpl() {
       this.repository = ClassroomRepositoryImp.getRepository(); //When a service class is instantiated it links it to the repository
    }

    public static ClassroomService getService(){
        if(service == null) {
            service  = new ClassroomServiceImpl();
        }
        return service ;
    }

    @Override
    public Set<Classroom> getAll() {
        return this.repository.getAll();
    }


    @Override
    public Classroom create(Classroom classroom) {
        return this.repository.create(classroom);
    }

    @Override
    public Classroom read(Integer integer) {
        return this.repository.read(integer);
    }

    @Override
    public Classroom update(Classroom classroom) {
        return this.repository.update(classroom);
    }

    @Override
    public boolean delete(Integer integer) {
        return this.repository.delete(integer);
    }

    @Override
    //Business Logic: Showing all classes that are sanitized
    public Set<Classroom> allSanitizedClassrooms(){
        Set<Classroom> sanitized = new HashSet();
        Set<Classroom> classroomDb = repository.getAll();

        for(Classroom  classroom: classroomDb){
            if(classroom.getSanitizingStation().equals(true)){
                sanitized.add(classroom);
            }
        }
        return sanitized;
    }

    public Set<Classroom> allNotSanitizedClassrooms(){
        Set<Classroom> notSanitized = new HashSet();
        Set<Classroom> classroomDb = repository.getAll();

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
        Set<Classroom> classroomDb = repository.getAll();

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
        Set<Classroom> classroomDb = repository.getAll();

        for(Classroom  classroom: classroomDb){
            if(classroom.getBooked().equals(false)){
                notBookedClassrooms.add(classroom);
            }
        }
        return notBookedClassrooms;
    }
}
