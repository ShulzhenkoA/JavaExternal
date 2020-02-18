package org.javaexternal_shulzhenko.droidswar;

import org.javaexternal_shulzhenko.droidswar.controllers.AccountCreator;
import org.javaexternal_shulzhenko.droidswar.console.ConsoleView;
import org.javaexternal_shulzhenko.droidswar.controllers.GameMainLauncher;
import org.javaexternal_shulzhenko.droidswar.factories.DroidFactory;

public class DroidsWarStarter {

    public static void main(String[] args){
        ConsoleView view = new ConsoleView();
        AccountCreator accountCreator = new AccountCreator(view);
        DroidFactory droidFactory = new DroidFactory();
        GameMainLauncher dw = new GameMainLauncher(accountCreator, view, droidFactory);
        dw.launchGame();
    }
}
