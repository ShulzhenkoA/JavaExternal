package com.javaextetnal_shulzhenko.gaming.GuessTheNumber;

import java.util.Random;

/**
 * Model class of the game
 */
public class Model {
	
	private int secretNumber;
	private int rightBorder;
	private int leftBorder;
	private int attempts;
	
	public Model() {
		Random random = new Random();
		secretNumber = random.nextInt(100);
		rightBorder = 99;
		leftBorder = 0;
		attempts = 6;
	}
	
	public int getSecretNumber() {
		return secretNumber;
	}

	public int getRightBorder() {
		return rightBorder;
	}

	public void setRightBorder(int rightBorder) {
		this.rightBorder = rightBorder;
	}

	public int getLeftBorder() {
		return leftBorder;
	}

	public void setLeftBorder(int leftBorder) {
		this.leftBorder = leftBorder;
	}

	public int getAttempts() { return attempts; }

	public void decrementAttemps(){ attempts--; }
}
