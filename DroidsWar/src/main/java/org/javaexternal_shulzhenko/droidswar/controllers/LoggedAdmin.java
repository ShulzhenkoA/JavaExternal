package org.javaexternal_shulzhenko.droidswar.controllers;

import org.javaexternal_shulzhenko.droidswar.account.Account;
import org.javaexternal_shulzhenko.droidswar.console.ConsoleView;
import org.javaexternal_shulzhenko.droidswar.droids.Droid;
import org.javaexternal_shulzhenko.droidswar.factories.DroidFactory;
import org.javaexternal_shulzhenko.droidswar.utils.DataBaseConnectingUtil;
import org.javaexternal_shulzhenko.droidswar.utils.InputDataReaderUtil;

import java.util.ArrayList;
import java.util.List;

public class LoggedAdmin {

    private Account account;
    private ConsoleView consoleView;
    private DroidFactory droidFactory;
    private List<String> listOfDroidsInDB;
    private List<Droid> droids;

    public LoggedAdmin(Account account, ConsoleView consoleView, DroidFactory droidFactory) {
        this.account = account;
        this.consoleView = consoleView;
        this.droidFactory = droidFactory;
    }

    public void startGameAsAdmin(){

        String enteredData = null;
        do{
            consoleView.printAdminAccHeader(account);
            enteredData = InputDataReaderUtil.readInputData();
        }while (enteredData.equalsIgnoreCase("quit") ? false :
                enteredData.equals("show") ? showAllCreatedDroidFromList() :
                enteredData.equals("create") ? createNewDroidForList() :
                enteredData.equals("delete") ? deleteDroidFromList() : true);
    }

    private boolean showAllCreatedDroidFromList(){

        listOfDroidsInDB = DataBaseConnectingUtil.receiveDroidsFromDB();
        droids = new ArrayList<>();
        int droidNumber = 1;

        if(listOfDroidsInDB.isEmpty()){
            consoleView.printDroidsListHeader();
            consoleView.printEmptyDroidsList();
            return true;
        }

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

    private boolean createNewDroidForList(){

        String enteredData = null;
        do {
            consoleView.printWhichDroidCreate(account);
            enteredData = InputDataReaderUtil.readInputData();
            Droid droid;
            switch (enteredData){
                case "1":
                    droid = droidFactory.getBasicDroidD01();
                    break;
                case "2":
                    droid = droidFactory.getBattleDroidBD01();
                    break;
                case "3":
                    droid = droidFactory.getBattleDroidBD02();
                    break;
                case "4":
                    droid = droidFactory.getDroidDestroyerDD01();
                    break;
                case "5":
                    droid = droidFactory.getRepairDroidR1();
                    break;
                default:
                    droid = null;
            }

            if(droid != null){
                DataBaseConnectingUtil.saveDroidToDB(droid.getModel());
                consoleView.printDroidWasCreated(droid);
                break;
            }
        }while (enteredData.equalsIgnoreCase("quit") ? false : true);
        return true;
    }

    private boolean deleteDroidFromList(){
        showAllCreatedDroidFromList();
        try {
            if(listOfDroidsInDB.isEmpty()){
                return true;
            }

            consoleView.printChooseDroidForDeleting();
            int chosenDroid = Integer.parseInt(InputDataReaderUtil.readInputData());

            if(chosenDroid <= 0 || chosenDroid > droids.size()){
                throw new NumberFormatException();
            }
            listOfDroidsInDB.remove(chosenDroid - 1);
            DataBaseConnectingUtil.rewriteDroidsToDB(listOfDroidsInDB);
            consoleView.printDroidWasDeleted();
        }catch (NumberFormatException exc){
            consoleView.printCorrectDroidNumbers();
        }
        return true;
    }
}
