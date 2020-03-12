package ua.javaexternal_shulzhenko.tariffs.models.command;

import ua.javaexternal_shulzhenko.tariffs.exceptions.CommandFailedException;
import ua.javaexternal_shulzhenko.tariffs.exceptions.InvalidCommandException;

public interface Command {
    void execute() throws InvalidCommandException, CommandFailedException;
}
