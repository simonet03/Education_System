package com.CovidHygiene.service.user.impl;

import com.CovidHygiene.entity.Stock;
import com.CovidHygiene.repository.user.StockRepository;
import com.CovidHygiene.service.user.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StockServiceImpl implements StockService{

    @Autowired
    private StockRepository stockRepository;

    @Override
    public Set<Stock> getAll(){
        return this.stockRepository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Stock create(Stock stock){
        return this.stockRepository.save(stock);
    }

    public Stock read(String id){
        return this.stockRepository.findById(id).orElseGet(null);
    }

    @Override
    public Stock update(Stock stock){
        if (this.stockRepository.existsById(stock.getStockType())){
            return this.stockRepository.save(stock);
        }
        return null;
    }

    @Override
    public boolean delete(String id){
        this.stockRepository.deleteById(id);
        if(this.stockRepository.existsById(id)){
            return false;
        }
        return true;
    }
}
