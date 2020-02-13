package com.javaextetnal_shulzhenko.gaming.GuessTheNumber;

/**
 * View class of the GuessTheNumber game
 *
 * @version 0.1 13 Feb 2020
 * @author Andrii Shulzhenko
 */
public class View {

	void printGreeting() {
		printToConsole(MessagesForPrinting.GREETING.getMassageSnippet());
	}

	void printFirstPointer() {
		printToConsole(MessagesForPrinting.FIRST_POINTER.getMassageSnippet());
	}

	void printNumbersRange(Model model) {
		printToConsole(
				buildStringMassage(
						MessagesForPrinting.THE_SECRET_NUMBER.getMassageSnippet(),
						String.valueOf(model.getLeftBorder()),
						MessagesForPrinting.AND.getMassageSnippet(),
						String.valueOf(model.getRightBorder()),
						MessagesForPrinting.CLOSING_SQUARE_BRACKET.getMassageSnippet()));
	}

	void printPreviousNumbers(Model model) {
		printToConsole(MessagesForPrinting.SELECTED_NUMBERS.getMassageSnippet() + model.getPreviousNumbers());
	}

	void printAttempts(Model model) {
		printToConsole(
				buildStringMassage(
						MessagesForPrinting.YOU_HAVE.getMassageSnippet(),
						String.valueOf(model.getAttempts()),
						MessagesForPrinting.ATTEMPTS.getMassageSnippet()));
	}

	void printHint(Model model) {
		printToConsole(
				buildStringMassage(
						MessagesForPrinting.ENTER_THE_NUMBER.getMassageSnippet(),
						String.valueOf(model.getLeftBorder()),
						MessagesForPrinting.TO.getMassageSnippet(),
						String.valueOf(model.getRightBorder()),
						MessagesForPrinting.FOR_GUESS_OR_QUIT.getMassageSnippet()));
	}

	void printCongrats(Model model) {
		printToConsole(
				buildStringMassage(
						MessagesForPrinting.CONGRATS.getMassageSnippet(),
						String.valueOf(model.getAttempts()),
						MessagesForPrinting.YOU_WON.getMassageSnippet()));
	}

	void printLosing(Model model) {
		printToConsole(MessagesForPrinting.YOU_HAD_LOST.getMassageSnippet() + model.getSecretNumber());
	}

	void printQuit() {
		printToConsole(MessagesForPrinting.QUIT_THE_GAME.getMassageSnippet());
	}

	private void printToConsole(String massage){
		System.out.println(massage);
	}

	private String buildStringMassage(String... message){
		StringBuilder buildMassage = new StringBuilder();
		for(String s : message) {
			buildMassage = buildMassage.append(s);
		}
		return new String(buildMassage);
	}
}
