package org.javaexternal_shulzhenko.droidswar.utils;

import org.javaexternal_shulzhenko.droidswar.droids.DroidB01;
import org.javaexternal_shulzhenko.droidswar.droids.abilities.attack.BattleAble;


import java.util.ArrayList;
import java.util.Comparator;

public class DroidsListUtil {

    private static ArrayList<DroidB01> droidsList;

    public static ArrayList<DroidB01> retrieveDroidsList(){
        isNullDroidList();
        return droidsList;
    }

    public static ArrayList<DroidB01> retrieveSortedDroidList(){
        isNullDroidList();
        ArrayList<DroidB01> sortedList = new ArrayList<>();
        for(DroidB01 droid: droidsList) {
            sortedList.add(droid);
        }
        sortedList.sort(Comparator.comparingInt(DroidB01::getMaxHealth));
        return sortedList;
    }

    public static ArrayList<DroidB01> retrieveCombatDroidsFromList(){
        isNullDroidList();
        ArrayList<DroidB01> combatDroids = new ArrayList<>();
        for(DroidB01 droid: droidsList){
           if(droid instanceof BattleAble){
               combatDroids.add(droid);
           }
        }
        return combatDroids;
    }

    public static ArrayList<DroidB01> retrieveNonCombatDroidsFromList(){
        isNullDroidList();
        ArrayList<DroidB01> nonCombatDroids = new ArrayList<>();
        for(DroidB01 droid: droidsList){
            if(!(droid instanceof BattleAble)){
                nonCombatDroids.add(droid);
            }
        }
        return nonCombatDroids;
    }

    public static ArrayList<DroidB01> retrieveDroidsWithFullHP(){
        isNullDroidList();
        ArrayList<DroidB01> fullHPDroids= new ArrayList<>();
        for(DroidB01 droid: droidsList){
            if(droid.getHealth() == droid.getMaxHealth()){
                fullHPDroids.add(droid);
            }
        }
        return fullHPDroids;
    }

    public static void loadList(){
        droidsList = DroidsListDataBaseUtil.receiveDroidsListFromDB();
    }

    private static void isNullDroidList(){
        if(droidsList==null){
            loadList();
        }
    }
}
