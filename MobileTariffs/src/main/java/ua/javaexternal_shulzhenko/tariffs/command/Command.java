package ua.javaexternal_shulzhenko.tariffs.command;

import ua.javaexternal_shulzhenko.tariffs.exceptions.InvalidCommandException;

import java.io.IOException;

public interface Command {
    void execute() throws InvalidCommandException, IOException;
}
