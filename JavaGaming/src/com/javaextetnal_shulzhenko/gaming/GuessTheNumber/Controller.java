package com.javaextetnal_shulzhenko.gaming.GuessTheNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Controller class of GuessTheNumber game
 *
 * @version 0.1 13 Feb 2020
 * @author Andrii Shulzhenko
 */
public class Controller {

	private Model model;
	private View view;
	
	public Controller(Model model, View view) {
		this.model = model;
        this.view = view;
	}

	/**
	 * Launch the game and prompts user for playing, quiting or change language
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
	 * Begin playing process of the game and prompts user to enter an action;
	 *
	 * @return false when for ending the game
	 */
	private boolean play() {

		displayInfo("firstPointer");

		String enteredData = null;
		do {

		    enteredData = readInputData();

			if(!enteredData.equalsIgnoreCase("quit")) {
				enteredData = model.processUserAction(enteredData);
				displayInfo(enteredData);
			}
		}while(enteredData.equalsIgnoreCase("quit") ? false :
                  enteredData.equalsIgnoreCase("won") ? false :
                     enteredData.equalsIgnoreCase("lost" ) ? false : true);
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
	 * Display game info throw view object.
	 *
	 * @param command indicates type of information to be display
	 */
	private void displayInfo(String command) {
		switch(command) {
			case "forth":
				view.printNumbersRange(model);
				view.printPreviousNumbers(model);
				view.printAttempts(model);
				break;
			case "won":
				view.printCongrats(model);
				view.printPreviousNumbers(model);
				break;
			case "quit":
				view.printQuit();
				break;
			case "greeting":
				view.printGreeting();
				break;
			case "firstPointer":
				view.printFirstPointer();
				view.printAttempts(model);
				break;
			case "lost":
				view.printLosing(model);
				break;
			case "again":
				view.printHint(model);
				view.printPreviousNumbers(model);
				view.printAttempts(model);
				break;
            default:
                view.printHint(model);
                view.printAttempts(model);
                view.printPreviousNumbers(model);
		}
	}
}
