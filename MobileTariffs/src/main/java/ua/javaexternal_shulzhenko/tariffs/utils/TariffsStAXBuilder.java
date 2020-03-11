package ua.javaexternal_shulzhenko.tariffs.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.javaexternal_shulzhenko.tariffs.models.Tariff;
import ua.javaexternal_shulzhenko.tariffs.models.TariffEnum;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class TariffsStAXBuilder {

    private static TariffsStAXBuilder tariffsStAXBuilder = new TariffsStAXBuilder();
    private static Logger LOGGER = LogManager.getLogger(TariffsStAXBuilder.class);
    private List<Tariff> tariffs = new LinkedList<>();
    private XMLInputFactory inputFactory;

    public TariffsStAXBuilder() {
        inputFactory = XMLInputFactory.newInstance();
    }

    public static TariffsStAXBuilder getTariffsStAXBuilder() {
        return tariffsStAXBuilder;
    }

    public List<Tariff> getTariffs() {
        return tariffs;
    }

    public void buildSetTariffs(String fileName) {

        XMLStreamReader reader = null;
        String name;

        try(FileInputStream inputStream = new FileInputStream(new File(fileName))) {

            reader = inputFactory.createXMLStreamReader(inputStream);
            if(reader.hasNext()){
                reader.next();
                int type;
                while (reader.hasNext() && ((type = reader.next())!= XMLStreamConstants.END_DOCUMENT)) {
                    if (type == XMLStreamConstants.START_ELEMENT) {
                        name = reader.getLocalName();
                        if (TariffEnum.valueOf(name.toUpperCase()) == TariffEnum.TARIFF) {
                            Tariff tariff = buildTariff(reader);
                            tariffs.add(tariff);
                        }
                    }
                }
                reader.close();
            }
        } catch (XMLStreamException exc) {
            LOGGER.error("StAX parsing error! " + exc.getMessage());
        } catch (FileNotFoundException exc) {
            LOGGER.error("File " + fileName + " not found! " + exc);
        } catch (IOException exc) {
            LOGGER.error("I/O error" + exc.getMessage());
        }
    }
    private Tariff buildTariff(XMLStreamReader reader) throws XMLStreamException {

        Tariff tariff = new Tariff();
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    double price;
                    switch (TariffEnum.valueOf(name.toUpperCase())) {
                        case NAME:
                            tariff.setName(getXMLText(reader));
                            break;
                        case OPERATOR_NAME:
                            tariff.setOperatorName(getXMLText(reader));
                            break;
                        case PAYROLL:
                            name = getXMLText(reader);
                            price = Double.parseDouble(name);
                            tariff.setPayroll(price);
                            break;
                        case CALL_PRICES:
                            tariff.setCallPrices(getXMLPrices(reader));
                            break;
                        case SMS:
                            name = getXMLText(reader);
                            price = Double.parseDouble(name);
                            tariff.setSms(price);
                            break;
                        case PARAMETERS:
                            tariff.setParameters(getXMLParameters(reader));
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (TariffEnum.valueOf(name.toUpperCase()) == TariffEnum.TARIFF) {
                        return tariff;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag tariff");
    }

    private Tariff.CallPrices getXMLPrices(XMLStreamReader reader) throws XMLStreamException {
        Tariff.CallPrices callPrices = new Tariff.CallPrices();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    double price = Double.parseDouble(getXMLText(reader));
                    switch (TariffEnum.valueOf(name.toUpperCase())) {
                        case WITHING_NETWORK:
                            callPrices.setWithingNetwork(price);
                            break;
                        case OUTSIDE_NETWORK:
                            callPrices.setOutsideNetwork(price);
                            break;
                        case STATIONARY_PHONES:
                            callPrices.setStationaryPhones(price);
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (TariffEnum.valueOf(name.toUpperCase()) == TariffEnum.CALL_PRICES) {
                        return callPrices;
                    }
                    break;
                }
        }
        throw new XMLStreamException("Unknown element in tag call_prices");
    }

    private Tariff.Parameters getXMLParameters(XMLStreamReader reader) throws XMLStreamException {
        Tariff.Parameters parameters = new Tariff.Parameters();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (TariffEnum.valueOf(name.toUpperCase())) {
                        case FAVOURITE_NUMBER:
                            parameters.setFavouriteNumbers(getXMLText(reader));
                            break;
                        case TARIFFING:
                            parameters.setTariffing(getXMLText(reader));
                            break;
                        case TARIFF_CONNECTION_FEE:
                            parameters.setTariffConnectionFee(getXMLText(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (TariffEnum.valueOf(name.toUpperCase()) == TariffEnum.PARAMETERS) {
                        return parameters;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag call_prices");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}
