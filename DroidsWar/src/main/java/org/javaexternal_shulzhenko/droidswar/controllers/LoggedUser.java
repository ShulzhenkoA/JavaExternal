package org.javaexternal_shulzhenko.droidswar.controllers;

import org.javaexternal_shulzhenko.droidswar.account.Account;
import org.javaexternal_shulzhenko.droidswar.battle.BattleFieldController;
import org.javaexternal_shulzhenko.droidswar.console.ConsoleView;
import org.javaexternal_shulzhenko.droidswar.droids.Droid;
import org.javaexternal_shulzhenko.droidswar.exceptions.InappropriateDroidsException;
import org.javaexternal_shulzhenko.droidswar.factories.DroidFactory;
import org.javaexternal_shulzhenko.droidswar.utils.DataBaseConnectingUtil;
import org.javaexternal_shulzhenko.droidswar.utils.InputDataReaderUtil;

import java.util.ArrayList;
import java.util.List;

public class LoggedUser {

    private Account account;
    private ConsoleView consoleView;
    private DroidFactory droidFactory;
    private List<Droid> droids;

    public LoggedUser(Account account, ConsoleView consoleView, DroidFactory droidFactory) {
        this.account = account;
        this.consoleView = consoleView;
        this.droidFactory = droidFactory;
    }

    public void startGameAsUser(){

        String enteredData = null;
        do{
            consoleView.printUserAccHeader(account);
            enteredData = InputDataReaderUtil.readInputData();
        }while (enteredData.equalsIgnoreCase("quit") ? false :
                enteredData.equals("battle") ? makeDroidsBattle() :
                enteredData.equals("show") ? showDroidList() : true);
    }

    private boolean makeDroidsBattle() {

        showDroidList();
        try {
            consoleView.printChooseTwoDroids();
            int firstChosenDroid = Integer.parseInt(InputDataReaderUtil.readInputData());

            consoleView.printChooseSecondDroid();
            int secondChosenDroid = Integer.parseInt(InputDataReaderUtil.readInputData());

            if(firstChosenDroid <= 0 || firstChosenDroid > droids.size() ||
                    secondChosenDroid <= 0 || secondChosenDroid > droids.size()){
                throw new NumberFormatException();
            }
            BattleFieldController.fightToEnd(droids.get(firstChosenDroid-1),droids.get(secondChosenDroid-1));
        }catch (InappropriateDroidsException exc){
            consoleView.printBattleBetweenSameDroids();
        }catch (NumberFormatException exc){
            consoleView.printCorrectDroidNumbers();
        }
        return true;
    }

    private boolean showDroidList() {

        List<String> listOfDroidsInDB = DataBaseConnectingUtil.receiveDroidsFromDB();
        droids = new ArrayList<>();
        int droidNumber = 1;

        for(String droidModel: listOfDroidsInDB){
            droids.add(droidFactory.createDroid(droidModel));
        }
        consoleView.printDroidsListHeader();
        for (Droid droid : droids){
            consoleView.printDroidNumberInDroidList(droidNumber);
            consoleView.printDroid(droid);
            droidNumber++;
        }
        return true;
    }
}
