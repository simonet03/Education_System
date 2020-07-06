package com.CovidHygiene.factory;

import com.CovidHygiene.entity.Stock;

public class StockFactory {
    public static Stock buildStock(long numOfStock, String stockType) {
        return new Stock.Builder()
                .setNumOfStock(numOfStock)
                .setStockType(stockType)
                .build();
    }
}
