package com.CovidHygiene.service.user;
import com.CovidHygiene.entity.Cleaner;
import com.CovidHygiene.repository.user.CleanerRepository;
import com.CovidHygiene.service.IService;

import java.util.Set;

public interface CleanerService extends IService<Cleaner, Long>, CleanerRepository{
    Set<Cleaner> getAll();
}
