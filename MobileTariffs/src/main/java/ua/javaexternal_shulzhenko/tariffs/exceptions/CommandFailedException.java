package ua.javaexternal_shulzhenko.tariffs.exceptions;

public class CommandFailedException extends RuntimeException {

    private String message;

    public CommandFailedException(String message) {
        this.message=message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
