package ua.javaexternal_shulzhenko.tariffs.models.tariff;

import ua.javaexternal_shulzhenko.tariffs.anotations.MobileType;
import ua.javaexternal_shulzhenko.tariffs.anotations.TariffElement;

@MobileType(typeName ="Tariff", propOrder = {"name", "operatorName", "payroll", "callPrices", "sms", "parameters"})
public class Tariff {

    @TariffElement(elementName = "name", defaultValue = "Undefined", required = true)
    private String name;

    @TariffElement(elementName = "operator-name", required = true)
    private String operatorName;

    @TariffElement(elementName = "payroll", defaultValue = "0" )
    private double payroll;

    @TariffElement(elementName = "call-prices", required = true)
    private CallPrices callPrices;

    @TariffElement(elementName = "sms", defaultValue = "0.8")
    private double sms;

    @TariffElement(elementName = "parameters", required = true)
    private Parameters parameters;

    public Tariff() {
        callPrices = new CallPrices();
        parameters = new Parameters();
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String value) {
        this.operatorName = value;
    }

    public double getPayroll() {
        return payroll;
    }

    public void setPayroll(double value) {
        this.payroll = value;
    }

    public CallPrices getCallPrices() {
        return callPrices;
    }

    public void setCallPrices(CallPrices value) {
        this.callPrices = value;
    }

    public double getSms() {
        return sms;
    }

    public void setSms(double value) {
        this.sms = value;
    }

    public Parameters getParameters() {
        return parameters;
    }

    public void setParameters(Parameters value) {
        this.parameters = value;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        return builder.append("\nName: ").append(name).append("\nOperator Name: ").append(operatorName).
                append("\nPayroll: ").append(payroll).append(callPrices.toString()).append("\nSMS: ").
                append(sms).append(parameters.toString()).toString();
    }

    @MobileType(typeName = "CallPrices", propOrder = {"withingNetwork", "outsideNetwork", "stationaryPhones"})
    public static class CallPrices{

        @TariffElement(elementName = "withing-network", defaultValue = "0")
        private double withingNetwork;

        @TariffElement(elementName = "outside-network", minvalue = 0.5)
        private double outsideNetwork;

        @TariffElement(elementName = "stationary-phones", minvalue = 0.9)
        private double stationaryPhones;

        public double getWithingNetwork() {
            return withingNetwork;
        }

        public void setWithingNetwork(double withingNetwork) {
            this.withingNetwork = withingNetwork;
        }

        public double getOutsideNetwork() {
            return outsideNetwork;
        }

        public void setOutsideNetwork(double outsideNetwork) {
            this.outsideNetwork = outsideNetwork;
        }

        public double getStationaryPhones() {
            return stationaryPhones;
        }

        public void setStationaryPhones(double stationaryPhones) {
            this.stationaryPhones = stationaryPhones;
        }

        public String toString() {
            StringBuilder builder = new StringBuilder();
            return builder.append("\nCall prices:").append("\n\tWithin network: ").append(withingNetwork).
                    append("\n\tOutside network: ").append(outsideNetwork).append("\n\tStationary phones: ").
                    append(stationaryPhones).toString();
        }
    }

    @MobileType(typeName = "Parameters", propOrder = {"favouriteNumbers", "tariffing", "tariffConnectionFee"})
    public static class Parameters{

        @TariffElement(elementName = "favourite-numbers")
        private String favouriteNumbers;

        @TariffElement(elementName = "tariffing")
        private String tariffing;

        @TariffElement(elementName = "tariff-connection-fee")
        private String tariffConnectionFee;

        public Parameters() {
        }

        public String getFavouriteNumbers() {
            return favouriteNumbers;
        }

        public void setFavouriteNumbers(String favouriteNumbers) {
            this.favouriteNumbers = favouriteNumbers;
        }

        public String getTariffing() {
            return tariffing;
        }

        public void setTariffing(String tariffing) {
            this.tariffing = tariffing;
        }

        public String getTariffConnectionFee() {
            return tariffConnectionFee;
        }

        public void setTariffConnectionFee(String tariffConnectionFee) {
            this.tariffConnectionFee = tariffConnectionFee;
        }

        public String toString() {
            StringBuilder builder = new StringBuilder();
            return builder.append("\nParameters:" ).append("\n\tFavouriteNumbers: ").append(favouriteNumbers).
                    append("\n\tTariffing: ").append(tariffing ).append("\n\tTariff connection fee: ").
                    append(tariffConnectionFee).append("\n").toString();
        }
    }
}
