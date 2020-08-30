package com.CovidHygiene.repository.user.impl;

import com.CovidHygiene.entity.Cleaner;
import com.CovidHygiene.repository.user.CleanerRepository;

import java.util.HashSet;
import java.util.Set;

public class CleanerRepositoryImpl implements CleanerRepository {

    private static CleanerRepository cleanerRepo = null;
    public Set<Cleaner> cleanerDB;

    private CleanerRepositoryImpl(){
        this.cleanerDB = new HashSet<>();
    }

    public static CleanerRepository getCleanerRepo() {
        if (cleanerRepo == null) cleanerRepo = new CleanerRepositoryImpl();
        return cleanerRepo;
    }

            @Override
            public Cleaner create(Cleaner cleaner) {
                this.cleanerDB.add(cleaner);
                return cleaner;
            }

            @Override
            public Cleaner read(Long aLong) {
                for (Cleaner cleaner : this.cleanerDB) {
                    if (cleaner.getCleanerNum() == aLong)
                return cleaner;
            }
            return null;
        }

            @Override
            public Cleaner update(Cleaner cleaner) {
            boolean deleteCleaner = delete(cleaner.getCleanerNum());
            if(deleteCleaner){
                this.cleanerDB.add(cleaner);
                return cleaner;
            }
                return null;
            }

            @Override
            public boolean delete(Long aLong) {
            Cleaner cleaner = read(aLong);
            if(cleaner != null){
                this.cleanerDB.remove(cleaner);
                return true;
            }
                return false;
            }

            @Override
            public Set<Cleaner> getAll(){
            return this.cleanerDB;
                }
    }


