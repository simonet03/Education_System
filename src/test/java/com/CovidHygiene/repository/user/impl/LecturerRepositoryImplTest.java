//package com.CovidHygiene.repository.user.impl;
//
//import com.CovidHygiene.entity.Lecturer;
//import com.CovidHygiene.factory.LecturerFactory;
//import com.CovidHygiene.repository.user.LecturerRepository;
//import org.junit.Assert;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//
//public class LecturerRepositoryImplTest {
//    private static LecturerRepository lecturerRepository = LecturerRepositoryImpl.getLecturerRepository();
//    private static Lecturer lecturer = LecturerFactory.buildLecturer("12345678", "Leon", "Small", "02, Adderley St");
//
//    @Test
//    public void d_getAll() {
//        System.out.println("All: " + lecturerRepository.getAll());
//    }
//
//    @Test
//    public void a_create() {
//        Lecturer created = lecturerRepository.create(lecturer);
//        Assert.assertNotNull(lecturer.getLecturerNum());
//        System.out.println("created: " + created);
//    }
//
//    @Test
//    public void b_read() {
//        Lecturer read = lecturerRepository.read(lecturer.getLecturerNum());
//        System.out.println("Read: " + read);
//    }
//
//    @Test
//    public void c_update() {
//        Lecturer update = new Lecturer.Builder().copy(lecturer).setFirstName("Leon").setLastName("Lel").build();
//        update = lecturerRepository.update(update);
//        System.out.println("Updated: " + update);
//    }
//
//    @Test
//    public void e_delete() {
//        boolean delete = lecturerRepository.delete(lecturer.getLecturerNum());
//        Assert.assertTrue(delete);
//    }
//}