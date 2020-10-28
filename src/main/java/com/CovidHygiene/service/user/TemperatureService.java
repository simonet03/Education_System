package com.CovidHygiene.service.user;

import com.CovidHygiene.entity.Temperature;
import com.CovidHygiene.service.IService;

import java.util.Set;

public interface TemperatureService extends IService<Temperature, Double> {
    Set<Temperature> getAll();

//to be added :
//    Set<Temperature> getAboveAvg();
}
