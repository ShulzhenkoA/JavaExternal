package org.javaexternal_shulzhenko.weatherapp.devices;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javaexternal_shulzhenko.weatherapp.cityweather.CityWeather;
import org.javaexternal_shulzhenko.weatherapp.console.ConsoleView;
import org.javaexternal_shulzhenko.weatherapp.exceptions.InvalidWeatherDataException;
import org.javaexternal_shulzhenko.weatherapp.services.WeatherDataService;

import java.util.Observable;
import java.util.Observer;


public class CurrentWeatherDevice implements Observer, Display {

    private final static Logger LOGGER = LogManager.getLogger(CurrentWeatherDevice.class);
    private Observable weatherData;
    private CityWeather cityWeather;
    private ConsoleView consoleView;

    public CurrentWeatherDevice(Observable weatherData, CityWeather cityWeather, ConsoleView consoleView) {
        this.weatherData = weatherData;
        this.cityWeather = cityWeather;
        this.consoleView = consoleView;
        loadThisDevice();
    }

    @Override
    public void update(Observable newData, Object arg) {
        weatherDataValidator(newData);
        cityWeather = ((WeatherDataService) newData).getCityWeather();
    }

    @Override
    public void displayWeather() {
        consoleView.displayWeatherObjectToConsole(cityWeather);
    }

    public void weatherDataValidator(Observable observable){
        try {
            if(!(observable instanceof WeatherDataService)){
                throw new InvalidWeatherDataException();
            }
        }catch (InvalidWeatherDataException exc){
            LOGGER.error(exc);
            exc.printStackTrace();
        }
    }

    private void loadThisDevice() {
        weatherData.addObserver(this);
        weatherDataValidator(weatherData);
        cityWeather = ((WeatherDataService) weatherData).getCityWeather();
    }
}
