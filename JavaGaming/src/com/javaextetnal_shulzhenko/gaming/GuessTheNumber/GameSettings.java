package com.javaextetnal_shulzhenko.gaming.GuessTheNumber;

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
