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
    private CleanerRepository repository;


    @Override
    public Set<Cleaner> getAll(){
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Cleaner create(Cleaner cleaner){
        return this.repository.save(cleaner);
    }

    @Override
    public Cleaner read(Long id){
        return this.repository.findById(id).orElseGet(null);
    }

    @Override
    public Cleaner update(Cleaner cleaner){
        if (this.repository.existsById(cleaner.getCleanerNum())){
            return this.repository.save(cleaner);
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        this.repository.deleteById(id);
            if(this.repository.existsById(id)){
                return false;
            }
            return true;
        }
    }

