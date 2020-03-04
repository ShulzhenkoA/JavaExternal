package org.javaexternal_shulzhenko.weatherapp.cityweather;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CityWeather {

    private String city;
    private double temperature;
    private double humidity;
    private double pressure;
    private LocalDateTime localDateTime;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getPressure() {
        return pressure;
    }

    public String[] getLocalDateTimeInStrings() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formatDateTime = localDateTime.format(formatter);
        return formatDateTime.split(" ");
    }

    public void setUpCityWeatherIndicators(double[] indicators){
        temperature = indicators[0];
        humidity = indicators[1];
        pressure = indicators[2];
        localDateTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(city).append(";").append(temperature).append(";").
                append(humidity).append(";").append(pressure).append(";").
                append(getLocalDateTimeInStrings()[0]).append(";").
                append(getLocalDateTimeInStrings()[1]).append("\n").toString();
    }
}
