package org.javaexternal_shulzhenko.droidswar.controllers;

import org.javaexternal_shulzhenko.droidswar.account.Account;
import org.javaexternal_shulzhenko.droidswar.battle.BattleFieldController;
import org.javaexternal_shulzhenko.droidswar.console.ConsoleView;
import org.javaexternal_shulzhenko.droidswar.droids.DroidB01;
import org.javaexternal_shulzhenko.droidswar.exceptions.InappropriateDroidsException;
import org.javaexternal_shulzhenko.droidswar.utils.DroidsListUtil;
import org.javaexternal_shulzhenko.droidswar.utils.InputDataReaderUtil;

import java.util.ArrayList;

public class LoggedUser {

    private Account account;
    private ConsoleView consoleView;

    public LoggedUser(Account account, ConsoleView consoleView) {
        this.account = account;
        this.consoleView = consoleView;
    }

    public void startGameAsUser(){

        String enteredData = null;
        do{
            consoleView.printUserAccHeader(account);
            enteredData = InputDataReaderUtil.readInputData();
        }while (enteredData.equals("battle") ? makeDroidsBattle() :
                enteredData.equals("show sdl") ? showDroidList(DroidsListUtil.retrieveSortedDroidList()) :
                enteredData.equals("show cd") ? showDroidList(DroidsListUtil.retrieveCombatDroidsFromList()) :
                enteredData.equals("show ncd") ? showDroidList(DroidsListUtil.retrieveNonCombatDroidsFromList()):
                enteredData.equals("show dl") ? showDroidList(DroidsListUtil.retrieveDroidsList()) :
                enteredData.equals("show fhpd") ? showDroidList(DroidsListUtil.retrieveDroidsWithFullHP()) :
                enteredData.equalsIgnoreCase("quit") ? false : true);
    }

    private boolean makeDroidsBattle() {

        showDroidList(DroidsListUtil.retrieveDroidsList());
        try {
            consoleView.printChooseTwoDroids();
            int firstChosenDroid = Integer.parseInt(InputDataReaderUtil.readInputData());

            consoleView.printChooseSecondDroid();
            int secondChosenDroid = Integer.parseInt(InputDataReaderUtil.readInputData());

            int listSize = DroidsListUtil.retrieveDroidsList().size();
            if(firstChosenDroid <= 0 || firstChosenDroid > listSize|| secondChosenDroid <= 0 || secondChosenDroid > listSize){
                throw new NumberFormatException();
            }
            BattleFieldController.fightToEnd(DroidsListUtil.retrieveDroidsList().get(firstChosenDroid-1),
                    DroidsListUtil.retrieveDroidsList().get(secondChosenDroid-1));
        }catch (InappropriateDroidsException exc){
            consoleView.printBattleBetweenSameDroids();
        }catch (NumberFormatException exc){
            consoleView.printCorrectDroidNumbers();
        }
        return true;
    }

    private boolean showDroidList(ArrayList<DroidB01> droids) {
        int droidNumber = 1;
        consoleView.printDroidsListHeader();
        for (DroidB01 droid : droids){
            consoleView.printDroidNumberInDroidList(droidNumber);
            consoleView.printDroid(droid);
            droidNumber++;
        }
        return true;
    }
}
