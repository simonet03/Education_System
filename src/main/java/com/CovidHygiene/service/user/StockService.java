package com.CovidHygiene.service.user;

import com.CovidHygiene.entity.Stock;
import com.CovidHygiene.service.IService;

import java.util.Set;

public interface StockService extends IService<Stock, String>{
    Set<Stock> getAll();
}
