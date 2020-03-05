package org.javaexternal_shulzhenko.weatherapp.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javaexternal_shulzhenko.weatherapp.exceptions.InvalidWeatherDataException;
import org.javaexternal_shulzhenko.weatherapp.services.WeatherDataService;

import java.util.Observable;

public class WeatherDataServiceValidator {
    private static final Logger LOGGER = LogManager.getLogger(WeatherDataServiceValidator.class);
    public static void validateDataService(Observable observable){
        try {
            if(!(observable instanceof WeatherDataService)){
                throw new InvalidWeatherDataException();
            }
        }catch (InvalidWeatherDataException exc){
            LOGGER.error(exc);
            exc.printStackTrace();
        }
    }
}
