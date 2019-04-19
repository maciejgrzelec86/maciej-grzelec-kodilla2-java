package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WeatherForecastTestSuite {
    @Test
    public void testCalculateForecastWithMock() {
        //Given
        Temperatures temperaturesMock = mock(Temperatures.class);
        HashMap<Integer, Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put(0, 26.0);
        temperaturesMap.put(1, 26.0);
        temperaturesMap.put(2, 26.0);
        temperaturesMap.put(3, 26.0);
        temperaturesMap.put(4, 26.0);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
       int quantityOfSensors = weatherForecast.calculateForecast().size();

        //Then
        Assert.assertEquals(5, quantityOfSensors);
    }
}
