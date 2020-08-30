package com.CovidHygiene.repository.user.impl;

import com.CovidHygiene.entity.Stock;
import com.CovidHygiene.factory.StockFactory;
import com.CovidHygiene.repository.user.StockRepository;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StockRepositoryImplTest {
    private StockRepository stockRepo = StockRepositoryImpl.getStockRepo();
    private Stock stock = StockFactory.buildStock(10, "Facemasks");

    @Test
    public void a_create() {
        Stock created = stockRepo.create(stock);
        Assert.assertEquals((stock.getNumOfStock()), created.getNumOfStock());
        System.out.println("Created: " + created);
    }

    @Test
    public void b_read(){
        Stock read = stockRepo.read(stock.getStockType());
        System.out.println("Read:" + read);
    }

    @Test
    public void c_update() {
        Stock updated = new Stock.Builder().copy(stock).setNumOfStock(10).build();
        updated = stockRepo.update(updated);
        System.out.println("Updated:" + updated);
    }

    @Test
    public void d_getAll(){
        System.out.println("Get All:" + stockRepo.getAll());
    }

    @Test
    public void e_delete(){
        boolean deleted = stockRepo.delete(stock.getStockType());
        Assert.assertTrue(deleted);
    }

}
