package ua.javaexternal_shulzhenko.tariffs.controller;

import ua.javaexternal_shulzhenko.tariffs.command.CommandsModel;
import ua.javaexternal_shulzhenko.tariffs.command.CommandsNS;

public class AppController {
    private CommandsModel commandsModel;
    public AppController(CommandsModel commandsModel) {
        this.commandsModel = commandsModel;

    }
}
