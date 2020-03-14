package ua.javaexternal_shulzhenko.tariffs.models.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import ua.javaexternal_shulzhenko.tariffs.connector.DBConnector;
import ua.javaexternal_shulzhenko.tariffs.connector.DataBases;
import ua.javaexternal_shulzhenko.tariffs.dao.TariffDAO;
import ua.javaexternal_shulzhenko.tariffs.exceptions.CommandFailedException;
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
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class CommandsModel {

    private static final Logger LOGGER = LogManager.getLogger(CommandsModel.class);
    private HashMap<String, Command> commands;
    private List<Tariff> tariffsFromXML;
    private List<Tariff> tariffsFromDB;
    private final String[] RESOURCES = new String[]{"resources/tariffs.xml", "resources/tariffs.xsd",
            "resources/tariffs.xsl", "resources/tariffs.html"};
    private TariffDAO tariffDAO;

    public CommandsModel() {
        commands = new HashMap<>();
        setUpCommands();
    }

    public void executeCommand(CommandsNS commandName) throws CommandFailedException {
        Command command = commands.get(commandName.getName());
        command.execute();
    }

    public List<Tariff> getTariffsFromXML() {
        return tariffsFromXML;
    }

    public List<Tariff> getTariffsFromDB() {
        return tariffsFromDB;
    }

    private void setUpCommands() {

        addToCommandsMap(CommandsNS.VALIDATE_XML_XSD, () -> {
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

        addToCommandsMap(CommandsNS.BUILD_TARIFFS, () -> {
            TariffsStAXBuilder tariffsStAXBuilder = TariffsStAXBuilder.getTariffsStAXBuilder();
            try {
                tariffsStAXBuilder.buildSetTariffs(RESOURCES[0]);
                tariffsFromXML = tariffsStAXBuilder.getTariffs();
            }catch (XMLStreamException exc) {
                LOGGER.error("StAX parsing error! " + exc.getMessage());
                throw new CommandFailedException("Command have been failed due to StAX parsing error.");
            } catch (IOException exc) {
                LOGGER.error("I/O error" + exc.getMessage());
                throw new CommandFailedException("Command have been failed due to I/O error.");
            }
        });

        addToCommandsMap(CommandsNS.VALIDATE_TARIFF_OBJECTS, () -> {
            isEmptyTariffsList();
            TariffObjectsValidator tariffValidator = TariffObjectsValidator.getTariffValidator();
            try {
                tariffValidator.validateTariffs(tariffsFromXML);
            } catch (InvalidTariffException exc) {
                LOGGER.error(exc);
                throw new CommandFailedException("Command have been failed due to invalid tariff exception.");
            } catch (IllegalAccessException exc) {
                LOGGER.error(exc);
                throw new CommandFailedException("Command have been failed due to illegal access exception.");
            }
        });

        addToCommandsMap(CommandsNS.SHOW_TARIFFS_OBJECTS, this::isEmptyTariffsList);

        addToCommandsMap(CommandsNS.TRANSFORM_XML_HTML, () -> {
            HTMLTransformer htmlTransformer = HTMLTransformer.getTransformer();
            try {
                htmlTransformer.transformXMLtoHTML(RESOURCES[2], RESOURCES[0]);
            } catch (TransformerException exc) {
                LOGGER.error(exc.getMessage());
                throw new CommandFailedException("Command transforming from XML to HTML failed.");
            }
        });

        addToCommandsMap(CommandsNS.OPEN_CREATED_HTML, () -> {
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
                throw new CommandFailedException("Can't open. File isn't create yet.");
            }
        });

        addToCommandsMap(CommandsNS.ADD_TARIFFS_TO_DB, () -> {
            isEmptyTariffsList();
            connectToDB();
            try {
                tariffDAO.addTariffs(tariffsFromXML);
            } catch (SQLException exc) {
                LOGGER.error(exc.getMessage());
                throw new CommandFailedException("Command of adding tariffs to database failed due to " + exc.getMessage());
            }
        });

        addToCommandsMap(CommandsNS.GET_TARIFFS_FROM_DB, ()-> {
           connectToDB();
            try {
                tariffsFromDB = tariffDAO.getTariffs();
                if(tariffsFromDB.isEmpty()){
                    throw new CommandFailedException("Command failed. Database is empty.");
                }
            }catch (SQLException exc){
                LOGGER.error(exc.getMessage());
                throw new CommandFailedException("Command of getting tariffs from database failed due to " + exc.getMessage());
            }

        });

        addToCommandsMap(CommandsNS.CLOSE_DAO_CONNECTOR, ()-> {
            if(tariffDAO != null){
                try {
                    tariffDAO.closeConnector();
                } catch (SQLException exc) {
                    LOGGER.error(exc.getMessage());
                    throw new CommandFailedException("Command of closing DAO connector failed due to " + exc.getMessage());
                }
            }
        });
    }

    private void addToCommandsMap(CommandsNS commandName, Command command){
        commands.put(commandName.getName(), command);
    }

    private void isEmptyTariffsList() throws CommandFailedException{
        if (tariffsFromXML == null || tariffsFromXML.isEmpty()) {
            throw new CommandFailedException("Can't execute command. Tariff objects aren't built yet.");
        }
    }

    private void connectToDB() throws CommandFailedException {
        if(tariffDAO == null){
            try {
                tariffDAO = new TariffDAO(new DBConnector(DataBases.MYSQL));
            } catch (SQLException exc) {
                LOGGER.error(exc.getMessage());
                throw new CommandFailedException("Command of adding tariffs to database failed due to " + exc.getMessage());
            }
        }
    }
}
