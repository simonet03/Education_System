package com.CovidHygiene.service.user.impl;

import com.CovidHygiene.entity.Cleaner;
import com.CovidHygiene.repository.user.CleanerRepository;
import com.CovidHygiene.service.user.CleanerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CleanerServiceImpl implements CleanerService{

    @Autowired
    private CleanerRepository cleanerRepository;


    @Override
    public Set<Cleaner> getAll(){
        return this.cleanerRepository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Cleaner create(Cleaner cleaner){
        return this.cleanerRepository.save(cleaner);
    }

    @Override
    public Cleaner read(Long id){
        return this.cleanerRepository.findById(id).orElseGet(null);
    }

    @Override
    public Cleaner update(Cleaner cleaner){
        if (this.cleanerRepository.existsById(cleaner.getCleanerNum())){
            return this.cleanerRepository.save(cleaner);
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        this.cleanerRepository.deleteById(id);
            if(this.cleanerRepository.existsById(id)){
                return false;
            }
            return true;
        }
    }

