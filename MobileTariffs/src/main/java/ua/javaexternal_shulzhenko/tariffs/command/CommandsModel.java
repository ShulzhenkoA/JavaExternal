package ua.javaexternal_shulzhenko.tariffs.command;

import ua.javaexternal_shulzhenko.tariffs.exceptions.InvalidCommandException;
import ua.javaexternal_shulzhenko.tariffs.models.Tariff;
import ua.javaexternal_shulzhenko.tariffs.utils.HTMLTransformer;
import ua.javaexternal_shulzhenko.tariffs.utils.TariffObjectsValidator;
import ua.javaexternal_shulzhenko.tariffs.utils.TariffsStAXBuilder;
import ua.javaexternal_shulzhenko.tariffs.utils.ValidatorSAXXSD;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.List;

public class CommandsModel {

    private HashMap<String, Command> commands;
    private static List<Tariff> tariffList;
    private final String[] RESOURCES = new String[]{"resources/tariffs.xml", "resources/tariffs.xsd",
            "resources/tariffs.xsl", "resources/tariffs.html"};

    public CommandsModel() {
        commands = new HashMap<>();
        setUpCommands();
    }

    public void executeCommand(CommandsNS commandName) throws InvalidCommandException, IOException {
        Command command = commands.get(commandName.getName());
        command.execute();
    }

    private void setUpCommands() {

        setCommand(CommandsNS.VALIDATE_XML_XSD, () -> ValidatorSAXXSD.getValidator().
                validateXML(RESOURCES[0], RESOURCES[1]));

        setCommand(CommandsNS.BUILD_TARIFFS, () -> {
            TariffsStAXBuilder tariffsStAXBuilder = TariffsStAXBuilder.getTariffsStAXBuilder();
            tariffsStAXBuilder.buildSetTariffs(RESOURCES[0]);
            tariffList = tariffsStAXBuilder.getTariffs();
            System.out.println(tariffList);
        });

        setCommand(CommandsNS.VALIDATE_TARIFF_OBJECTS, () -> {
            TariffObjectsValidator tariffValidator = TariffObjectsValidator.getTariffValidator();
            tariffValidator.validateTariffs(tariffList);
            if (tariffList == null) {
                throw new InvalidCommandException("Can't validate tariff objects. They aren't built yet.");
            }
        });

        setCommand(CommandsNS.TRANSFORM_XML_HTML, () -> {
            HTMLTransformer htmlTransformer = HTMLTransformer.getTransformer();
            htmlTransformer.transformXMLtoHTML(RESOURCES[2], RESOURCES[0]);
        });

        setCommand(CommandsNS.OPEN_CREATED_HTML, () -> {
            File file = new File(RESOURCES[3]);
            if (file.exists()) {
                URI url = file.toURI();
                Desktop.getDesktop().browse(url);
            } else {
                throw new InvalidCommandException("Can't open. File isn't create yet.");
            }
        });
    }

    private void setCommand(CommandsNS commandName, Command command){
        commands.put(commandName.getName(), command);
    }
}
