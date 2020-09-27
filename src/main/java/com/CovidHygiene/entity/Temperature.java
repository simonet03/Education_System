package com.CovidHygiene.entity;

import java.io.Serializable;

public class Temperature implements Serializable {



    private double enteringTemp;

    private Temperature(){}

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
