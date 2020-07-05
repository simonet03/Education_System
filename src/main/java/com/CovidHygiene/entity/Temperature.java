package com.CovidHygiene.entity;

public class Temperature {

    private double enteringTemp;
    private double exitingTemp;

    private Temperature(Builder builder) {
        this.enteringTemp = builder.enteringTemp;
        this.exitingTemp = builder.exitingTemp;

    }

    public double getEnteringTemp() {
        return enteringTemp;
    }

    public double getExitingTemp() {
        return exitingTemp;
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "enteringTemp=" + enteringTemp +
                ", exitingTemp=" + exitingTemp +
                '}';
    }

    public static class Builder {
        private double enteringTemp;
        private double exitingTemp;

        public Builder setEnteringTemp(double enteringTemp) {
            this.enteringTemp = enteringTemp;
            return this;
        }

        public Builder setExitingTemp(double exitingTemp) {
            this.exitingTemp = exitingTemp;
            return this;
        }

        public Temperature build(){
            return new Temperature(this);
        }
    }
}
