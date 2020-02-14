package org.javaexternal_shulzhenko.game.controllers;

import org.javaexternal_shulzhenko.game.account.CreatingAccountModel;
import org.javaexternal_shulzhenko.game.account.LoginAccountModel;
import org.javaexternal_shulzhenko.game.console.ConsoleView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SingingInRegistration {

    private CreatingAccountModel creatingAccountModel;
    private LoginAccountModel loginAccountModel;
    private ConsoleView consoleView;

    public SingingInRegistration(CreatingAccountModel userAccount,
                                 LoginAccountModel loginAccountModel,
                                 ConsoleView consoleView) {
        this.creatingAccountModel = userAccount;
        this.loginAccountModel = loginAccountModel;
        this.consoleView = consoleView;
    }

    public void launchGame() {

        String enteredData = null;
        do {
            consoleView.printGreeting();
            enteredData = readInputData();
        } while (enteredData.equalsIgnoreCase("create") ? createAccount() :
                enteredData.equalsIgnoreCase("login") ? false : true);
    }

    private String readInputData() {
        String data = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            data = br.readLine();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
        return data;
    }

    private boolean createAccount() {
        consoleView.printCreatingAccInfo();
        String inputData;
        do {
            consoleView.printEnterNickName();
            inputData = readInputData();
        } while (creatingAccountModel.setNickName(inputData));

        do {
            consoleView.printEnterPassword();
            inputData = readInputData();
        } while (creatingAccountModel.setPassword(inputData));

        do {
            consoleView.printCreateAdmOrUserAcc();
            inputData = readInputData();
            if (inputData.equalsIgnoreCase("admin")) {
                creatingAccountModel.setAdmin(true);
                break;
            } else if (inputData.equalsIgnoreCase("user")) {
                creatingAccountModel.setAdmin(false);
                break;
            }
        } while (true);
        consoleView.printAccountCreated();
        return false;
    }

    private boolean loginAccount() {
        consoleView.printLoginAccountInfo();
        String inputData;
        do {
            consoleView.printEnterForLogin();
            inputData = readInputData();
            loginAccountModel.setNickName(inputData);

            consoleView.printEnterPasswordForLogin();
            inputData = readInputData();
            loginAccountModel.setPassword(inputData);

            loginAccountModel.verifyUser();

        } while (creatingAccountModel.setNickName(inputData));
        return false;
    }
}

