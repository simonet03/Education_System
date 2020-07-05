package com.CovidHygiene.factory;

import com.CovidHygiene.entity.Stock;
import org.junit.Assert;
import org.junit.Test;

public class StockFactoryTest {
    @Test
    public void buildStock() {
        Stock sto = StockFactory.buildStock(10, "Face Masks");
        Assert.assertNotNull(sto);
    }
}
