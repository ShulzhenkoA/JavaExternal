package ua.javaexternal_shulzhenko.tariffs.models.tariff;

public enum TariffEnum {

    TARIFFS("tariffs"),
    TARIFF("tariff"),
    NAME("name"),
    OPERATOR_NAME("operator-name"),
    PAYROLL("payroll"),
    SMS("sms"),
    CALL_PRICES("call_prices"),
    WITHING_NETWORK("withing_network"),
    OUTSIDE_NETWORK("outside_network"),
    STATIONARY_PHONES("stationary_phones"),
    PARAMETERS("parameters"),
    FAVOURITE_NUMBER("favourite_number"),
    TARIFFING("tariffing"),
    TARIFF_CONNECTION_FEE("tariff_connection_fee");

    private String value;

    private TariffEnum(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
