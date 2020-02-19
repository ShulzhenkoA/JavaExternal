package org.javaexternal_shulzhenko.droidswar.controllers;

import org.javaexternal_shulzhenko.droidswar.account.Account;
import org.javaexternal_shulzhenko.droidswar.console.ConsoleView;
import org.javaexternal_shulzhenko.droidswar.droids.DroidB01;
import org.javaexternal_shulzhenko.droidswar.factories.DroidFactory;
import org.javaexternal_shulzhenko.droidswar.utils.DataBaseConnectingUtil;
import org.javaexternal_shulzhenko.droidswar.utils.DroidsListUtil;
import org.javaexternal_shulzhenko.droidswar.utils.InputDataReaderUtil;

import java.util.ArrayList;
import java.util.List;

public class LoggedAdmin {

    private Account account;
    private ConsoleView consoleView;

    public LoggedAdmin(Account account, ConsoleView consoleView) {
        this.account = account;
        this.consoleView = consoleView;
    }

    public void startGameAsAdmin(){

        String enteredData = null;
        do{
            consoleView.printAdminAccHeader(account);
            enteredData = InputDataReaderUtil.readInputData();
        }while (enteredData.equalsIgnoreCase("quit") ? false :
                enteredData.equals("show dl") ? showAllExistingDroidFromList(DroidsListUtil.retrieveDroidsList()) :
                enteredData.equals("show sdl") ? showAllExistingDroidFromList(DroidsListUtil.retrieveSortedDroidList()) :
                enteredData.equals("show cd") ? showAllExistingDroidFromList(DroidsListUtil.retrieveCombatDroidsFromList()) :
                enteredData.equals("show ncd") ? showAllExistingDroidFromList(DroidsListUtil.retrieveNonCombatDroidsFromList()):
                enteredData.equals("create") ? createNewDroidForList() :
                enteredData.equals("delete") ? deleteDroidFromList() : true);
    }

    private boolean showAllExistingDroidFromList(ArrayList<DroidB01> droids){
        int droidNumber = 1;
        consoleView.printDroidsListHeader();
        for (DroidB01 droid : droids){
            consoleView.printDroidNumberInDroidList(droidNumber);
            consoleView.printDroid(droid);
            droidNumber++;
        }
        return true;
    }

    private boolean createNewDroidForList(){

        String enteredData = null;
        do {
            consoleView.printWhichDroidCreate(account);
            enteredData = InputDataReaderUtil.readInputData();
            DroidB01 droid;
            switch (enteredData){
                case "1":
                    droid = DroidFactory.getDroidFactory().getBasicDroidB01();
                    break;
                case "2":
                    droid = DroidFactory.getDroidFactory().getBattleDroidBD01();
                    break;
                case "3":
                    droid = DroidFactory.getDroidFactory().getBattleDroidBD02();
                    break;
                case "4":
                    droid = DroidFactory.getDroidFactory().getDroidDestroyerDD01();
                    break;
                case "5":
                    droid = DroidFactory.getDroidFactory().getRepairDroidRD01();
                    break;
                default:
                    droid = null;
            }

            if(droid != null){
                DataBaseConnectingUtil.saveDroidToDB(droid.getModel());
                consoleView.printDroidWasCreated(droid);
                DroidsListUtil.loadList();
                break;
            }
        }while (enteredData.equalsIgnoreCase("quit") ? false : true);
        return true;
    }

    private boolean deleteDroidFromList(){
        showAllExistingDroidFromList(DroidsListUtil.retrieveDroidsList());
        List<String> listOfDroidsInDB = DataBaseConnectingUtil.receiveDroidsListFromDB();

        if(listOfDroidsInDB.isEmpty()){
            return true;
        }

        try {
            consoleView.printChooseDroidForDeleting();
            int chosenDroid = Integer.parseInt(InputDataReaderUtil.readInputData());

            if(chosenDroid <= 0 || chosenDroid > listOfDroidsInDB.size()){
                throw new NumberFormatException();
            }
            listOfDroidsInDB.remove(chosenDroid - 1);
            DataBaseConnectingUtil.rewriteDroidsToDB(listOfDroidsInDB);
            DroidsListUtil.loadList();
            consoleView.printDroidWasDeleted();
        }catch (NumberFormatException exc){
            consoleView.printCorrectDroidNumbers();
        }
        return true;
    }
}
