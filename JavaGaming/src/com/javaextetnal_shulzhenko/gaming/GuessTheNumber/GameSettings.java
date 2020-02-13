package com.javaextetnal_shulzhenko.gaming.GuessTheNumber;

/**
 * Class for configuring GuessTheNumber game
 *
 * @version 0.1.1 13 Feb 2020
 * @author Adnrii Shulzhenko
 */
public enum GameSettings {
    MAX_NUMBER(100),
    MIN_NUMBER(0),
    AMOUNT_OF_ATTEMPTS(6);

    private int value;

    GameSettings(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
