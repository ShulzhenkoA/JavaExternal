package org.javaexternal_shulzhenko.droidswar.controllers;

import org.javaexternal_shulzhenko.droidswar.account.Account;
import org.javaexternal_shulzhenko.droidswar.console.ConsoleView;
import org.javaexternal_shulzhenko.droidswar.utils.InputDataReaderUtil;
import org.javaexternal_shulzhenko.droidswar.utils.UsersDataBaseUtil;
import org.javaexternal_shulzhenko.droidswar.utils.ValidateInputDataUtil;

public class AccCreator {

    private String inputData;

    private ConsoleView consoleView;
    private Account account;

    public AccCreator(Account account, ConsoleView consoleView){
        this.account = account;
        this.consoleView = consoleView;
    }

    public boolean launchAccountCreator(){
        consoleView.printCreatingAccHeader();
        if(createNickName() && createPassword() && setAdminStatusAs()){
            UsersDataBaseUtil.saveAccToDB(account);
            consoleView.printAccountCreated();
        }
        return true;
    }

    private boolean createNickName() {
        do{
            consoleView.printEnterNickName();
            inputData = InputDataReaderUtil.readInputData();
            if(ValidateInputDataUtil.validateEnteredNickname(inputData)){
                account.setNickname(inputData);
                return true;
            }else if (!inputData.equals("quit")){
                consoleView.printInvalidNickname();
            }
        }while (!inputData.equals("quit"));
        return false;
    }

    private boolean createPassword() {
        do{
            consoleView.printEnterPassword();
            inputData = InputDataReaderUtil.readInputData();
            if(ValidateInputDataUtil.validateEnteredPassword(inputData)){
                account.setPassword(inputData);
                return true;
            }else if (!inputData.equals("quit")) {
                consoleView.printInvalidPassword();
            }
        }while (!inputData.equals("quit"));
        return false;
    }

    private boolean setAdminStatusAs() {
        do {
            consoleView.printCreateAdmOrUserAcc();
            inputData = InputDataReaderUtil.readInputData();
            if (inputData.equalsIgnoreCase("admin")) {
                account.setAdmin(true);
                return true;
            } else if (inputData.equalsIgnoreCase("user")) {
                account.setAdmin(false);
                return true;
            }
        } while (!inputData.equals("quit"));
        return false;
    }
}
