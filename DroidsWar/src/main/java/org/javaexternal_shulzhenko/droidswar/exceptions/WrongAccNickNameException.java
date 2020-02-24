package org.javaexternal_shulzhenko.droidswar.exceptions;

public class WrongAccNickNameException extends Exception {
    @Override
    public String getLocalizedMessage() {
        return "Wrong account nickname has been entered";
    }
}
