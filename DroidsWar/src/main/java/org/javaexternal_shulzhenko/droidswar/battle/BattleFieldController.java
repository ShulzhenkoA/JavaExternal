package org.javaexternal_shulzhenko.droidswar.battle;

import org.apache.log4j.Logger;
import org.javaexternal_shulzhenko.droidswar.console.ConsoleView;
import org.javaexternal_shulzhenko.droidswar.droids.DroidB01;
import org.javaexternal_shulzhenko.droidswar.exceptions.InappropriateDroidsException;

public class BattleFieldController {

    static final Logger LOGGER = Logger.getLogger(BattleFieldController.class.getSimpleName());

    public static void fightSingleRound(DroidB01 firstDroid, DroidB01 secondDroid) throws InappropriateDroidsException {
        if(firstDroid.isAlive() && secondDroid.isAlive() && !firstDroid.equals(secondDroid)){
            fight(firstDroid,secondDroid);
        }else {
            throw new InappropriateDroidsException();
        }
        ConsoleView.showResultsOfTheFight(firstDroid,secondDroid);
    }

    public static void fightToEnd(DroidB01 firstDroid, DroidB01 secondDroid) throws InappropriateDroidsException {
        if(firstDroid.isAlive() && secondDroid.isAlive() && !firstDroid.equals(secondDroid)){
            do{
                fight(firstDroid, secondDroid);
                ConsoleView.printBattleBetweenHeader();
                ConsoleView.printDroidInfo(firstDroid);
                ConsoleView.printDroidInfo(secondDroid);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException exc) {
                    LOGGER.error(exc);
                }
            }while(firstDroid.isAlive() && secondDroid.isAlive());
        }else {
            throw new InappropriateDroidsException();
        }
        ConsoleView.showResultsOfTheFight(firstDroid,secondDroid);
    }

    private static void fight(DroidB01 firstDroid, DroidB01 secondDroid){
        firstDroid.attack(secondDroid);
        secondDroid.attack(firstDroid);
    }
}

