package org.javaexternal_shulzhenko.weatherapp.services;

import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.model.CurrentWeather;
import net.aksingh.owmjapis.model.param.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javaexternal_shulzhenko.weatherapp.cityweather.CityWeather;
import org.javaexternal_shulzhenko.weatherapp.exceptions.InvalidWeatherDataException;

import java.util.Observable;

public class WeatherDataService extends Observable {

    private static final Logger LOGGER = LogManager.getLogger(WeatherDataService.class);
    private OWM owm;
    private CurrentWeather currentWeather;
    private OWM.Country countryCode;
    private String city;
    private CityWeather cityWeather;


    public WeatherDataService(String apiKey, String city, OWM.Country countryCode) {
        this.city = city;
        this.countryCode = countryCode;
        setUpWeatherData(apiKey);
    }

    public void refreshCityWeather(){
        loadCurrentWeatherFromOWM();
        try {
            validateExtractedData();
            cityWeatherChanged();
        }catch (InvalidWeatherDataException exc){
            LOGGER.error(exc);
            exc.printStackTrace();
        }
    }

    public void cityWeatherChanged(){
        setChanged();
        notifyObservers();
    }

    public void validateExtractedData() throws InvalidWeatherDataException{
        if(!(currentWeather.hasRespCode() && currentWeather.getRespCode() == 200 && currentWeather.hasMainData())){
            throw new InvalidWeatherDataException();
        }
    }

    public CityWeather getCityWeather() {
        return cityWeather;
    }

    private void setUpWeatherData(String apiKey) {
        owm = new OWM(apiKey);
        owm.setUnit(OWM.Unit.METRIC);
        loadCurrentWeatherFromOWM();
        setUpCityWeather();
    }

    private void loadCurrentWeatherFromOWM()  {
        try {
            currentWeather = owm.currentWeatherByCityName(city, countryCode);
        } catch (APIException exc) {
            LOGGER.error(exc);
            exc.printStackTrace();
        }
    }

    private void setUpCityWeather() {
        Main mainData = currentWeather.getMainData();
        cityWeather = new CityWeather();
        cityWeather.setCity(city);
        cityWeather.setUpCityWeatherIndicators(
                new double[] {mainData.getTemp(), mainData.getHumidity(), mainData.getPressure()});
    }
}
