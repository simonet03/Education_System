package com.CovidHygiene.repository.user;

import com.CovidHygiene.entity.Stock;
import com.CovidHygiene.repository.IRepository;

import java.util.Set;

public interface StockRepository extends IRepository<Stock, String>{
    Set <Stock> getAll();
}
