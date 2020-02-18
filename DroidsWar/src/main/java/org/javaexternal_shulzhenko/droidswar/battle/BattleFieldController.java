package org.javaexternal_shulzhenko.droidswar.battle;

import org.javaexternal_shulzhenko.droidswar.console.ConsoleView;
import org.javaexternal_shulzhenko.droidswar.droids.Droid;
import org.javaexternal_shulzhenko.droidswar.exceptions.InappropriateDroidsException;

public class BattleFieldController {

    public static void fightSingleRound(Droid firstDroid, Droid secondDroid) throws InappropriateDroidsException {
        if(firstDroid.isAlive() && secondDroid.isAlive() && !firstDroid.equals(secondDroid)){
            fight(firstDroid,secondDroid);
        }else {
            throw new InappropriateDroidsException();
        }
        ConsoleView.showResultsOfTheFight(firstDroid,secondDroid);
    }

    public static void fightToEnd(Droid firstDroid, Droid secondDroid) throws InappropriateDroidsException {
        if(firstDroid.isAlive() && secondDroid.isAlive() && !firstDroid.equals(secondDroid)){
            do{
                fight(firstDroid, secondDroid);
                ConsoleView.printBattleBetweenHeader();
                ConsoleView.printDroidInfo(firstDroid);
                ConsoleView.printDroidInfo(secondDroid);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }while(firstDroid.isAlive() && secondDroid.isAlive());
        }else {
            throw new InappropriateDroidsException();
        }
        ConsoleView.showResultsOfTheFight(firstDroid,secondDroid);
    }

    private static void fight(Droid firstDroid, Droid secondDroid){
        firstDroid.attack(secondDroid);
        secondDroid.attack(firstDroid);
    }
}

