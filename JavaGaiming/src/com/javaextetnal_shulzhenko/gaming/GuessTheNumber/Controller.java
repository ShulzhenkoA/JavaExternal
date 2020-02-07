package com.javaextetnal_shulzhenko.gaming.GuessTheNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {

	private Model model;
	private View view;
	
	public Controller() {
		model = new Model();
		view = new View();
	}

	public void launchGame() {
		displayInfo("greeting");
		String command = null;
		do {
			command = readFromConsole();
		}while(!(command.equalsIgnoreCase("quit") || command.equalsIgnoreCase("play")));
		
		if(command.equalsIgnoreCase("play")) {
			displayInfo("firstPointer");
			play();
		}else {
			displayInfo("quit");
		}
	}
	
	private void play() {
		String command=null;
		do {
			if(model.getAttempts() == 0) {
				displayInfo("lost");
				break;
			}
			String typedData = readFromConsole();
			command = typedData;
			if(typedData != null && typedData.length() <= 2 && checkingForAppropriateNum(typedData)) {
				command = processTypedNumber(typedData);
				displayInfo(command);
			}else{
				model.setAttempts(model.getAttempts() - 1);
				displayInfo(command);
			}
		}while(!(command.equalsIgnoreCase("quit") || command.equalsIgnoreCase("won")));
	}

	private String readFromConsole() {
		String command = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			command = br.readLine();
		}catch(IOException exc) {
			exc.printStackTrace();
		}
		return command;
	}

	private String processTypedNumber(String typedData) {
		
		int typedNumber = Integer.parseInt(typedData);
		int left = model.getLeftFieldBorder();
		int right = model.getRightFieldBorder();
		int secretNumber = model.getSecretNumber();
			
		if(typedNumber == secretNumber) {
			return "won";
		}else if(typedNumber >= left && typedNumber <= right) {
			if(typedNumber > (right - left)/2) {
				if(typedNumber < secretNumber) {
					model.setLeftFieldBorder(typedNumber);
				}else {
					model.setRightFieldBorder(typedNumber);
				}
			}else if(typedNumber < (right - left)/2){
				if(typedNumber > secretNumber) {
					model.setRightFieldBorder(typedNumber);
				}else {
					model.setLeftFieldBorder(typedNumber);
				}
			}else{
				if (typedNumber < secretNumber){
					model.setLeftFieldBorder(typedNumber);
				}else{
					model.setRightFieldBorder(typedNumber);
				}
			}
			model.setAttempts(model.getAttempts() - 1);
			return "forth";
		}
		model.setAttempts(model.getAttempts() - 1);
		return "again";
	}

	private void displayInfo(String typedData) {
		switch(typedData) {
		case "forth":
			view.printNumbersRange(model.getNumberField(), model.getLeftFieldBorder(), model.getRightFieldBorder());
			view.printAttempts(model.getAttempts());
			break;
		case "won":
			view.printCongrats(model.getSecretNumber());
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
		default :
			view.printHint(model.getLeftFieldBorder(), model.getRightFieldBorder());
			view.printAttempts(model.getAttempts());
		}
	}
	
	private boolean checkingForAppropriateNum(String command) {
		int[] numbers = model.getNumberField();
		for(int i = 0; i < numbers.length; i++) {
			if(command.equals(String.valueOf(numbers[i]))) {
				return true;
			}
		}
		return false;
	}
}
