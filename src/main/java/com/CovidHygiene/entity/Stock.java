package com.CovidHygiene.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Stock implements Serializable {

    @Id
    private long numOfStock;
    private String stockType;

    protected Stock(){}

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

     @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Stock stock = (Stock) o;
            return stock.equals(stock.numOfStock);
        }

        @Override
        public int hashCode() {
            return Objects.hash(numOfStock, stockType);}

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

        public Builder copy(Stock stock) {
            this.numOfStock = stock.numOfStock;
            return this;
        }
    }
}

