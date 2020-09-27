package com.CovidHygiene.service.user.impl;

import com.CovidHygiene.entity.Temperature;
import com.CovidHygiene.repository.user.TemperatureRepository;
import com.CovidHygiene.repository.user.impl.TemperatureRepositoryImpl;
import com.CovidHygiene.service.user.TemperatureService;


import java.util.Set;

public class TemperatureServiceImpl implements TemperatureService {

    private static TemperatureService temperatureService = null;
    private TemperatureRepository temperatureRepository;

    private TemperatureServiceImpl(){
        this.temperatureRepository = TemperatureRepositoryImpl.getTempRepo();
    }

    public static TemperatureService getTempService(){
        if(temperatureService == null) temperatureService = new TemperatureServiceImpl();
        return temperatureService;
    }

    @Override
    public Set<Temperature> getAll() {
        return this.temperatureRepository.getAll();
    }

    //business logic
    @Override
    public Set<Temperature> getAboveAvg() { return this.temperatureRepository.getAboveAvg();}


    @Override
    public Temperature create(Temperature temperature) {
        return this.temperatureRepository.create(temperature);
    }

    @Override
    public Temperature read(Double aDouble) {
        return this.temperatureRepository.read(String.valueOf(aDouble));
    }

    @Override
    public Temperature read(String id) {
        return this.temperatureRepository.read(id);
    }

    @Override
    public Temperature update(Temperature temperature) {
        return this.temperatureRepository.update(temperature);
    }

    @Override
    public boolean delete(Double id) {
        return this.temperatureRepository.delete(id);
    }
}
