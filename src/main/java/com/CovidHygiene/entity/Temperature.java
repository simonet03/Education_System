package com.CovidHygiene.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Temperature implements Serializable {
    @Id
    private double enteringTemp;

    protected Temperature(){}

    private Temperature(Builder builder) {
        this.enteringTemp = builder.enteringTemp;

    }

    public double getEnteringTemp() {
        return enteringTemp;
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "enteringTemp=" + enteringTemp +
                '}';
    }

    @Override
    public boolean equals(Object o){
        if (this == o ) return  true;
        if (o == null || getClass() != o.getClass()) return false;
        Temperature temperature = (Temperature) o;
        return temperature.equals(temperature.enteringTemp);
    }

    @Override
    public int hashCode(){
       return Objects.hash(enteringTemp);
    }

    public static class Builder {
        private double enteringTemp;

        public Builder setEnteringTemp(double enteringTemp) {
            this.enteringTemp = enteringTemp;
            return this;
        }



        public Temperature build(){
            return new Temperature(this);
        }

        public Builder copy(Temperature temperature) {
            this.enteringTemp = temperature.enteringTemp;
            return this;
        }
    }
}
