package org.javaexternal_shulzhenko.game.battle;

import org.javaexternal_shulzhenko.game.console.ConsoleView;
import org.javaexternal_shulzhenko.game.droids.Droid;

public class BattleFieldController {

    public static void fightSingleRound(Droid firstDroid, Droid secondDroid){
        if(firstDroid.isAlive() && secondDroid.isAlive()){
            fight(firstDroid,secondDroid);
        }
        ConsoleView.showResultsOfTheFight(firstDroid,secondDroid);
    }

    public static void fightToTheEnd(Droid firstDroid, Droid secondDroid) {
        if(firstDroid.isAlive() && secondDroid.isAlive()){
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
        }
        ConsoleView.showResultsOfTheFight(firstDroid,secondDroid);
    }

    private static void fight(Droid firstDroid, Droid secondDroid){
        firstDroid.attack(secondDroid);
        secondDroid.attack(firstDroid);
    }
}

