/*
    Author:Ethan Petersen(217140807)
    This class contains classroom repository implementation
 */
package com.CovidHygiene.repository.user.impl;

import com.CovidHygiene.entity.Classroom;
import com.CovidHygiene.repository.user.ClassroomRepository;

import java.util.HashSet;
import java.util.Set;

public class ClassroomRepositoryImp implements ClassroomRepository {
    private static ClassroomRepository repository = null;
    private Set<Classroom> classroomDB;

    private ClassroomRepositoryImp(){
        this.classroomDB = new HashSet<>();
    }

    public static ClassroomRepository getRepository(){
        if(repository == null) {
            repository = new ClassroomRepositoryImp();
        }
        return repository;
    }

    @Override
    public Classroom create(Classroom classroom) {
        this.classroomDB.add(classroom);
        return classroom;
    }

    @Override
    public Classroom read(Integer classroomNum) {
        for( Classroom classroom: this.classroomDB){
            if(classroom.getClassroomNum() == (classroomNum)){
                return classroom;
            }

        }
        return null; // If it does not find the classroom number it returns null
    }

    @Override
    public Classroom update(Classroom classroom) {
        boolean deleteClassroom = delete(classroom.getClassroomNum());
        if(deleteClassroom){
            this.classroomDB.add(classroom);
            return classroom;
        }
        return null;
    }

    @Override
    public boolean delete(Integer classroomNum) {
        Classroom delete = read(classroomNum); // Using the read method to first check if it exist in the database
        if(delete != null){
            this.classroomDB.remove(delete);
            return true;
        }
        return false;
    }

    @Override
    public Set<Classroom> getAll() {
        return this.classroomDB;
    }
}
