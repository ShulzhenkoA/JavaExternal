package org.javaexternal_shulzhenko.weatherapp.console;

import org.javaexternal_shulzhenko.weatherapp.cityweather.CityWeather;

import java.util.List;

public class ConsoleView {

    public void displayWeatherStatisticToConsole(List<String[]> statistic){
        System.out.println("\n\n________________________________________________WEATHER STATISTIC" +
                "________________________________________________\n");
        for (String[] statisticSet : statistic) {
            displaySetToConsole(statisticSet);
        }
    }

    private void displaySetToConsole(String[] statisticSet){
        System.out.printf("%s at %s the weather in %s was : Temperature - %sC; humidity - %s%%; pressure - %smbar\n",
               statisticSet[4], statisticSet[5], statisticSet[0], statisticSet[1], statisticSet[2], statisticSet[3]);
    }

    public void displayWeatherObjectToConsole(CityWeather cityWeather){
        System.out.printf("\nCurrent weather conditions %s at %s in %s : \n\t\tTemperature - %sC \n\t\tHumidity - %s%% \n\t\tPressure - %smbar",
                cityWeather.getLocalDateTimeInStrings()[0], cityWeather.getLocalDateTimeInStrings()[1],
                cityWeather.getCity(),cityWeather.getTemperature(), cityWeather.getHumidity(), cityWeather.getPressure());
    }
}
