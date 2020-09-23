package com.CovidHygiene.service.user.impl;

import com.CovidHygiene.entity.Cleaner;
import com.CovidHygiene.repository.user.CleanerRepository;
import com.CovidHygiene.repository.user.impl.CleanerRepositoryImpl;
import com.CovidHygiene.service.user.CleanerService;

import java.util.Set;

public class CleanerServiceImpl implements CleanerService{
    private static CleanerService cleanerService = null;
    private CleanerRepository cleanerRepository;

    private CleanerServiceImpl() {
        this.cleanerRepository = CleanerRepositoryImpl.getCleanerRepo();
    }

    public static CleanerService getCleanerService(){
        if(cleanerService == null) cleanerService = new CleanerServiceImpl();
        return cleanerService;
    }

    @Override
    public Set<Cleaner> getAll(){
        return this.cleanerRepository.getAll();
    }

    @Override
    public Cleaner create(Cleaner cleaner){
        return this.cleanerRepository.create(cleaner);
    }

    @Override
    public Cleaner read(Long id){
        return this.cleanerRepository.read(id);
    }

    @Override
    public Cleaner update(Cleaner cleaner){
        return this.cleanerRepository.update(cleaner);
    }

    @Override
    public boolean delete(Long id){
        return this.cleanerRepository.delete(id);
    }
}