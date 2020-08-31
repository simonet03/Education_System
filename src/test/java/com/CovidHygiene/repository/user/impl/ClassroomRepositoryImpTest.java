/*
    Author:Ethan Petersen(217140807)
    This class contains the test case for the classroom repository
 */

package com.CovidHygiene.repository.user.impl;

import com.CovidHygiene.entity.Classroom;
import com.CovidHygiene.factory.ClassroomFactory;
import com.CovidHygiene.repository.user.ClassroomRepository;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ClassroomRepositoryImpTest {
    private static ClassroomRepository repository = ClassroomRepositoryImp.getRepository();
    private static Classroom classroom = ClassroomFactory.createClassroom(7,true,25,true);

    @Test
    public void a_create() {
        Classroom create = repository.create(classroom);
        Assert.assertEquals(classroom.getClassroomNum(),create.getClassroomNum()); // comparing the classroom that has been built with the one saved in the database
        System.out.println("Created = " + create);
    }

    @Test
    public void b_read() {
        Classroom read = repository.read(classroom.getClassroomNum());
        System.out.println("Read = " + read);
    }

    @Test
    public void c_update() {
        Classroom updated = new Classroom.Builder().copy(classroom).setBooked(false).setSanitizingStation(false).build();
        updated = repository.update(updated);
        System.out.println("Updated = " + updated);
    }

    @Test
    public void d_getAll() {
        System.out.println("Get All = " + repository.getAll());

    }

    @Test
    public void e_delete() {
        boolean deleted = repository.delete(classroom.getClassroomNum());
        assertTrue(deleted);
    }


}