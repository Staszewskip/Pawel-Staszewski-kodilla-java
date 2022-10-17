package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.Temperatures;
import com.kodilla.testing.weather.WeatherForecast;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WeatherForecastTestSuite {
    @Mock
    private Temperatures temperaturesMock;

    @BeforeEach
    public void beforeEachTest() {
//        dane użyte do policzenia średniej i mediany
        Map<String, Double> temperatureMap = new HashMap<>();
        temperatureMap.put("Rzeszow", 25.5);
        temperatureMap.put("Krakow", 26.2);
        temperatureMap.put("Wroclaw", 24.8);
        temperatureMap.put("Warszawa", 25.2);
        temperatureMap.put("Gdansk", 26.1);

        when(temperaturesMock.getTemperatures()).thenReturn(temperatureMap);
    }

    @Test
    void testCalculateForecastWithMock() {
        //Given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();

        //Then
        assertEquals(5, quantityOfSensors);
    }

    @Test
    void testCalculateAverageTemperatureWithMock() {
//        given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

//        when
        double averageTemperature = weatherForecast.calculateAverageTemperature(temperaturesMock.getTemperatures());
//        then
        assertEquals(25.56, averageTemperature);
    }

    @Test
    void testCalculateMedianTemperatureWithMock() {
        //        given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

//        when
        double medianTemperature = weatherForecast.calculateMedianTemperature(temperaturesMock.getTemperatures());
//        then
        assertEquals(25.5, medianTemperature);

    }
}