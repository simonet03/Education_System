package com.CovidHygiene.service.impl;

import com.CovidHygiene.entity.Cleaner;
import com.CovidHygiene.factory.CleanerFactory;
import com.CovidHygiene.service.user.CleanerService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import java.util.Set;
import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class CleanerServiceImplTest {
    private static CleanerService cleanerService = CleanerServiceImpl.getCleanerService();
    private static Cleaner cleaner = CleanerFactory.buildCleaner(10, "Nazeerah",
            "Carr", "2 Newfields Road");

    @Test
    public void d_getAll(){
        Set<Cleaner> cleaner = cleanerService.getAll();
        assertEquals(1, cleaner.size());
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
