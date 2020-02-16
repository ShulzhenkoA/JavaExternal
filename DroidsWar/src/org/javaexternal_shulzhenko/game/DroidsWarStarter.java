package org.javaexternal_shulzhenko.game;

import org.javaexternal_shulzhenko.game.controllers.AccountCreator;
import org.javaexternal_shulzhenko.game.console.ConsoleView;
import org.javaexternal_shulzhenko.game.controllers.GameMainLauncher;
import org.javaexternal_shulzhenko.game.factories.DroidFactory;

public class DroidsWarStarter {

    public static void main(String[] args){
        ConsoleView view = new ConsoleView();
        AccountCreator accountCreator = new AccountCreator(view);
        DroidFactory droidFactory = new DroidFactory();
        GameMainLauncher dw = new GameMainLauncher(accountCreator, view, droidFactory);
        dw.launchGame();
    }
}
