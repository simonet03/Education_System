package com.CovidHygiene.service.user.impl;

import com.CovidHygiene.entity.Cleaner;
import com.CovidHygiene.factory.CleanerFactory;
import com.CovidHygiene.service.user.CleanerService;
import com.CovidHygiene.service.user.impl.CleanerServiceImpl;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class CleanerServiceImplTest {

    @Autowired
    private static CleanerService cleanerService;

    private static Cleaner cleaner = CleanerFactory.buildCleaner(10, "Nazeerah",
            "Carr", "2 Newfields Road");

    @Test
    public void d_getAll(){
        Set<Cleaner> cleaner = cleanerService.getAll();
        Assert.assertEquals(1, cleaner.size());
        System.out.println("All Cleaners: " + cleaner);
    }

    @Test
    public void a_create(){
        Cleaner created = cleanerService.create(cleaner);
        Assert.assertNotNull(String.valueOf(cleaner.getCleanerNum()), created.getCleanerNum());
        System.out.println("Created: " + created);
    }

    @Test
    public void b_read(){
        Cleaner read = cleanerService.read(cleaner.getCleanerNum());
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update(){
        Cleaner updated;
        updated = new Cleaner.Builder().copy(cleaner).setCleanerNum(10).build();
        updated = cleanerService.update(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    public void e_delete(){
        boolean deleted = cleanerService.delete(cleaner.getCleanerNum());
        Assert.assertTrue(deleted);
    }
}
