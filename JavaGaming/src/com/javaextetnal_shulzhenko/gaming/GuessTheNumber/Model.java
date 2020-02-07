package com.javaextetnal_shulzhenko.gaming.GuessTheNumber;

import java.util.Random;

public class Model {
	
	private int secretNumber;
	private int[] numbersField;
	private int rightFieldBorder;
	private int leftFieldBorder;
	private int attempts;
	
	public Model() {
		Random random = new Random();
		secretNumber = random.nextInt(100);
		numbersField = new int[100];
		rightFieldBorder = 99;
		leftFieldBorder = 0;
		attempts = 6;
		for(int i = 0; i< numbersField.length; i++) {
			numbersField[i] = i;
		}
	}
	
	public int getSecretNumber() {
		return secretNumber;
	}

	public int[] getNumberField() {
		return numbersField;
	}


	public int getRightFieldBorder() {
		return rightFieldBorder;
	}


	public void setRightFieldBorder(int rightFieldBorder) {
		this.rightFieldBorder = rightFieldBorder;
	}


	public int getLeftFieldBorder() {
		return leftFieldBorder;
	}


	public void setLeftFieldBorder(int leftFieldBorder) {
		this.leftFieldBorder = leftFieldBorder;
	}

	public int getAttempts() {
		return attempts;
	}

	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}
}
