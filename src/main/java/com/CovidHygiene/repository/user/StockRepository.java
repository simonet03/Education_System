package com.CovidHygiene.repository.user;

import com.CovidHygiene.entity.Stock;
import com.CovidHygiene.repository.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface StockRepository extends JpaRepository<Stock, String>{

}
