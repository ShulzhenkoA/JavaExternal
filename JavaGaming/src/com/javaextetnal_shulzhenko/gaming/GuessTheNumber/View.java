package com.javaextetnal_shulzhenko.gaming.GuessTheNumber;

public class View {

	public void printNumbersRange(int[] range, int leftBorder, int rightBorder) {
		System.out.print("[");
		for(int i = leftBorder; i <= rightBorder; i++) {
			System.out.print(range[i]);
			if(i== rightBorder) {
				System.out.print("]");
			}else {
				System.out.print(", ");
			}
		}
		System.out.println("\n");
	}
	
	public void printCongrats(int secretNumber) {
		System.out.println("Congrats!!! The secret number is " + secretNumber + ". You won!!!");
	}

	public void printQuit() {
		System.out.println("Quit the game");
		
	}

	public void printHint(int leftFieldBorder, int rightFieldBorder) {
		System.out.println("Type number from " + leftFieldBorder + " to " + 
							rightFieldBorder + " for guess or 'quit' for ending the game.");
	}
	
	public void printGreeting() {
		System.out.println("Welcome to the 'GuessTheNumber' game\n"
		         + "Start the game -- type 'play'\n"
		         + "Quit the game -- type 'quit'\n");
	}

	public void printAttempts(int attempts) {
		System.out.println("You have "+ attempts + " attempts.\n");
	}

	public void printFirstPointer() {
		System.out.println("Enter the number from 0 to 99 to guess the secret number"
				             + " or type 'quit' for ending the game.");
	}

	public void printLosing(int secretNumber) {
		System.out.println("You had lost!!! A-ia-iaaaaa :-( !!! The secret number was "+ secretNumber+".");
		
	}
}
