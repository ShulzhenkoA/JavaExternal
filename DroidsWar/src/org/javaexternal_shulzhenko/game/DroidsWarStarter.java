package org.javaexternal_shulzhenko.game;

import org.javaexternal_shulzhenko.game.account.CreatingAccountModel;
import org.javaexternal_shulzhenko.game.account.LoginAccountModel;
import org.javaexternal_shulzhenko.game.console.ConsoleView;
import org.javaexternal_shulzhenko.game.controllers.SingingInRegistration;

public class DroidsWarStarter {

    public static void main(String[] args){
        CreatingAccountModel crModel = new CreatingAccountModel();
        LoginAccountModel logModel = new LoginAccountModel();
        ConsoleView view = new ConsoleView();
        SingingInRegistration dw = new SingingInRegistration(crModel, logModel,view);
        dw.launchGame();
    }

}
