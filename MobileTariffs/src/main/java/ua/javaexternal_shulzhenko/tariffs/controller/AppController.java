package ua.javaexternal_shulzhenko.tariffs.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.javaexternal_shulzhenko.tariffs.consoleView.ConsoleMessages;
import ua.javaexternal_shulzhenko.tariffs.models.command.CommandsModel;

import ua.javaexternal_shulzhenko.tariffs.consoleView.ConsoleView;
import ua.javaexternal_shulzhenko.tariffs.exceptions.CommandFailedException;
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
        consoleView.printMassage(ConsoleMessages.MENU);
        do{
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
                        consoleView.printMassage(commandsModel.getTariffsFromXML().toString());
                        break;
                    case "7":
                        commandsModel.executeCommand(CommandsNS.VALIDATE_TARIFF_OBJECTS);
                        commandsModel.executeCommand(CommandsNS.ADD_TARIFFS_TO_DB);
                        consoleView.printMassage(ConsoleMessages.TARIFFS_ADDED_TO_DB);
                        break;
                    case "8":
                        commandsModel.executeCommand(CommandsNS.GET_TARIFFS_FROM_DB);
                        consoleView.printMassage(commandsModel.getTariffsFromDB().toString());
                        break;
                    case "9":
                        commandsModel.executeCommand(CommandsNS.CLOSE_DAO_CONNECTOR);
                        break;
                    default:
                        throw new CommandFailedException("Invalid menu command");
                }
            }catch (CommandFailedException exc){
                LOGGER.error(exc.getMessage());
            }
        } while (!command.equals("9"));
    }
}
