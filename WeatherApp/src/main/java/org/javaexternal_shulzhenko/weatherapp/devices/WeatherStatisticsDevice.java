package org.javaexternal_shulzhenko.weatherapp.devices;

import org.javaexternal_shulzhenko.weatherapp.cityweather.CityWeather;
import org.javaexternal_shulzhenko.weatherapp.console.ConsoleView;
import org.javaexternal_shulzhenko.weatherapp.services.WeatherDataService;
import org.javaexternal_shulzhenko.weatherapp.utils.CityWeatherStatisticUtil;
import org.javaexternal_shulzhenko.weatherapp.utils.WeatherDataServiceValidator;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class WeatherStatisticsDevice implements Observer, Display {

    private Observable weatherDataService;
    private CityWeather cityWeather;
    private ConsoleView consoleView;

    public WeatherStatisticsDevice(Observable weatherData, CityWeather cityWeather, ConsoleView consoleView) {
        this.weatherDataService = weatherData;
        this.cityWeather = cityWeather;
        this.consoleView = consoleView;
        loadThisDevice();
    }
    
    @Override
    public void update(Observable refreshedDataService, Object arg) {
        WeatherDataServiceValidator.validateDataService(refreshedDataService);
        cityWeather = ((WeatherDataService) weatherDataService).getCityWeather();
        addWeatherStatistics(cityWeather);
    }

    @Override
    public void displayWeather() {
        consoleView.displayWeatherStatisticToConsole(loadWeatherStatistic());
    }

    public void addWeatherStatistics(CityWeather cityWeather) {
        CityWeatherStatisticUtil.saveToStatisticDB(cityWeather);
    }

    public List<String[]> loadWeatherStatistic() {
        return CityWeatherStatisticUtil.loadFromStatisticDB();
    }

    private void loadThisDevice() {
        weatherDataService.addObserver(this);
        WeatherDataServiceValidator.validateDataService(weatherDataService);
        cityWeather = ((WeatherDataService) weatherDataService).getCityWeather();
        addWeatherStatistics(cityWeather);

    }
}
