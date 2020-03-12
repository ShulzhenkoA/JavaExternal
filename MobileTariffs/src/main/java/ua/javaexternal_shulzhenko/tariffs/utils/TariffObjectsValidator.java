package ua.javaexternal_shulzhenko.tariffs.utils;

import ua.javaexternal_shulzhenko.tariffs.anotations.MobileType;
import ua.javaexternal_shulzhenko.tariffs.anotations.TariffElement;
import ua.javaexternal_shulzhenko.tariffs.exceptions.InvalidTariffException;
import ua.javaexternal_shulzhenko.tariffs.models.tariff.Tariff;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class TariffObjectsValidator {
    private static TariffObjectsValidator tariffValidator = new TariffObjectsValidator();
    private final String[] TARIFF_PROP_ORDER = {"name", "operatorName", "payroll", "callPrices", "sms", "parameters"};
    private final String[] CALL_PRICES_PROP_ORDER = {"withingNetwork", "outsideNetwork", "stationaryPhones"};
    private final String[] PARAMETERS_PROP_ORDER = {"favouriteNumbers", "tariffing", "tariffConnectionFee"};
    private final List<String> OPERATORS = Arrays.asList("Lifecell", "Kyivstar", "Vodafon", "Intertelecom", "3Mob");
    private final List<String> FAVOURITE_NUMBER = Arrays.asList("1 number", "2 numbers", "3 numbers");
    private final List<String> TARIFFING = Arrays.asList("12/sec", "30/sec", "60/sec");
    private final List<String> TARIFF_CONNECTION_FEE = Arrays.asList("0 UAH", "30 UAH", "60 UAH", "90 UAH");

    private Tariff tariff;
    private String tariffName;
    private int tariffCount;

    private TariffObjectsValidator() {
    }

    public static TariffObjectsValidator getTariffValidator() {
        return tariffValidator;
    }

    public void validateTariffs(List<Tariff> tariffs) throws InvalidTariffException, IllegalAccessException {
        for (Tariff tariff: tariffs) {
            this.tariff = tariff;
            tariffCount++;
            Class<? extends Tariff> tariffClass = tariff.getClass();
            validateClass(tariffClass, TARIFF_PROP_ORDER);
            validateTariffClassElements(tariffClass);
        }
    }

    private void validateClass(Class<?> someClass, String[] classPropsTemplate) throws InvalidTariffException {
        if(someClass.isAnnotationPresent(MobileType.class)){
            MobileType tariffAnnotation = someClass.getAnnotation(MobileType.class);
            String typeName = tariffAnnotation.typeName();
            String[] classProps = tariffAnnotation.propOrder();
            if(!typeName.equals(someClass.getSimpleName()) || !Arrays.equals(classProps, classPropsTemplate)){
                throw new InvalidTariffException( someClass.getSimpleName() + " structure.");
            }
        }
    }

    private void validateTariffClassElements(Class<? extends Tariff> tariffClass) throws
            IllegalAccessException, InvalidTariffException {
        Field[] classFields = tariffClass.getDeclaredFields();
        for (Field field : classFields) {
            if(field.isAnnotationPresent(TariffElement.class)){
                TariffElement tariffElementAnnotation = field.getAnnotation(TariffElement.class);
                field.setAccessible(true);
                String name = field.getName();
                switch (name){
                    case "name":
                        validateTariffName(tariffElementAnnotation, field);
                        break;
                    case "operatorName":
                        validateTariffOperatorName(tariffElementAnnotation, field);
                        break;
                    case "payroll":
                        validateTariffPayroll(tariffElementAnnotation, field);
                        break;
                    case "callPrices":
                        validateTariffCallPrices(field);
                        break;
                    case "sms":
                        validateTariffSMS(tariffElementAnnotation, field);
                        break;
                    case "parameters":
                        validateTariffParameters(field);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private void validateTariffName(TariffElement tariffElementAnnotation, Field field) throws
            IllegalAccessException, InvalidTariffException {
        if(tariffElementAnnotation.required()){
            String tariffNameValue = ((String) field.get(tariff));
            tariffName = tariffNameValue;
            if(tariffNameValue.trim().equals("")){
                throw new InvalidTariffException("tariff name in " + tariffCount + "is invalid.");
            }
        }
    }

    private void validateTariffOperatorName(TariffElement tariffElementAnnotation, Field field) throws
            IllegalAccessException, InvalidTariffException {
        if(tariffElementAnnotation.required()){
            String operatorName = (String) field.get(tariff);
            if(OPERATORS.indexOf(operatorName) < 0){
                throw new InvalidTariffException("tariff operator name in " + tariffCount + " tariff \"" +
                        tariffName + "\" is invalid.");
            }
        }
    }

    private void validateTariffPayroll(TariffElement tariffElementAnnotation, Field field) throws
            IllegalAccessException, InvalidTariffException {
        double payroll = field.getDouble(tariff);
        if(payroll<tariffElementAnnotation.minvalue()){
            throw new InvalidTariffException("tariff payroll in " + tariffCount + " tariff \"" + tariffName + "\" is invalid.");
        }
    }

    private void validateTariffSMS(TariffElement tariffElementAnnotation, Field field) throws
            IllegalAccessException, InvalidTariffException {
        double smsPrice = field.getDouble(tariff);
        if(smsPrice<tariffElementAnnotation.minvalue()){
            throw new InvalidTariffException("tariff sms in " + tariffCount + " tariff \"" + tariffName + "\" is invalid.");
        }
    }

    private void validateTariffCallPrices(Field field) throws
            IllegalAccessException, InvalidTariffException {
        Tariff.CallPrices callPrices = (Tariff.CallPrices) field.get(tariff);
        Class<? extends Tariff.CallPrices> callPricesClass = callPrices.getClass();
        validateClass(callPricesClass, CALL_PRICES_PROP_ORDER);
        validateCallPricesClassElements(callPricesClass, callPrices);
    }

    private void validateCallPricesClassElements(Class<? extends Tariff.CallPrices> callPricesClass, Tariff.CallPrices callPrices) throws
            InvalidTariffException, IllegalAccessException {
        Field[] classFields = callPricesClass.getDeclaredFields();
        for (Field field : classFields) {
            if(field.isAnnotationPresent(TariffElement.class)){
                TariffElement tariffElementAnnotation = field.getAnnotation(TariffElement.class);
                field.setAccessible(true);
                double price = field.getDouble(callPrices);
                if(price < tariffElementAnnotation.minvalue()){
                    throw new InvalidTariffException(field.getName() + " price in " + tariffCount + " tariff \"" +
                            tariffName + "\" is invalid.");
                }
            }
        }
    }

    private void validateTariffParameters(Field field) throws
            IllegalAccessException, InvalidTariffException {
        Tariff.Parameters parameters = (Tariff.Parameters) field.get(tariff);
        Class<? extends Tariff.Parameters> parametersClass = parameters.getClass();
        validateClass(parametersClass, PARAMETERS_PROP_ORDER);
        validateParametersClassElements(parametersClass, parameters);
    }

    private void validateParametersClassElements(Class<? extends Tariff.Parameters> parametersClass, Tariff.Parameters parameters) throws
            InvalidTariffException, IllegalAccessException {
        Field[] classFields = parametersClass.getDeclaredFields();

        for (Field field : classFields) {
            if(field.isAnnotationPresent(TariffElement.class)){
                TariffElement tariffElementAnnotation = field.getAnnotation(TariffElement.class);
                field.setAccessible(true);
                String name = field.getName();
                switch (name){
                    case "favouriteNumbers":
                        validateParametersElement(field, parameters, FAVOURITE_NUMBER);
                        break;
                    case "tariffing":
                        validateParametersElement(field, parameters, TARIFFING);
                        break;
                    case "tariffConnectionFee":
                        validateParametersElement(field, parameters, TARIFF_CONNECTION_FEE);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private void validateParametersElement(Field field, Tariff.Parameters parameters, List<String> valuesTemplate) throws
            IllegalAccessException, InvalidTariffException {
        if(field.get(parameters) != null){
            String operatorName = (String) field.get(parameters);
            if(valuesTemplate.indexOf(operatorName) < 0){
                throw new InvalidTariffException(field.getName() + " parameter in " + tariffCount + " tariff \"" +
                        tariffName + "\" is invalid.");
            }
        }
    }
}
