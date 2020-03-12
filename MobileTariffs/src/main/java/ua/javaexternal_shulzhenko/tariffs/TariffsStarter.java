package ua.javaexternal_shulzhenko.tariffs;

import ua.javaexternal_shulzhenko.tariffs.consoleView.ConsoleView;
import ua.javaexternal_shulzhenko.tariffs.controller.AppController;
import ua.javaexternal_shulzhenko.tariffs.models.command.CommandsModel;

public class TariffsStarter {

    public static void main(String[] args){
        CommandsModel commandsModel = new CommandsModel();
        ConsoleView consoleView = new ConsoleView();
        AppController appController = new AppController(commandsModel, consoleView);
        appController.runApp();
    }
}
