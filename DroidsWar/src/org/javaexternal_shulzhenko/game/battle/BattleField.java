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
        int damageFirstDroid = firstDroid.attack() - generateDefence(secondDroid);
        int damageSecondDroid = secondDroid.attack() - generateDefence(firstDroid);


        if(damageFirstDroid<0){ damageFirstDroid = 0; }
        if(damageSecondDroid<0){damageSecondDroid = 0;}

        firstDroid.receiveDamage(damageSecondDroid);
        secondDroid.receiveDamage(damageFirstDroid);
    }

    private static int generateDefence(Droid droid){

        int def = droid.getDefence();
        Random random = new Random();
        if(def > random.nextInt(99)){
            return def;
        }else{
            return 0;
        }
    }
}

