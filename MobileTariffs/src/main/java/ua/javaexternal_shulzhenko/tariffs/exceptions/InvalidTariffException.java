package ua.javaexternal_shulzhenko.tariffs.exceptions;

public class InvalidTariffException extends Throwable {

    private String message;

    public InvalidTariffException(String message) {
        this.message=message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
