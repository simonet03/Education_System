/**package com.CovidHygiene.repository.user.impl;

import com.CovidHygiene.entity.Temperature;
import com.CovidHygiene.repository.user.TemperatureRepository;

import java.util.HashSet;
import java.util.Set;

public class TemperatureRepositoryImpl implements TemperatureRepository {

    private static TemperatureRepository temperatureRepository = null;
    private Set<Temperature> tempDB;

    private TemperatureRepositoryImpl(){this.tempDB = new HashSet<>();
    }

    public static TemperatureRepository getTempRepo(){
        if(temperatureRepository == null) temperatureRepository = new TemperatureRepositoryImpl();
        return temperatureRepository;
    }

    @Override
    public Set<Temperature> getAll() {
        return tempDB;
    }

    @Override
    public Temperature create(Temperature temperature) {
        this.tempDB.add(temperature);
        return temperature;
    }

    @Override
    public Temperature read(Double aDouble) {
        for(Temperature temperature : this.tempDB){
            if(temperature.getEnteringTemp()==aDouble) return temperature;
        }
        return null;
    }



    @Override
    public Temperature update(Temperature temperature) {
        boolean deleteTemperature = delete(temperature.getEnteringTemp());
        if(deleteTemperature){
            this.tempDB.add(temperature);
            return temperature;
        }
        return null;
    }

    @Override
    public boolean delete(Double doubleTemp) {
        Temperature temperature = read(doubleTemp);
        if(temperature != null){
            this.tempDB.remove(temperature);
            return true;
        }
        return false;
    }
}**/
