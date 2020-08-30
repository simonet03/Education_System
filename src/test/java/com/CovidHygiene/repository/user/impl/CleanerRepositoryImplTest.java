package com.CovidHygiene.repository.user.impl;

import com.CovidHygiene.entity.Cleaner;
import com.CovidHygiene.factory.CleanerFactory;
import com.CovidHygiene.repository.user.CleanerRepository;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

    @FixMethodOrder(MethodSorters.NAME_ASCENDING)
    public class CleanerRepositoryImplTest {

        private CleanerRepository cleanerRepo = CleanerRepositoryImpl.getCleanerRepo();
        private Cleaner cleaner = CleanerFactory.buildCleaner(10, "Nazeerah", "Carr",
                "2 Newfields Road");

        @Test
        public void a_create() {
            Cleaner created = cleanerRepo.create(cleaner);
            Assert.assertEquals((cleaner.getCleanerNum()), created.getCleanerNum());
            System.out.println("Created: " + created);
        }

        @Test
        public void b_read(){
            Cleaner read = cleanerRepo.read(cleaner.getCleanerNum());
            System.out.println("Read:" + read);
        }

        @Test
        public void c_update() {
            Cleaner updated = new Cleaner.Builder().copy(cleaner).setCleanerNum(10).build();
            updated = cleanerRepo.update(updated);
            System.out.println("Updated:" + updated);
        }

        @Test
        public void d_getAll(){
            System.out.println("Get All:" + cleanerRepo.getAll());
        }

        @Test
        public void e_delete(){
            boolean deleted = cleanerRepo.delete(cleaner.getCleanerNum());
            Assert.assertTrue(deleted);
        }
}
