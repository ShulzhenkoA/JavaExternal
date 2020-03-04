package org.javaexternal_shulzhenko.weatherapp.devices;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javaexternal_shulzhenko.weatherapp.cityweather.CityWeather;
import org.javaexternal_shulzhenko.weatherapp.console.ConsoleView;
import org.javaexternal_shulzhenko.weatherapp.exceptions.InvalidWeatherDataException;
import org.javaexternal_shulzhenko.weatherapp.services.WeatherDataService;
import org.javaexternal_shulzhenko.weatherapp.utils.CityWeatherStatisticUtil;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class WeatherStatisticsDevice implements Observer, Display {
    
    private final static Logger LOGGER = LogManager.getLogger(WeatherStatisticsDevice.class);
    private Observable weatherData;
    private CityWeatherStatisticUtil cityWeatherStatistics;
    private ConsoleView consoleView;
    
    public WeatherStatisticsDevice(Observable weatherData, ConsoleView consoleView) {
        this.weatherData = weatherData;
        this.consoleView = consoleView;
        loadThisDevice();
    }
    
    @Override
    public void update(Observable newData, Object arg) {
        weatherDataValidator(newData);
        CityWeather cityWeather = ((WeatherDataService)weatherData).getCityWeather();
        addWeatherStatistics(cityWeather);
    }

    @Override
    public void displayWeather() {
        consoleView.displayWeatherStatisticToConsole(loadWeatherStatistic());
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

    public void addWeatherStatistics(CityWeather cityWeather) {
        cityWeatherStatistics.saveToStatisticDB(cityWeather);
    }

    public List<String[]> loadWeatherStatistic() {
        return cityWeatherStatistics.loadFromStatisticDB();
    }

    private void loadThisDevice() {
        weatherData.addObserver(this);
        cityWeatherStatistics = new CityWeatherStatisticUtil();
    }
}
