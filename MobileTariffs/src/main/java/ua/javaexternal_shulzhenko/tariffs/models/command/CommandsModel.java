package ua.javaexternal_shulzhenko.tariffs.models.command;

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

    public void executeCommand(CommandsNS commandName) {
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
            }catch (SAXException | IOException exc) {
                throw new CommandFailedException("Command have been failed due to: " + exc.getMessage());
            }
        });

        addToCommandsMap(CommandsNS.BUILD_TARIFFS, () -> {
            TariffsStAXBuilder tariffsStAXBuilder = TariffsStAXBuilder.getTariffsStAXBuilder();
            try {
                tariffsStAXBuilder.buildSetTariffs(RESOURCES[0]);
                tariffsFromXML = tariffsStAXBuilder.getTariffs();
            }catch (XMLStreamException | IOException exc) {
                throw new CommandFailedException("Command have been failed due to: " + exc.getMessage());
            }
        });

        addToCommandsMap(CommandsNS.VALIDATE_TARIFF_OBJECTS, () -> {
            isEmptyTariffsList();
            TariffObjectsValidator tariffValidator = TariffObjectsValidator.getTariffValidator();
            try {
                tariffValidator.validateTariffs(tariffsFromXML);
            } catch (InvalidTariffException exc) {
                throw new CommandFailedException("Command have been failed due to: " + exc.getMessage());
            }
        });

        addToCommandsMap(CommandsNS.SHOW_TARIFFS_OBJECTS, this::isEmptyTariffsList);

        addToCommandsMap(CommandsNS.TRANSFORM_XML_HTML, () -> {
            HTMLTransformer htmlTransformer = HTMLTransformer.getTransformer();
            try {
                htmlTransformer.transformXMLtoHTML(RESOURCES[2], RESOURCES[0]);
            } catch (TransformerException exc) {
                throw new CommandFailedException("Command transforming from XML to HTML failed due to" + exc.getMessage());
            }
        });

        addToCommandsMap(CommandsNS.OPEN_CREATED_HTML, () -> {
            File file = new File(RESOURCES[3]);
            if (file.exists()) {
                URI url = file.toURI();
                try {
                    Desktop.getDesktop().browse(url);
                } catch (IOException exc) {
                    throw new CommandFailedException("Command to open HTML file failed due to: " + exc.getMessage());
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
                throw new CommandFailedException("Command of getting tariffs from database failed due to " + exc.getMessage());
            }

        });

        addToCommandsMap(CommandsNS.CLOSE_DAO_CONNECTOR, ()-> {
            if(tariffDAO != null){
                try {
                    tariffDAO.closeConnector();
                } catch (SQLException exc) {
                    throw new CommandFailedException("Command of closing DAO connector failed due to " + exc.getMessage());
                }
            }
        });
    }

    private void addToCommandsMap(CommandsNS commandName, Command command) {
        commands.put(commandName.getName(), command);
    }

    private void isEmptyTariffsList() {
        if (tariffsFromXML == null || tariffsFromXML.isEmpty()) {
            throw new CommandFailedException("Can't execute command. Tariff objects aren't built yet.");
        }
    }

    private void connectToDB() {
        if(tariffDAO == null){
            try {
                tariffDAO = new TariffDAO(new DBConnector(DataBases.MYSQL));
            } catch (SQLException exc) {
                throw new CommandFailedException("Command of adding tariffs to database failed due to " + exc.getMessage());
            }
        }
    }
}
