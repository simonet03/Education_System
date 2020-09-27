package com.CovidHygiene.service.user.impl;

import com.CovidHygiene.entity.Stock;
import com.CovidHygiene.factory.StockFactory;
import com.CovidHygiene.service.user.StockService;
import com.CovidHygiene.service.user.impl.StockServiceImpl;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class StockServiceImplTest {
    private static StockService stockService = StockServiceImpl.getStockService();
    private static Stock stock = StockFactory.buildStock(5,"Facemasks");

    @Test
    public void d_getAll(){
        Set<Stock> stock = stockService.getAll();
        Assert.assertEquals(1, stock.size());
        System.out.println("All Stock: " + stock);
    }

    @Test
    public void a_create(){
        Stock created = stockService.create(stock);
        Assert.assertNotNull(String.valueOf(stock.getNumOfStock()), created.getNumOfStock());
        System.out.println("Created: " + created);
    }

    @Test
    public void b_read(){
        Stock read = stockService.read(stock.getStockType());
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update(){
    Stock updated;
    updated = new Stock.Builder().copy(stock).setNumOfStock(5).build();
    updated = stockService.update(updated);
    System.out.println("Updated: " + updated);
    }

    @Test
    public void e_delete(){
        boolean deleted = stockService.delete(stock.getStockType());
        Assert.assertTrue(deleted);
    }
}
