package com.CovidHygiene.repository.user;

import com.CovidHygiene.entity.Temperature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemperatureRepository extends JpaRepository<Temperature, Double> {

   // Set<Temperature> getAll();
}
