package com.CovidHygiene.entity;

import org.junit.Test;

import static org.junit.Assert.*;

public class StockTest {

    @Test
    public void testCreate() {
        Stock s = new Stock.Builder()
                .setNumOfStock(10)
                .setStockType("Face Masks")
                .build();

        System.out.println(s.toString());

    }
}