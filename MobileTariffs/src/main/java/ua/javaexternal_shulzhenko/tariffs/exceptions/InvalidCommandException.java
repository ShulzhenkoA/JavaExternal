package ua.javaexternal_shulzhenko.tariffs.exceptions;

public class InvalidCommandException extends Throwable {

    private String message;

    public InvalidCommandException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return "Invalid " + message;
    }
}
