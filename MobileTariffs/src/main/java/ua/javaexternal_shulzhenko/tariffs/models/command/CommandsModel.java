package ua.javaexternal_shulzhenko.tariffs.models.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import ua.javaexternal_shulzhenko.tariffs.exceptions.CommandFailedException;
import ua.javaexternal_shulzhenko.tariffs.exceptions.InvalidCommandException;
import ua.javaexternal_shulzhenko.tariffs.exceptions.InvalidTariffException;
import ua.javaexternal_shulzhenko.tariffs.models.tariff.Tariff;
import ua.javaexternal_shulzhenko.tariffs.utils.HTMLTransformer;
import ua.javaexternal_shulzhenko.tariffs.utils.TariffObjectsValidator;
import ua.javaexternal_shulzhenko.tariffs.utils.TariffsStAXBuilder;
import ua.javaexternal_shulzhenko.tariffs.utils.ValidatorSAXXSD;

import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerException;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.List;

public class CommandsModel {

    private static final Logger LOGGER = LogManager.getLogger(CommandsModel.class);
    private HashMap<String, Command> commands;
    private List<Tariff> tariffList;
    private final String[] RESOURCES = new String[]{"resources/tariffs.xml", "resources/tariffs.xsd",
            "resources/tariffs.xsl", "resources/tariffs.html"};

    public CommandsModel() {
        commands = new HashMap<>();
        setUpCommands();
    }

    public List<Tariff> getTariffList() {
        return tariffList;
    }

    public void executeCommand(CommandsNS commandName) throws InvalidCommandException, CommandFailedException {
        Command command = commands.get(commandName.getName());
        command.execute();
    }

    private void setUpCommands() {

        setCommand(CommandsNS.VALIDATE_XML_XSD, () -> {
            try{
                ValidatorSAXXSD.getValidator().validateXML(RESOURCES[0], RESOURCES[1]);
            }catch (SAXException e) {
                LOGGER.error( RESOURCES[0] + " is not valid." + e.getMessage());
                throw new CommandFailedException("Command have been failed due to XML don't match XSD.");
            } catch (IOException e) {
                LOGGER.error(e.getMessage());
                throw new CommandFailedException("Command have been failed due I/O error.");
            }
        });

        setCommand(CommandsNS.BUILD_TARIFFS, () -> {
            TariffsStAXBuilder tariffsStAXBuilder = TariffsStAXBuilder.getTariffsStAXBuilder();
            try {
                tariffsStAXBuilder.buildSetTariffs(RESOURCES[0]);
                tariffList = tariffsStAXBuilder.getTariffs();
            }catch (XMLStreamException exc) {
                LOGGER.error("StAX parsing error! " + exc.getMessage());
                throw new CommandFailedException("Command have been failed due to StAX parsing error.");
            } catch (IOException exc) {
                LOGGER.error("I/O error" + exc.getMessage());
                throw new CommandFailedException("Command have been failed due to I/O error.");
            }
        });

        setCommand(CommandsNS.VALIDATE_TARIFF_OBJECTS, () -> {
            isEmptyTariffsList();
            TariffObjectsValidator tariffValidator = TariffObjectsValidator.getTariffValidator();
            try {
                tariffValidator.validateTariffs(tariffList);
            } catch (InvalidTariffException exc) {
                LOGGER.error(exc);
                throw new CommandFailedException("Command have been failed due to invalid tariff exception.");
            } catch (IllegalAccessException exc) {
                LOGGER.error(exc);
                throw new CommandFailedException("Command have been failed due to illegal access exception.");
            }
        });

        setCommand(CommandsNS.SHOW_TARIFFS_OBJECTS, this::isEmptyTariffsList);

        setCommand(CommandsNS.TRANSFORM_XML_HTML, () -> {
            HTMLTransformer htmlTransformer = HTMLTransformer.getTransformer();
            try {
                htmlTransformer.transformXMLtoHTML(RESOURCES[2], RESOURCES[0]);
            } catch (TransformerException exc) {
                LOGGER.error(exc.getMessage());
                throw new CommandFailedException("Command transforming from XML to HTML failed.");
            }
        });

        setCommand(CommandsNS.OPEN_CREATED_HTML, () -> {
            File file = new File(RESOURCES[3]);
            if (file.exists()) {
                URI url = file.toURI();
                try {
                    Desktop.getDesktop().browse(url);
                } catch (IOException exc) {
                    LOGGER.error(exc.getMessage());
                    throw new CommandFailedException("Command to open HTML file failed.");
                }
            } else {
                throw new InvalidCommandException("Can't open. File isn't create yet.");
            }
        });
    }

    private void isEmptyTariffsList() throws InvalidCommandException {
        if (tariffList == null || tariffList.isEmpty()) {
            throw new InvalidCommandException("Can't execute command. Tariff objects aren't built yet.");
        }
    }

    private void setCommand(CommandsNS commandName, Command command){
        commands.put(commandName.getName(), command);
    }

}
