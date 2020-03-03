package org.javaexternal_shulzhenko.droidswar.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javaexternal_shulzhenko.droidswar.account.Account;
import org.javaexternal_shulzhenko.droidswar.console.ConsoleView;
import org.javaexternal_shulzhenko.droidswar.exceptions.WrongAccNickNameException;
import org.javaexternal_shulzhenko.droidswar.exceptions.WrongAccPasswordException;
import org.javaexternal_shulzhenko.droidswar.utils.InputDataReaderUtil;
import org.javaexternal_shulzhenko.droidswar.utils.UsersDataBaseUtil;

public class AccVerifier {

    private static final Logger LOGGER = LogManager.getLogger(AccVerifier.class);
    Account account;
    Account accountFromDB;
    ConsoleView consoleView;

    public AccVerifier(Account account, ConsoleView consoleView) {
        this.account = account;
        this.consoleView = consoleView;
    }

    public boolean launchAccVerifier() {
        String nickname = promptNickName();
        String password = promptPassword();
        accountFromDB = UsersDataBaseUtil.receiveAccFromProperties(nickname);
        if(verifyAcc(password)){
            setUpVerifiedAcc();
            return true;
        }
        return false;
    }

    public boolean verifyAcc(String password){
        try {
            checkEnteredNickName();
            try {
                checkEnteredPassword(password);
                return true;
            } catch (WrongAccPasswordException exc) {
                LOGGER.warn(exc);
                consoleView.printWrongPassword();
            }
        } catch (WrongAccNickNameException exc) {
            LOGGER.warn(exc);
            consoleView.printWrongNickname();
        }
        return false;
    }

    public void checkEnteredNickName() throws WrongAccNickNameException {
        if (accountFromDB == null) {
            throw new WrongAccNickNameException();
        }
    }

    public void checkEnteredPassword(String password) throws WrongAccPasswordException {
        if (!accountFromDB.getPassword().equals(password)) {
            throw new WrongAccPasswordException();
        }
    }

    private String promptNickName() {
        consoleView.printLoginAccountHeader();
        String nickname;
        do {
            nickname = InputDataReaderUtil.readInputData();
        } while (nickname.trim().equals(""));
        return nickname;
    }

    private String promptPassword() {
        consoleView.printEnterPasswordForLogin();
        String password;
        do {
            password = InputDataReaderUtil.readInputData();

        } while (password.trim().equals(""));
        return password;
    }

    private void setUpVerifiedAcc() {
        account.setNickname(accountFromDB.getNickname());
        account.setPassword(accountFromDB.getPassword());
        account.setAdmin(accountFromDB.isAdmin());
    }
}