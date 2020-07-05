package com.CovidHygiene.entity;

public class Stock {
    private long numOfStock;
    private String stockType;

    private Stock(Stock.Builder builder){
        this.numOfStock = builder.numOfStock;
        this.stockType = builder.stockType;
    }

    public long getNumOfStock() {
        return numOfStock;
    }

    public String getStockType() {
        return stockType;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "NumOfStock=" + numOfStock +
                ", StockType='" + stockType + '\''+ '}';
    }

    public static class Builder{
        public long numOfStock;
        public String stockType;

        public Stock.Builder setNumOfStock(long numOfStock){
            this.numOfStock = numOfStock;
            return this;
        }

        public Stock.Builder setStockType(String stockType){
            this.stockType = stockType;
            return this;
        }

        public Stock build(){
            return new Stock(this);
        }

    }
}

