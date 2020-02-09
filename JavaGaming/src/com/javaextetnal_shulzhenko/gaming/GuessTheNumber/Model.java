package com.javaextetnal_shulzhenko.gaming.GuessTheNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Model class of the game
 */
public class Model {
	
	private int secretNumber;
	private int rightBorder;
	private int leftBorder;
	private int attempts;
	private List<Integer> previousNumbers;
	
	public Model() {
		Random random = new Random();
		secretNumber = random.nextInt(101);
		rightBorder = 100;
		leftBorder = 0;
		attempts = 6;
		previousNumbers = new ArrayList<>();
	}
	
	public int getSecretNumber() { return secretNumber; }

	public int getRightBorder() { return rightBorder; }

	public void setRightBorder(int rightBorder) { this.rightBorder = rightBorder; }

	public int getLeftBorder() { return leftBorder; }

	public void setLeftBorder(int leftBorder) { this.leftBorder = leftBorder; }

	public int getAttempts() { return attempts; }

	public void decrementAttempts(){ attempts--; }

	public List<Integer> getPreviousNumbers() { return previousNumbers; }

	public void addPreviousNumbers(int number){ previousNumbers.add(number); }
}
