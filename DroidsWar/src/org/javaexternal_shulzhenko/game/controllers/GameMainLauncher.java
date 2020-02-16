package org.javaexternal_shulzhenko.game.controllers;

import org.javaexternal_shulzhenko.game.account.Account;
import org.javaexternal_shulzhenko.game.factories.DroidFactory;
import org.javaexternal_shulzhenko.game.utils.InputDataReaderUtil;
import org.javaexternal_shulzhenko.game.utils.DataBaseConnectingUtil;
import org.javaexternal_shulzhenko.game.console.ConsoleView;
import org.javaexternal_shulzhenko.game.utils.ResourceBundleUtil;

import java.util.Locale;

public class GameMainLauncher {

    private AccountCreator accountCreator;
    private ConsoleView consoleView;
    private DroidFactory droidFactory;

    public GameMainLauncher(AccountCreator accountCreator, ConsoleView consoleView, DroidFactory droidFactory) {
        this.accountCreator = accountCreator;
        this.consoleView = consoleView;
        this.droidFactory = droidFactory;
    }

    public void launchGame() {

        String enteredData = null;
        do {
            consoleView.printGreeting();
            enteredData = InputDataReaderUtil.readInputData();
        } while (enteredData.equalsIgnoreCase("quit") ? false :
                enteredData.equalsIgnoreCase("create") ? createAccount() :
                enteredData.equalsIgnoreCase("login") ? loginAccount() :
                enteredData.equalsIgnoreCase("ukr") ? changeUkr() :
                enteredData.equalsIgnoreCase("en") ? changeEn() : true);
    }



    private boolean createAccount() {
        consoleView.printCreatingAccHeader();
        String inputData;
        do {
            consoleView.printEnterNickName();
            inputData = InputDataReaderUtil.readInputData();
        } while (accountCreator.createNickName(inputData));

        do {
            consoleView.printEnterPassword();
            inputData = InputDataReaderUtil.readInputData();
        } while (accountCreator.createPassword(inputData));

        do {
            consoleView.printCreateAdmOrUserAcc();
            inputData = InputDataReaderUtil.readInputData();
            if (inputData.equalsIgnoreCase("admin")) {
                accountCreator.createAsAdmin(true);
                break;
            } else if (inputData.equalsIgnoreCase("user")) {
                accountCreator.createAsAdmin(false);
                break;
            }
        } while (true);
        consoleView.printAccountCreated();
        return true;
    }

    private boolean loginAccount() {

        consoleView.printLoginAccountHeader();

        consoleView.printEnterForLogin();
        String nickname = InputDataReaderUtil.readInputData();

        consoleView.printEnterPasswordForLogin();
        String password = InputDataReaderUtil.readInputData();

        String nicknameFromDB = DataBaseConnectingUtil.receiveUsersDataFromDB(nickname,
                DataBaseConnectingUtil.NICKNAME_RECEIVE_SNIPPET);
        String passwordFromDB = DataBaseConnectingUtil.receiveUsersDataFromDB(nickname,
                DataBaseConnectingUtil.PASSWORD_RECEIVE_SNIPPET);
        if(nickname.equals(nicknameFromDB) && password.equals(passwordFromDB)&& nickname!=null&&password!=null) {

            if("true".equals(DataBaseConnectingUtil.receiveUsersDataFromDB(nickname,
                    DataBaseConnectingUtil.ADMIN_STATUS_RECEIVE_SNIPPET))){
                LoggedAdmin admin = new LoggedAdmin(new Account(nickname, password, true),
                           consoleView, droidFactory);
                admin.startGameAsAdmin();
            }else{
                LoggedUser user = new LoggedUser(new Account(nickname, password, false),
                        consoleView, droidFactory);
                user.startGameAsUser();
            }
        }
        consoleView.printWrongNicknameOrPassword();

        return true;
    }

    private boolean changeUkr(){
        ResourceBundleUtil.INSTANCE.changeResource(new Locale("ukr", "UA"));
        return true;
    }

    private boolean changeEn(){
        ResourceBundleUtil.INSTANCE.changeResource(new Locale("en", "EN"));
        return true;
    }
}

