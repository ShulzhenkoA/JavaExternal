package org.javaexternal_shulzhenko.droidswar;

import org.javaexternal_shulzhenko.droidswar.controllers.AccountCreator;
import org.javaexternal_shulzhenko.droidswar.console.ConsoleView;
import org.javaexternal_shulzhenko.droidswar.controllers.GameMainLauncher;

public class DroidsWarStarter {

    public static void main(String[] args){
        ConsoleView view = new ConsoleView();
        AccountCreator accountCreator = new AccountCreator(view);
        GameMainLauncher dw = new GameMainLauncher(accountCreator, view);
        dw.launchGame();
    }
}
