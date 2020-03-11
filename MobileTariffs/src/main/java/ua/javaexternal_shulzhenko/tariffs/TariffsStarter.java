package ua.javaexternal_shulzhenko.tariffs;

import ua.javaexternal_shulzhenko.tariffs.command.CommandsNS;
import ua.javaexternal_shulzhenko.tariffs.command.CommandsModel;
import ua.javaexternal_shulzhenko.tariffs.exceptions.InvalidCommandException;
import ua.javaexternal_shulzhenko.tariffs.models.Tariff;
import ua.javaexternal_shulzhenko.tariffs.utils.HTMLTransformer;
import ua.javaexternal_shulzhenko.tariffs.utils.TariffObjectsValidator;
import ua.javaexternal_shulzhenko.tariffs.utils.TariffsStAXBuilder;
import ua.javaexternal_shulzhenko.tariffs.utils.ValidatorSAXXSD;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.util.List;

public class TariffsStarter {
    private static List<Tariff> tariffings;

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException, IOException, InvalidCommandException {

        //ValidatorSAXXSD.getValidator().validateXML("resources/tariffs.xml","resources/tariffs.xsd");
        //HTMLTransformer htmlTransformer = HTMLTransformer.getTransformer();
        //htmlTransformer.transformXMLtoHTML("resources/tariffs.xsl", "resources/fo.xml");

        /*TariffsStAXBuilder tariffsStAXBuilder = new TariffsStAXBuilder();

        tariffsStAXBuilder.buildSetTariffs("resources/tariffs.xml");
        System.out.println(tariffsStAXBuilder.getTariffs());
        TariffValidator tariffValidator = new TariffValidator();
        Tariff tariff = tariffsStAXBuilder.getTariffs().get(2);
        System.out.println(tariff.getCallPrices().getOutsideNetwork());
        //tariffValidator.validateTariffs(tariff);
        System.out.println("validation was successful");
        */

        CommandsModel commandsModel = new CommandsModel();

        commandsModel.executeCommand(CommandsNS.VALIDATE_XML_XSD);
        commandsModel.executeCommand(CommandsNS.BUILD_TARIFFS);
        commandsModel.executeCommand(CommandsNS.VALIDATE_TARIFF_OBJECTS);
        commandsModel.executeCommand(CommandsNS.TRANSFORM_XML_HTML);
        commandsModel.executeCommand(CommandsNS.OPEN_CREATED_HTML);
    }
}
