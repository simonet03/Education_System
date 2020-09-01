package com.CovidHygiene.repository.user.impl;

import com.CovidHygiene.entity.Admin;
import com.CovidHygiene.factory.AdminFactory;
import com.CovidHygiene.repository.user.AdminRepository;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class AdminRepositoryImpTest {

    private static AdminRepository repository = AdminRepositoryImp.getRepository();
    private static Admin admin = AdminFactory.buildAdmin("A001","Daphney","Kgosiejang",
            "Cput, Cape Town, 7925");


    @Test
    public void a_create() {
        Admin created = repository.create(admin);
        Assert.assertEquals(admin.getAdminNum(), created.getAdminNum());
        System.out.println("Created:" + created);
    }

    @Test
    public void b_read() {
        Admin read = repository.read(admin.getAdminNum());
        System.out.println("Read:" + read);
    }

    @Test
    public void c_update() {
        Admin updated = new Admin.Builder().copy(admin).setAdminNum("A001").build();
        updated = repository.update(updated);
        System.out.println("Updated:" + updated);
    }

    @Test
    public void d_getAll() {
        System.out.println("Get all:" + repository.getAll());
    }

    @Test
    public void e_delete() {
        boolean deleted = repository.delete(admin.getAdminNum());
        Assert.assertTrue(deleted);
    }


}