package com.CovidHygiene.service.user;

import com.CovidHygiene.entity.Temperature;
import com.CovidHygiene.repository.user.TemperatureRepository;
import com.CovidHygiene.service.IService;

import java.util.Set;

public interface TemperatureService extends IService<Temperature, Double>, TemperatureRepository {
    Set<Temperature> getAll();

    //unique business logic as per Temperature
    //find Temperature above average

    Set<Temperature> getAboveAvg();




}
