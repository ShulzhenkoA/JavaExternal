package org.javaexternal_shulzhenko.droidswar.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javaexternal_shulzhenko.droidswar.account.Account;
import org.javaexternal_shulzhenko.droidswar.console.ConsoleView;
import org.javaexternal_shulzhenko.droidswar.droids.DroidB01;
import org.javaexternal_shulzhenko.droidswar.factories.DroidFactory;
import org.javaexternal_shulzhenko.droidswar.utils.DroidsListDataBaseUtil;
import org.javaexternal_shulzhenko.droidswar.utils.DroidsListUtil;
import org.javaexternal_shulzhenko.droidswar.utils.InputDataReaderUtil;
import org.javaexternal_shulzhenko.droidswar.utils.SerializedDroidsListUtil;

import java.util.ArrayList;

public class VerifiedAdmin {

    private static final Logger LOGGER = LogManager.getLogger(VerifiedAdmin.class);
    private Account account;
    private ConsoleView consoleView;

    public VerifiedAdmin(Account account, ConsoleView consoleView) {

        this.account = account;
        this.consoleView = consoleView;
    }

    public void startGameAsAdmin(){

        String enteredData = null;
        do{
            consoleView.printAdminAccHeader(account);
            enteredData = InputDataReaderUtil.readInputData();
        }while (enteredData.equalsIgnoreCase("quit") ? false :
                enteredData.equals("show dl") ? consoleView.printDroidsList(DroidsListUtil.retrieveDroidsList()) :
                enteredData.equals("show sdl") ? consoleView.printDroidsList(DroidsListUtil.retrieveSortedDroidList()) :
                enteredData.equals("show cd") ? consoleView.printDroidsList(DroidsListUtil.retrieveCombatDroidsFromList()) :
                enteredData.equals("show ncd") ? consoleView.printDroidsList(DroidsListUtil.retrieveNonCombatDroidsFromList()):
                enteredData.equals("create") ? createNewDroidForList("public") :
                enteredData.equals("delete") ? deleteDroidFromList(DroidsListUtil.retrieveDroidsList(), "public") :
                enteredData.equals("show pdl") ? consoleView.printDroidsList(SerializedDroidsListUtil.retrieveDroidsList()):
                enteredData.equals("show psdl") ? consoleView.printDroidsList(SerializedDroidsListUtil.retrieveSortedDroidList()):
                enteredData.equals("create pdl") ? createNewDroidForList("private"):
                enteredData.equals("delete pdl") ? deleteDroidFromList(SerializedDroidsListUtil.retrieveDroidsList(), "private") : true);
        LOGGER.info(account.getNickname() + " quit the game.");
    }

    private boolean createNewDroidForList(String typeOfList){
        DroidB01 droid;
        String enteredData = null;
        do {
            consoleView.printWhichDroidCreate(account);
            enteredData = InputDataReaderUtil.readInputData();
            droid = droidCreation(enteredData);
            if(droidSaving(droid, typeOfList)){
                break;
            }
        }while (enteredData.equalsIgnoreCase("quit") ? false : true);
        return true;
    }

    private DroidB01 droidCreation(String enteredData) {
        switch (enteredData){
            case "1":
                return DroidFactory.getDroidFactory().getBasicDroidB01();
            case "2":
                return DroidFactory.getDroidFactory().getBattleDroidBD01();
            case "3":
                return DroidFactory.getDroidFactory().getBattleDroidBD02();
            case "4":
                return DroidFactory.getDroidFactory().getDroidDestroyerDD01();
            case "5":
                return DroidFactory.getDroidFactory().getRepairDroidRD01();
            default:
                return null;
        }
    }

    private boolean droidSaving(DroidB01 droid, String typeOfList) {
        if(droid != null && typeOfList.equals("public")){
            DroidsListDataBaseUtil.saveDroidToDB(droid.getModel());
            DroidsListUtil.loadList();
            consoleView.printDroidWasCreated(droid);
            return true;
        }else if(droid != null && typeOfList.equals("private")){
            SerializedDroidsListUtil.addDroidToList(droid);
            consoleView.printDroidWasCreated(droid);
            return true;
        }
        return false;
    }

    private boolean deleteDroidFromList(ArrayList<DroidB01> droids, String typeOfList){
        consoleView.printDroidsList(droids);
        int droidNum;
        if(droids.isEmpty()){
            return true;
        }else if ((droidNum = promptDroidNumberFromAdmin(droids.size())) != 0 ){
            droidDeleting(droids, typeOfList, droidNum);
        }
        return true;
    }

    private int promptDroidNumberFromAdmin(int listSize) {
        try {
            consoleView.printChooseDroidForDeleting();
            int chosenDroid = Integer.parseInt(InputDataReaderUtil.readInputData());

            if(chosenDroid <= 0 || chosenDroid > listSize){
                throw new NumberFormatException();
            }
            return chosenDroid;
        }catch (NumberFormatException exc){
            LOGGER.error(exc);
            consoleView.printCorrectDroidNumbers();
        }
        return 0;
    }

    private void droidDeleting(ArrayList<DroidB01> droids, String typeOfList, int chosenDroid) {
        if(typeOfList.equals("public")){
            droids.remove(chosenDroid - 1);
            DroidsListDataBaseUtil.rewriteDroidsListToDB(droids);
            DroidsListUtil.loadList();
        }else {
            SerializedDroidsListUtil.deleteDroidFromList(chosenDroid);
        }
        consoleView.printDroidWasDeleted();
    }
}
