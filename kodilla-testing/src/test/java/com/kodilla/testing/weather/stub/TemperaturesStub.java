package com.kodilla.testing.weather.stub;

import java.util.HashMap;

public class TemperaturesStub implements Temperatures {
    @Override
    public HashMap<Integer, Double> getTemperatures() {
        HashMap<Integer, Double> stubResult = new HashMap<>();

        stubResult.put(0, 25.0);
        stubResult.put(1, 26.0);
        stubResult.put(2, 27.0);
        stubResult.put(3, 28.0);
        stubResult.put(4, 25.0);

        return stubResult;
    }
}
