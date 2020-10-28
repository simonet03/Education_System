package com.CovidHygiene.service.user.impl;

import com.CovidHygiene.entity.Temperature;
import com.CovidHygiene.repository.user.TemperatureRepository;
import com.CovidHygiene.service.user.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TemperatureServiceImpl implements TemperatureService {

    //private static TemperatureService temperatureService = null;
    @Autowired
    private TemperatureRepository temperatureRepository;

   /** private TemperatureServiceImpl(){
        this.temperatureRepository = TemperatureRepositoryImpl.getTempRepo();
    }

    public static TemperatureService getTempService(){
        if(temperatureService == null) temperatureService = new TemperatureServiceImpl();
        return temperatureService;
    }**/

    @Override
    public Set<Temperature> getAll() {
        return this.temperatureRepository.findAll().stream().collect(Collectors.toSet());
    }


    @Override
    public Temperature create(Temperature temperature) {
        return this.temperatureRepository.save(temperature);
    }

    @Override
    public Temperature read(Double aDouble) {
        return this.temperatureRepository.findById(aDouble).orElse(null);
    }



    @Override
    public Temperature update(Temperature temperature) {
        //return this.temperatureRepository.update(temperature);
        if (this.temperatureRepository.existsById(temperature.getEnteringTemp())){
            return this.temperatureRepository.save(temperature);
        }
        return null;
    }

    @Override
    public boolean delete(Double aDouble) {
         this.temperatureRepository.deleteById(aDouble);

         if (this.temperatureRepository.existsById(aDouble)){
             return false;
         }
         return true;
    }
}
