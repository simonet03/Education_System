package com.CovidHygiene.factory;

import com.CovidHygiene.entity.Temperature;

public class TemperatureFactory {

    public static Temperature buildTemperature(double enteringTemp) {
        return new Temperature.Builder()
                .setEnteringTemp(enteringTemp)
                .build();

    }
}
