package com.CovidHygiene.repository.user;

import com.CovidHygiene.entity.Cleaner;
import com.CovidHygiene.repository.IRepository;

import java.util.Set;

public interface CleanerRepository extends IRepository<Cleaner, Long>{
    Set <Cleaner> getAll();
}
