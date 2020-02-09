package org.javaexternal_shulzhenko.game.console;

import org.javaexternal_shulzhenko.game.droids.Droid;

public class ConsoleView {

    public static void showResultsOfTheFight(Droid firstDroid, Droid secondDroid, String typeOfTheFight){

        String firstDroidInfo;
        String secondDroidInfo;

        if(firstDroid.isAlive()) {
            firstDroidInfo = firstDroid.toString();
        }else{
            firstDroidInfo = firstDroid.getNAME()+firstDroid.getMODEL() + " was defeated";
        }

        if(secondDroid.isAlive()){
            secondDroidInfo = secondDroid.toString();
        }else{
            secondDroidInfo = secondDroid.getNAME()+secondDroid.getMODEL() + " was defeated.";
        }

        String betweenInfo = "= between " + firstDroid.getNAME() + firstDroid.getMODEL() +
                " and " + secondDroid.getNAME() + secondDroid.getMODEL();

        String equalSignsLine = "";

        for(int i = 0; i < betweenInfo.length(); i++){
            equalSignsLine = equalSignsLine.concat("=");
        }
        System.out.println( equalSignsLine +
                            "\n= Result of " + typeOfTheFight +
                            betweenInfo + "\n= Surviving droid info\n"  + equalSignsLine +
                            "\n****************************************************************\n"+ firstDroidInfo +
                            "\n****************************************************************\n" + secondDroidInfo +
                            "\n****************************************************************\n\n");
    }

    public static void printDroidInfo(Droid droid){
        System.out.println("........................Droid Information........................\n" + droid +
                           "\n........................Droid Information........................\n\n");
    }
}
