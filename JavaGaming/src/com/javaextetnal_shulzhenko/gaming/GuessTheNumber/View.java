package com.javaextetnal_shulzhenko.gaming.GuessTheNumber;

import java.util.List;

/**
 * View class of the game
 */
public class View {

	public void printNumbersRange(int leftBorder, int rightBorder) {
		System.out.println("The secret number is between [" + leftBorder + " and " + rightBorder + "]");
	}
	
	public void printCongrats(int secretNumber) {
		System.out.println("Congrats!!! The secret number is " + secretNumber + ". You won!!!");
	}

	public void printQuit() {
		System.out.println("Quit the game");
	}

	public void printHint(int leftFieldBorder, int rightFieldBorder) {
		System.out.println("Enter the number from *** " + leftFieldBorder + " to " +
							rightFieldBorder + " *** for guess or *** quit *** for ending the game.");
	}
	
	public void printGreeting() {
		System.out.println("Welcome to the 'GuessTheNumber' game\n"
		         + "Start the game enter *** play ***\n"
		         + "Quit the game enter *** quit ***\n");
	}

	public void printAttempts(int attempts) {
		System.out.println("You have "+ attempts + " attempts.\n");
	}

	public void printFirstPointer() {
		System.out.println("Enter the number from *** 0 to 99 *** to guess the secret number"
				             + " or enter *** quit *** for ending the game.");
	}

	public void printLosing(int secretNumber) {
		System.out.println("You had lost!!! A-ia-iaaaaa :-( !!! The secret number was "+ secretNumber+".");
		
	}

	public void printPreviousNumbers(List<Integer> previousNumbers) {
		System.out.println("Selected numbers " + previousNumbers);
	}
}
