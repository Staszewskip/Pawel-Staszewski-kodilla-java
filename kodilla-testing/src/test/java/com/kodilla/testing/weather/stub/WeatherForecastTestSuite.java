package com.kodilla.testing.weather.stub;

import org.junit.jupiter.api.*;

@DisplayName("Weather forecast tests")
public class WeatherForecastTestSuite {

    @Test
    void testCalclateForecastWithStub(){
//        given
//        utworzenie stuba interfejsu Temperatures i przekazanie go do konstruktora klasy WeatherForecast
        Temperatures temperatures = new TemperaturesStub();
        WeatherForecast weatherForecast = new WeatherForecast(temperatures);
//        when
        int quantityOfSensors = weatherForecast.calculateForecast().size();
//        then
        Assertions.assertEquals(5, quantityOfSensors);
    }
}
