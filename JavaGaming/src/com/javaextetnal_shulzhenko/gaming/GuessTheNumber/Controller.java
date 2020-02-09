package com.javaextetnal_shulzhenko.gaming.GuessTheNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Controller class of the game
 */
public class Controller {

	private Model model;
	private View view;
	
	public Controller() {
		model = new Model();
		view = new View();
	}

	/**
	 * Launch the game
	 */
	public void launchGame() {
		displayInfo("greeting");
		String enteredData = null;
		do {
			enteredData = readInputData();
		}while(enteredData.equalsIgnoreCase("quit") ? false :
				enteredData.equalsIgnoreCase("play") ? play() : true);
		displayInfo("quit");
	}

	/**
	 * Begin playing process of the game
	 *
	 * @return false when for ending the game
	 */
	private boolean play() {

		displayInfo("firstPointer");

		String enteredData = null;
		do {
			if(model.getAttempts() == 0) {
				displayInfo("lost");
				break;
			}
			enteredData = readInputData();

			if(!enteredData.equalsIgnoreCase("quit")) {
				enteredData = processTypedNumber(determineEnteredNumber(enteredData));
				displayInfo(enteredData);
			}
		}while(enteredData.equalsIgnoreCase("quit") ? false :
			   enteredData.equalsIgnoreCase("won") ? false : true);
		return false;
	}

	/**
	 * Read input data from the user
	 *
	 * @return the string type of the entered data
	 */
	private String readInputData() {
		String data = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			data = br.readLine();
		}catch(IOException exc) {
			exc.printStackTrace();
		}
		return data;
	}

	/**
	 * Process the main logic of the game
	 *
	 * @param number integer variant of entered data
	 * @return the command to be display
	 */
	private String processTypedNumber(int number) {

		int secretNumber = model.getSecretNumber();

		if(number == secretNumber) {
			model.addPreviousNumbers(number);
			return "won";
		}else if(number > secretNumber && number <= model.getRightBorder()) {
			model.setRightBorder(number);
			model.decrementAttempts();
			model.addPreviousNumbers(number);
			return "forth";
		}else if(number < secretNumber && number >= model.getLeftBorder()){
			model.setLeftBorder(number);
			model.decrementAttempts();
			model.addPreviousNumbers(number);
			return "forth";
		}else{
			model.decrementAttempts();
			return "again";
		}
	}

	/**
	 *Determine int value of entered data
	 *
	 * @param data input data
	 * @return an integer value of entered data or -1 in case of {@link NumberFormatException}
	 */
	private int determineEnteredNumber(String data) {
		int num;
		try{
			num = Integer.parseInt(data);
			return num;
		}catch (NumberFormatException exc){
			return -1;
		}
	}

	/**
	 * Display game info throw view object.
	 *
	 * @param command indicates type of information to be display
	 */
	private void displayInfo(String command) {
		switch(command) {
			case "forth":
				view.printNumbersRange(model.getLeftBorder(), model.getRightBorder());
				view.printPreviousNumbers(model.getPreviousNumbers());
				view.printAttempts(model.getAttempts());
				break;
			case "won":
				view.printCongrats(model.getSecretNumber());
				view.printPreviousNumbers(model.getPreviousNumbers());
				break;
			case "quit":
				view.printQuit();
				break;
			case "greeting":
				view.printGreeting();
				break;
			case "firstPointer":
				view.printFirstPointer();
				view.printAttempts(model.getAttempts());
				break;
			case "lost":
				view.printLosing(model.getSecretNumber());
				break;
			case "again":
				view.printHint(model.getLeftBorder(), model.getRightBorder());
				view.printAttempts(model.getAttempts());
		}
	}
}
