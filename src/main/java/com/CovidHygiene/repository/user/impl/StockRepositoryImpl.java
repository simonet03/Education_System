//package com.CovidHygiene.repository.user.impl;
//
//import com.CovidHygiene.entity.Stock;
//import com.CovidHygiene.repository.user.StockRepository;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class StockRepositoryImpl implements StockRepository {
//    private static StockRepository stockRepo = null;
//    public Set<Stock> stockDB;
//
//    private StockRepositoryImpl(){
//            this.stockDB = new HashSet<>();
//        }
//
//        public static StockRepository getStockRepo() {
//            if (stockRepo == null) stockRepo = new StockRepositoryImpl();
//            return stockRepo;
//        }
//
//                @Override
//                public Stock create(Stock stock) {
//                    this.stockDB.add(stock);
//                    return stock;
//                }
//
//                @Override
//                public Stock read(String s) {
//                    for (Stock stock : this.stockDB) {
//                        if (stock.getStockType() == s)
//                         return stock;
//                    }
//                        return null;
//                }
//
//                @Override
//                public Stock update(Stock stock) {
//                boolean deleteStock = delete(stock.getStockType());
//                if(deleteStock){
//                    this.stockDB.add(stock);
//                    return stock;
//                }
//                    return null;
//        }
//
//                @Override
//                public boolean delete(String s) {
//                return false;
//                }
//
//                @Override
//                public Set<Stock> getAll() {
//                return this.stockDB;
//            }
//        }
