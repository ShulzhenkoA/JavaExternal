package org.javaexternal_shulzhenko.weatherapp.utils;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javaexternal_shulzhenko.weatherapp.cityweather.CityWeather;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CityWeatherStatisticUtil {

    private static final Logger LOGGER = LogManager.getLogger(CityWeatherStatisticUtil.class);
    private static final String STATISTICS_DB_PATH = "src/main/resources/Statistics.csv";

    public void saveToStatisticDB(CityWeather cityWeather){
        try(Writer writer = new FileWriter(new File(STATISTICS_DB_PATH), true)){
            writer.write(cityWeather.toString());
        } catch (IOException exc) {
            LOGGER.error(exc);
        }
    }

    public List<String[]> loadFromStatisticDB() {
        try(BufferedReader reader = new BufferedReader(new FileReader(new File(STATISTICS_DB_PATH)))) {
            String indicatorsSet;
            List<String[]> statistic = new LinkedList<>();
            while((indicatorsSet = reader.readLine()) != null){
                statistic.add(indicatorsSet.split(";"));
            }
            return statistic;
        }catch (IOException exc){
            LOGGER.fatal(exc);
        }
        return null;
    }
}
