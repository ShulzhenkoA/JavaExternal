package org.javaexternal_shulzhenko.droidswar.controllers;

import org.javaexternal_shulzhenko.droidswar.account.Account;
import org.javaexternal_shulzhenko.droidswar.console.ConsoleView;
import org.javaexternal_shulzhenko.droidswar.droids.DroidB01;
import org.javaexternal_shulzhenko.droidswar.factories.DroidFactory;
import org.javaexternal_shulzhenko.droidswar.utils.DroidsListDataBaseUtil;
import org.javaexternal_shulzhenko.droidswar.utils.DroidsListUtil;
import org.javaexternal_shulzhenko.droidswar.utils.InputDataReaderUtil;
import org.javaexternal_shulzhenko.droidswar.utils.SerializedDroidsListUtil;

import java.util.ArrayList;

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
                enteredData.equals("show dl") ? consoleView.showDroidsList(DroidsListUtil.retrieveDroidsList()) :
                enteredData.equals("show sdl") ? consoleView.showDroidsList(DroidsListUtil.retrieveSortedDroidList()) :
                enteredData.equals("show cd") ? consoleView.showDroidsList(DroidsListUtil.retrieveCombatDroidsFromList()) :
                enteredData.equals("show ncd") ? consoleView.showDroidsList(DroidsListUtil.retrieveNonCombatDroidsFromList()):
                enteredData.equals("create") ? createNewDroidForList("public") :
                enteredData.equals("delete") ? deleteDroidFromList(DroidsListUtil.retrieveDroidsList(), "public") :
                enteredData.equals("show pdl") ? consoleView.showDroidsList(SerializedDroidsListUtil.retrieveDroidsList()):
                enteredData.equals("show psdl") ? consoleView.showDroidsList(SerializedDroidsListUtil.retrieveSortedDroidList()):
                enteredData.equals("create pdl") ? createNewDroidForList("private"):
                enteredData.equals("delete pdl") ? deleteDroidFromList(SerializedDroidsListUtil.retrieveDroidsList(), "private") : true);
    }

    private boolean createNewDroidForList(String typeOfList){

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

            if(droid != null && typeOfList.equals("public")){
                DroidsListDataBaseUtil.saveDroidToDB(droid.getModel());
                DroidsListUtil.loadList();
                consoleView.printDroidWasCreated(droid);
                break;
            }else if(droid != null && typeOfList.equals("private")){
                SerializedDroidsListUtil.addDroidToList(droid);
                consoleView.printDroidWasCreated(droid);
                break;
            }
        }while (enteredData.equalsIgnoreCase("quit") ? false : true);
        return true;
    }

    private boolean deleteDroidFromList(ArrayList<DroidB01> droids, String typeOfList){
        consoleView.printDroidsListHeader();
        consoleView.showDroidsList(droids);
        if(droids.isEmpty()){
            return true;
        }

        try {
            consoleView.printChooseDroidForDeleting();
            int chosenDroid = Integer.parseInt(InputDataReaderUtil.readInputData());

            if(chosenDroid <= 0 || chosenDroid > droids.size()){
                throw new NumberFormatException();
            }
            ;
            if(typeOfList.equals("public")){
                droids.remove(chosenDroid - 1);
                DroidsListDataBaseUtil.rewriteDroidsListToDB(droids);
                DroidsListUtil.loadList();
            }else {
                SerializedDroidsListUtil.deleteDroidFromList(chosenDroid);
            }
            consoleView.printDroidWasDeleted();
        }catch (NumberFormatException exc){
            consoleView.printCorrectDroidNumbers();
        }
        return true;
    }
}
