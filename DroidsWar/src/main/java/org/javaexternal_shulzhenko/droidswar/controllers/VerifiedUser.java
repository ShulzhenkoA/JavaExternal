package org.javaexternal_shulzhenko.droidswar.controllers;

import org.apache.log4j.Logger;
import org.javaexternal_shulzhenko.droidswar.account.Account;
import org.javaexternal_shulzhenko.droidswar.battle.BattleFieldController;
import org.javaexternal_shulzhenko.droidswar.console.ConsoleView;
import org.javaexternal_shulzhenko.droidswar.droids.DroidB01;
import org.javaexternal_shulzhenko.droidswar.exceptions.InappropriateDroidsException;
import org.javaexternal_shulzhenko.droidswar.utils.DroidsListUtil;
import org.javaexternal_shulzhenko.droidswar.utils.InputDataReaderUtil;

import java.util.ArrayList;

public class VerifiedUser {
    private static final Logger LOGGER = Logger.getLogger(VerifiedUser.class);
    private Account account;
    private ConsoleView consoleView;

    public VerifiedUser(Account account, ConsoleView consoleView) {
        this.account = account;
        this.consoleView = consoleView;

    }

    public void startGameAsUser(){

        String enteredData = null;
        do{
            consoleView.printUserAccHeader(account);
            enteredData = InputDataReaderUtil.readInputData();
        }while (enteredData.equals("battle") ? makeDroidsBattle(DroidsListUtil.retrieveDroidsList()) :
                enteredData.equals("show sdl") ? consoleView.printDroidsList(DroidsListUtil.retrieveSortedDroidList()) :
                enteredData.equals("show cd") ? consoleView.printDroidsList(DroidsListUtil.retrieveCombatDroidsFromList()) :
                enteredData.equals("show ncd") ? consoleView.printDroidsList(DroidsListUtil.retrieveNonCombatDroidsFromList()):
                enteredData.equals("show dl") ? consoleView.printDroidsList(DroidsListUtil.retrieveDroidsList()) :
                enteredData.equals("show fhpd") ? consoleView.printDroidsList(DroidsListUtil.retrieveDroidsWithFullHP()) :
                enteredData.equalsIgnoreCase("quit") ? false : true);
        LOGGER.info(account.getNickname() + " quit the game.");
    }

    private boolean makeDroidsBattle(ArrayList<DroidB01> droidsList) {
        consoleView.printDroidsList(droidsList);
        int[] numbers;
        if(!droidsList.isEmpty() && (numbers = promptDroidsNumbersFromUser(droidsList ))!= null) {
            try {
                BattleFieldController.fightToEnd(droidsList.get(numbers[0]-1), droidsList.get(numbers[1]-1));
            } catch (InappropriateDroidsException exc) {
                LOGGER.error(exc);
                consoleView.printBattleBetweenSameDroids();
            }
        }
        return true;
    }

    private int[] promptDroidsNumbersFromUser(ArrayList<DroidB01> droidsList) {
        try {
            consoleView.printChooseTwoDroids();
            int firstChosenDroid = Integer.parseInt(InputDataReaderUtil.readInputData());
            consoleView.printChooseSecondDroid();
            int secondChosenDroid = Integer.parseInt(InputDataReaderUtil.readInputData());
            int listSize = droidsList.size();
            if(firstChosenDroid <= 0 || firstChosenDroid > listSize || secondChosenDroid <= 0 || secondChosenDroid > listSize) {
                throw new NullPointerException();
            }
            int[] numbers = {firstChosenDroid,secondChosenDroid};
            return numbers;
        }catch (NullPointerException | NumberFormatException exc){
            LOGGER.error(exc);
            consoleView.printCorrectDroidNumbers();
        }
        return null;
    }

}
