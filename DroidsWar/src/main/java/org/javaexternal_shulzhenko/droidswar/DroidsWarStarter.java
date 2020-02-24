package org.javaexternal_shulzhenko.droidswar;

import org.javaexternal_shulzhenko.droidswar.account.Account;
import org.javaexternal_shulzhenko.droidswar.console.ConsoleView;
import org.javaexternal_shulzhenko.droidswar.controllers.GameMainLauncher;

public class DroidsWarStarter {

    public static void main(String[] args){
        ConsoleView view = new ConsoleView();
        Account account= new Account();
        GameMainLauncher dw = new GameMainLauncher(account, view);
        dw.launchGame();
    }
}
