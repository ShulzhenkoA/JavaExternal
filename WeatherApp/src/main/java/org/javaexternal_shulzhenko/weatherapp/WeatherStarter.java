package org.javaexternal_shulzhenko.weatherapp;

import net.aksingh.owmjapis.core.OWM;
import org.javaexternal_shulzhenko.weatherapp.cityweather.CityWeather;
import org.javaexternal_shulzhenko.weatherapp.console.ConsoleView;
import org.javaexternal_shulzhenko.weatherapp.devices.CurrentWeatherDevice;
import org.javaexternal_shulzhenko.weatherapp.devices.WeatherStatisticsDevice;
import org.javaexternal_shulzhenko.weatherapp.services.WeatherDataService;

public class WeatherStarter {
    public static void main(String[] args) {

        WeatherDataService wd = new WeatherDataService(args[0], args[1], OWM.Country.UKRAINE);
        ConsoleView consoleView = new ConsoleView();
        CityWeather cityWeather = new CityWeather();
        WeatherStatisticsDevice ws = new WeatherStatisticsDevice(wd, consoleView);
        CurrentWeatherDevice cw = new CurrentWeatherDevice(wd, cityWeather, consoleView);
        cw.displayWeather();
        ws.displayWeather();
        wd.refreshCityWeather();
        cw.displayWeather();
        ws.displayWeather();

    }
}
