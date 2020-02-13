package com.javaextetnal_shulzhenko.gaming.GuessTheNumber;

/**
 * Class for massages printing ing view
 *
 * @version 0.1.1 13 Feb 2020
 * @author Adnrii Shulzhenko
 */
public enum MessagesForPrinting {


    GREETING("Welcome to the 'GuessTheNumber' game\n"+
            "Start the game enter *** play ***\n" +
            "Quit the game enter *** quit ***\n"),

    FIRST_POINTER("Enter the number from *** 0 to 100 *** to guess the secret number"
            + " or enter *** quit *** for ending the game."),

    THE_SECRET_NUMBER("The secret number is between ["),
    AND(" and "),
    CLOSING_SQUARE_BRACKET("]"),

    SELECTED_NUMBERS("Selected numbers "),

    YOU_HAVE("You have "),
    ATTEMPTS(" attempts.\n"),

    ENTER_THE_NUMBER("Enter the number from *** "),
    TO("to"),
    FOR_GUESS_OR_QUIT(" *** for guess or *** quit *** for ending the game."),


    CONGRATS("Congrats!!! The secret number is "),
    YOU_WON(" You won!!!"),

    YOU_HAD_LOST("You had lost!!! A-ia-iaaaaa :-( !!! The secret number was "),

    QUIT_THE_GAME("Quit the game.");


    private String massageSnippet;
    MessagesForPrinting(String massageSnippet) {
        this.massageSnippet = massageSnippet;
    }

    public String getMassageSnippet() {
        return massageSnippet;
    }
}
