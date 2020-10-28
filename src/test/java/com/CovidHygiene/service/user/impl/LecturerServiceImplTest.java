package com.CovidHygiene.service.user.impl;

import com.CovidHygiene.entity.Lecturer;
import com.CovidHygiene.factory.LecturerFactory;
import com.CovidHygiene.service.user.LecturerService;
import com.CovidHygiene.service.user.impl.LecturerServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class LecturerServiceImplTest {

    @Autowired
    private static LecturerService service;

    private static Lecturer lecturer = LecturerFactory.buildLecturer("1234567", "Leon", "Small", "02, Adderley St");

    Set<Lecturer> lecturerSet = service.getAll();

    @Test
    public void d_getAll() {
        Assert.assertEquals(1, lecturerSet.size());
        System.out.println("Get all lecturers: " + "\n" + service.getAll() + "\n");
    }

    @Test
    public void a_create() {
        Lecturer created = service.create(lecturer);
        Assert.assertEquals(lecturer.getLecturerNum(), created.getLecturerNum());
        System.out.println("Lecturer created: " + created);
    }

    @Test
    public void b_read() {
        Lecturer read = service.read(lecturer.getLecturerNum());
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update() {
        Lecturer update = new Lecturer.Builder().copy(lecturer).setLecturerNum("12345678").build();
        update = service.update(update);
        System.out.println("Updated: ");
    }

    @Test
    public void d_delete() {
        boolean delete = service.delete(lecturer.getLecturerNum());
        Assert.assertTrue(delete);
    }
}