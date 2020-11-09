package com.CovidHygiene.controller.user;

import com.CovidHygiene.entity.Stock;
import com.CovidHygiene.service.user.impl.StockServiceImpl;
import com.CovidHygiene.factory.StockFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@RestController
@RequestMapping("/Stock")

public class StockController {

        @Autowired
        private StockServiceImpl service;

        @PostMapping("/create")
        public Stock create(@RequestBody Stock stock) {

            Stock s = StockFactory.buildStock(stock.getNumOfStock(), stock.getStockType());
            return service.create(s);
    }

        @GetMapping("/read/{id}")
        public Stock read(@PathVariable String id) {

            return service.read(id);
        }

        @PostMapping("/update")
        public Stock update(@RequestBody Stock stock) {

            return service.update(stock);
        }

        @DeleteMapping("/delete/{id}")
        public boolean delete(@PathVariable String id) {

            return service.delete(id);
        }

    @GetMapping("/getAll")
    public Set<Stock> getAll() {

        return service.getAll();
    }

}