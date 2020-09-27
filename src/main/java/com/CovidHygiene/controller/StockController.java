package com.CovidHygiene.controller;

import com.CovidHygiene.entity.Stock;
import com.CovidHygiene.service.user.impl.StockServiceImpl;
import com.CovidHygiene.factory.StockFactory;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/Stock")

public class StockController {

        private final StockServiceImpl stockService;

    public StockController(@Qualifier("StockServiceImpl") StockServiceImpl stockService) {
        this.stockService = stockService;
    }

    @PostMapping("/create")
        public Stock create(@RequestBody Stock stock) {

            Stock s = StockFactory.buildStock(stock.getNumOfStock(), stock.getStockType());
            return stockService.create(s);
        }

        @GetMapping("/read/{id}")
        public Stock read(@PathVariable String id) {

            return stockService.read(id);
        }

        @PostMapping("/update")
        public Stock update(@RequestBody Stock stock) {

            return stockService.update(stock);
        }

        @GetMapping("/getAll")
        public Set<Stock> getAll() {

            return stockService.getAll();
        }

        @DeleteMapping("/delete/{id}")
        public boolean delete(@PathVariable String id) {

            return stockService.delete(id);
        }

}