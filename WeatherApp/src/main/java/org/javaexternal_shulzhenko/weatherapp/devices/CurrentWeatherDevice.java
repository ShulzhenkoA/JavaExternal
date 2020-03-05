package org.javaexternal_shulzhenko.weatherapp.devices;

import org.javaexternal_shulzhenko.weatherapp.cityweather.CityWeather;
import org.javaexternal_shulzhenko.weatherapp.console.ConsoleView;
import org.javaexternal_shulzhenko.weatherapp.services.WeatherDataService;
import org.javaexternal_shulzhenko.weatherapp.utils.WeatherDataServiceValidator;

import java.util.Observable;
import java.util.Observer;


public class CurrentWeatherDevice implements Observer, Display {

    private Observable weatherDataService;
    private CityWeather cityWeather;
    private ConsoleView consoleView;

    public CurrentWeatherDevice(Observable weatherDataService, CityWeather cityWeather, ConsoleView consoleView) {
        this.weatherDataService = weatherDataService;
        this.cityWeather = cityWeather;
        this.consoleView = consoleView;
        loadThisDevice();
    }

    @Override
    public void update(Observable refreshedDataService, Object arg) {
        WeatherDataServiceValidator.validateDataService(refreshedDataService);
        cityWeather = ((WeatherDataService) refreshedDataService).getCityWeather();
    }

    @Override
    public void displayWeather() {
        consoleView.displayWeatherObjectToConsole(cityWeather);
    }

    private void loadThisDevice() {
        weatherDataService.addObserver(this);
        WeatherDataServiceValidator.validateDataService(weatherDataService);
        cityWeather = ((WeatherDataService) weatherDataService).getCityWeather();
    }
}
