package com.CovidHygiene.service.user.impl;

import com.CovidHygiene.entity.Classroom;
import com.CovidHygiene.factory.ClassroomFactory;
import com.CovidHygiene.service.user.ClassroomService;
import com.CovidHygiene.service.user.impl.ClassroomServiceImpl;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ClassroomServiceImplTest {
    private static ClassroomService service= ClassroomServiceImpl.getService();
    private static Classroom classroom = ClassroomFactory.createClassroom(7,true,20,true);
    private static Classroom classroom1 = ClassroomFactory.createClassroom(8,true,20,true);
    private static Classroom classroom2 = ClassroomFactory.createClassroom(9,false,20,true);


    @Test
    public void a_create() {
        Classroom create = service.create(classroom);
        Classroom create1 = service.create(classroom1);
        Classroom create2 = service.create(classroom2);
        Assert.assertEquals(classroom.getClassroomNum(),create.getClassroomNum()); // comparing the classroom that has been built with the one saved in the database
        System.out.println("Created: \n" + create  + create1 + create2);
    }

    @Test
    public void b_read() {
        Classroom read = service.read(classroom.getClassroomNum());
        System.out.println("Read = " + read);
    }

    @Test
    public void c_update() {
        Classroom updatedNew = new Classroom.Builder().copy(classroom).setBooked(false).setSanitizingStation(false).build();
        Classroom updated = service.update(updatedNew);
        System.out.println("Updated = " + updated);
    }

    @Test
    public void d_getAll() {
        Set<Classroom> classrooms = service.getAll();
        assertEquals(3, classrooms.size());
        System.out.println("All Classrooms: \n" + classrooms);
    }


    @Test
    public void e_allSanitizedClassrooms(){
        System.out.println("All Sanitized Classrooms: \n" + service.allSanitizedClassrooms());
    }

    @Test
    public void e_allNotSanitizedClassrooms(){
        System.out.println("All Not Sanitized Classrooms: \n" + service.allNotSanitizedClassrooms());
    }

    @Test
    public void f_allBookedClassrooms(){
        System.out.println("All Booked Classrooms: \n" + service.allBookedClassrooms());
    }

    @Test
    public void g_allNotBookedClassrooms(){
        System.out.println("All Not Booked Classrooms: \n" + service.allNotBookedClassrooms());
    }

    @Test
    public void h_delete() {
        boolean deleted = service.delete(classroom.getClassroomNum());
        assertTrue(deleted);
    }
}