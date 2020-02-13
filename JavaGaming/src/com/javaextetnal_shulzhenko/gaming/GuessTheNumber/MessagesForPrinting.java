package com.javaextetnal_shulzhenko.gaming.GuessTheNumber;

/**
 * Class for massages printing ing view
 *
 * @version 0.2 13 Feb 2020
 * @author Adnrii Shulzhenko
 */
public enum MessagesForPrinting {


    GREETING("massage.greeting"),

    FIRST_POINTER("massage.first.pointer"),

    THE_SECRET_NUMBER("massage.the.secret.number"),
    AND("massage.and"),
    CLOSING_SQUARE_BRACKET("massage.closing.square.bracket"),

    SELECTED_NUMBERS("massage.selected.numbers"),

    YOU_HAVE("massage.you.have"),
    ATTEMPTS("massage.attempts"),

    ENTER_THE_NUMBER("massage.enter.numbers"),
    TO("massage.to"),
    FOR_GUESS_OR_QUIT("massage.for.guess.or.quit"),


    CONGRATS("massage.congrats"),
    YOU_WON("massage.you.won"),

    YOU_HAD_LOST("massage.you.lost"),

    QUIT_THE_GAME("massage.quit.the.game");


    private String massageSnippet;
    MessagesForPrinting(String massageSnippet) {
        this.massageSnippet = massageSnippet;
    }

    public String getMassageSnippet() {
        return massageSnippet;
    }
}
