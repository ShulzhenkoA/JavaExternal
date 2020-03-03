package org.javaexternal_shulzhenko.droidswar.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javaexternal_shulzhenko.droidswar.account.Account;
import org.javaexternal_shulzhenko.droidswar.utils.InputDataReaderUtil;
import org.javaexternal_shulzhenko.droidswar.console.ConsoleView;
import org.javaexternal_shulzhenko.droidswar.utils.ResourceBundleUtil;

import java.util.Locale;

public class GameMainLauncher {

    private static final Logger LOGGER = LogManager.getLogger(GameMainLauncher.class);
    private Account account;
    private ConsoleView consoleView;

    public GameMainLauncher(Account account, ConsoleView consoleView) {
        this.account = account;
        this.consoleView = consoleView;
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
        return new AccCreator(new Account(), consoleView).launchAccountCreator();
    }

    private boolean loginAccount() {
        if(new AccVerifier(account, consoleView).launchAccVerifier()){
            startGameAs();
        }
        return true;
    }

    private void startGameAs() {
        if(account.isAdmin()){
            VerifiedAdmin verifiedAdmin = new VerifiedAdmin(account, consoleView);
            LOGGER.info(account.getNickname() + " entered the game.");
            verifiedAdmin.startGameAsAdmin();
        }else{
            VerifiedUser verifiedUser = new VerifiedUser(account, consoleView);
            LOGGER.info(account.getNickname() + " started the game.");
            verifiedUser.startGameAsUser();
        }
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

