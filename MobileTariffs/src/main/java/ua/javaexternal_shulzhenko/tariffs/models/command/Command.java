package ua.javaexternal_shulzhenko.tariffs.models.command;

import ua.javaexternal_shulzhenko.tariffs.exceptions.CommandFailedException;

public interface Command {
    void execute() throws CommandFailedException;
}
