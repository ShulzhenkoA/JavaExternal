package org.javaexternal_shulzhenko.droidswar.exceptions;

public class InappropriateDroidsException extends Throwable {
    @Override
    public String getLocalizedMessage() {
        return "Inappropriate droids have been selected";
    }
}
