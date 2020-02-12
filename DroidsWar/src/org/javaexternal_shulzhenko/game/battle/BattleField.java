package org.javaexternal_shulzhenko.game.battle;

import org.javaexternal_shulzhenko.game.console.ConsoleView;
import org.javaexternal_shulzhenko.game.droids.Droid;

import java.util.Random;

public class BattleField {

    public static void fightSingleRound(Droid firstDroid, Droid secondDroid){
        if(firstDroid.isAlive() && secondDroid.isAlive()){
            fight(firstDroid,secondDroid);
        }
        ConsoleView.showResultsOfTheFight(firstDroid,secondDroid, " 'The single round fight'\n");
    }

    public static void fightToTheEnd(Droid firstDroid, Droid secondDroid){
        if(firstDroid.isAlive() && secondDroid.isAlive()){
            do{
                fight(firstDroid, secondDroid);
            }while(firstDroid.isAlive() && secondDroid.isAlive());
        }
        ConsoleView.showResultsOfTheFight(firstDroid,secondDroid, " 'To the end fight'\n");
    }

    private static void fight(Droid firstDroid, Droid secondDroid){
        int damageFirstDroid = firstDroid.attack() - secondDroid.performDefence();
        int damageSecondDroid = secondDroid.attack() - firstDroid.performDefence();


        if(damageFirstDroid<0){ damageFirstDroid = 0; }
        if(damageSecondDroid<0){damageSecondDroid = 0;}

        firstDroid.receiveDamage(damageSecondDroid);
        secondDroid.receiveDamage(damageFirstDroid);
    }
}

