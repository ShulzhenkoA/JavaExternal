package ua.javaexternal_shulzhenko.tariffs.exceptions;

public class CommandFailedException extends Throwable {

    private String message;

    public CommandFailedException(String message) {
        this.message=message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
