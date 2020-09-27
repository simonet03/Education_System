package com.CovidHygiene.repository.user;

import com.CovidHygiene.entity.Temperature;
import com.CovidHygiene.repository.IRepository;

import java.util.Set;

public interface TemperatureRepository extends IRepository<Temperature, Double> {

    Set<Temperature> getAll();
    //business logic
    Set<Temperature> getAboveAvg();
}
