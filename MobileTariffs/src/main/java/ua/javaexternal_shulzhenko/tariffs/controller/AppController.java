package ua.javaexternal_shulzhenko.tariffs.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.javaexternal_shulzhenko.tariffs.consoleView.ConsoleMessages;
import ua.javaexternal_shulzhenko.tariffs.models.command.CommandsModel;

import ua.javaexternal_shulzhenko.tariffs.consoleView.ConsoleView;
import ua.javaexternal_shulzhenko.tariffs.exceptions.CommandFailedException;
import ua.javaexternal_shulzhenko.tariffs.exceptions.InvalidCommandException;
import ua.javaexternal_shulzhenko.tariffs.models.command.CommandsNS;
import ua.javaexternal_shulzhenko.tariffs.utils.PromptUserUtil;

public class AppController {

    private static final Logger LOGGER = LogManager.getLogger(AppController.class);
    private CommandsModel commandsModel;
    private ConsoleView consoleView;
    public AppController(CommandsModel commandsModel, ConsoleView consoleView) {
        this.commandsModel = commandsModel;
        this.consoleView = consoleView;
    }
    public void runApp() {
        String command;
        do{
            consoleView.printMassage(ConsoleMessages.MENU);
            command = PromptUserUtil.promptUser();
            try {
                switch (command){
                    case "1":
                        commandsModel.executeCommand(CommandsNS.VALIDATE_XML_XSD);
                        consoleView.printMassage(ConsoleMessages.XML_VALIDATED);
                        break;
                    case "2":
                        commandsModel.executeCommand(CommandsNS.TRANSFORM_XML_HTML);
                        consoleView.printMassage(ConsoleMessages.TRANSFORMED_XML_HTML);
                        break;
                    case "3":
                        commandsModel.executeCommand(CommandsNS.OPEN_CREATED_HTML);
                        consoleView.printMassage(ConsoleMessages.OPENED_CREATED_HTML);

                        break;
                    case "4":
                        commandsModel.executeCommand(CommandsNS.BUILD_TARIFFS);
                        consoleView.printMassage(ConsoleMessages.TARIFFS_OBJECTS_BUILT);

                    break;
                    case "5":
                        commandsModel.executeCommand(CommandsNS.VALIDATE_TARIFF_OBJECTS);
                        consoleView.printMassage(ConsoleMessages.TARIFF_OBJECTS_VALIDATED);
                        break;
                    case "6":
                        commandsModel.executeCommand(CommandsNS.SHOW_TARIFFS_OBJECTS);
                        consoleView.printMassage(commandsModel.getTariffList().toString());
                        break;
                    case "7":
                        break;
                    default:
                        throw new InvalidCommandException("Invalid menu command");
                }
            }catch (InvalidCommandException | CommandFailedException exc){
                LOGGER.error(exc.getMessage());
            }
        } while (!command.equals("7"));
    }
}
