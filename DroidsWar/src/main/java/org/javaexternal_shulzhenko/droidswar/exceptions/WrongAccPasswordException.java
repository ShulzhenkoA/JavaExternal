package org.javaexternal_shulzhenko.droidswar.exceptions;

public class WrongAccPasswordException extends Throwable {
    @Override
    public String getLocalizedMessage() {
        return "Wrong password has been entered";
    }
}
