package com.CovidHygiene.service.impl;

import com.CovidHygiene.entity.Stock;
import com.CovidHygiene.repository.user.StockRepository;
import com.CovidHygiene.repository.user.impl.StockRepositoryImpl;
import com.CovidHygiene.service.user.StockService;
import java.util.Set;

public class StockServiceImpl implements StockService{
    private static StockService stockService = null;
    private StockRepository stockRepository;

    private StockServiceImpl(){
        this.stockRepository = StockRepositoryImpl.getStockRepo();
    }

    public static StockService getStockService(){
        if(stockService == null) stockService = new StockServiceImpl();
        return stockService;
    }

    @Override
    public Set<Stock> getAll(){
        return this.stockRepository.getAll();
    }

    @Override
    public Stock create(Stock stock){
        return this.stockRepository.create(stock);
    }

    @Override
    public Stock read(String id){
        return this.stockRepository.read(id);
    }

    @Override
    public Stock update(Stock stock){
        return this.stockRepository.update(stock);
    }

    @Override
    public boolean delete(String id){
        return this.stockRepository.delete(id);
    }
}
