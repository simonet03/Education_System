package com.CovidHygiene.service.user.impl;

import com.CovidHygiene.entity.Admin;
import com.CovidHygiene.factory.AdminFactory;
import com.CovidHygiene.service.user.AdminService;
import com.CovidHygiene.service.user.impl.AdminServiceImpl;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdminServiceImplTest {

    private static AdminService service = AdminServiceImpl.getService();
    private static Admin admin = AdminFactory.buildAdmin("A001","Daphney","Kgosiejang",
            "Cput, Cape Town, 7925");

    @Test
    public void a_create() {
        Admin created = service.create(admin);
        Assert.assertEquals(admin.getAdminNum(), created.getAdminNum());
        System.out.println("Created:" + created);
    }

    @Test
    public void b_read() {
        Admin read = service.read(admin.getAdminNum());
        System.out.println("Read:" + read);
    }

    @Test
    public void c_update() {
        Admin updated = new Admin.Builder().copy(admin).setAdminNum("A002").build();
        updated = service.update(updated);
        System.out.println("Updated:");
    }

    @Test
    public void d_getAll() {
        Set<Admin> admin = service.getAll();
        Assert.assertEquals(1, admin.size());
        System.out.println("All admins: " + admin);
    }

    @Test
    public void e_delete() {
        boolean deleted = service.delete(admin.getAdminNum());
        Assert.assertTrue(deleted);


    }
}