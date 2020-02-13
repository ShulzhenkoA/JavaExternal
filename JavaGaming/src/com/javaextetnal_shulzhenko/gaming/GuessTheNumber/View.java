package com.javaextetnal_shulzhenko.gaming.GuessTheNumber;

/**
 * View class of the GuessTheNumber game
 *
 * @version 0.2 13 Feb 2020
 * @author Andrii Shulzhenko
 */
public class View {

	ResourceManager manager = ResourceManager.INSTANCE;


	void printGreeting() {
		printToConsole(manager.getString(MessagesForPrinting.GREETING.getMassageSnippet()));

	}

	void printFirstPointer() {
		printToConsole(manager.getString(MessagesForPrinting.FIRST_POINTER.getMassageSnippet()));
}

	void printNumbersRange(Model model) {
		printToConsole(
				buildStringMassage(
						manager.getString(MessagesForPrinting.THE_SECRET_NUMBER.getMassageSnippet()),
						String.valueOf(model.getLeftBorder()),
						manager.getString(MessagesForPrinting.AND.getMassageSnippet()),
						String.valueOf(model.getRightBorder()),
						manager.getString(MessagesForPrinting.CLOSING_SQUARE_BRACKET.getMassageSnippet())));
	}

	void printPreviousNumbers(Model model) {
		printToConsole(
				manager.getString(MessagesForPrinting.SELECTED_NUMBERS.getMassageSnippet())
						+ model.getPreviousNumbers());
	}

	void printAttempts(Model model) {
		printToConsole(
				buildStringMassage(
						manager.getString(MessagesForPrinting.YOU_HAVE.getMassageSnippet()),
						String.valueOf(model.getAttempts()),
						manager.getString(MessagesForPrinting.ATTEMPTS.getMassageSnippet())));
	}

	void printHint(Model model) {
		printToConsole(
				buildStringMassage(
						manager.getString(MessagesForPrinting.ENTER_THE_NUMBER.getMassageSnippet()),
						String.valueOf(model.getLeftBorder()),
						manager.getString(MessagesForPrinting.TO.getMassageSnippet()),
						String.valueOf(model.getRightBorder()),
						manager.getString(MessagesForPrinting.FOR_GUESS_OR_QUIT.getMassageSnippet())));
	}

	void printCongrats(Model model) {
		printToConsole(
				buildStringMassage(
						manager.getString(MessagesForPrinting.CONGRATS.getMassageSnippet()),
						String.valueOf(model.getSecretNumber()),
						manager.getString(MessagesForPrinting.YOU_WON.getMassageSnippet())));
	}

	void printLosing(Model model) {
		printToConsole(
				manager.getString(MessagesForPrinting.YOU_HAD_LOST.getMassageSnippet()) +
						model.getSecretNumber());
	}

	void printQuit() {
		printToConsole(
				manager.getString(MessagesForPrinting.QUIT_THE_GAME.getMassageSnippet()));
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
