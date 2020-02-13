package com.javaextetnal_shulzhenko.gaming.GuessTheNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Model class of GuessTheNumber game
 *
 * @version 0.1 13 Feb 2020
 * @author Andrii Shulzhenko
 */
public class Model {

	private int secretNumber;
	private int rightBorder;
	private int leftBorder;
	private int attempts;
	private List<Integer> previousNumbers;
	
	public Model() {
		Random random = new Random();
		secretNumber = random.nextInt(GameSettings.MAX_NUMBER.getValue() + 1);
		rightBorder = GameSettings.MAX_NUMBER.getValue();
		leftBorder = GameSettings.MIN_NUMBER.getValue();
		attempts = GameSettings.AMOUNT_OF_ATTEMPTS.getValue();
		previousNumbers = new ArrayList<>();
	}

    /**
     * Process the main logic of the game
     *
     * @param userAction input user action
     * @return the command to be display
     */
    public String processUserAction(String userAction) {

        attempts--;
        int number = determineUserActionInInteger(userAction);
        previousNumbers.add(number);

        if(number == secretNumber) {
            return "won";
        }else if(attempts == 0){
            return "lost";
        }else if(number > secretNumber && number <= rightBorder) {
            rightBorder = number;
            return "forth";
        }else if(number < secretNumber && number >= leftBorder){
            leftBorder = number;
            return "forth";
        }else{
            return "again";
        }
    }

	/**
	 *Determine int value of user action
	 *
	 * @param userAction input user action
	 * @return an integer value of user action or -1 in case of {@link NumberFormatException}
	 */
	private int determineUserActionInInteger(String userAction) {
		int num;
		try{
			num = Integer.parseInt(userAction);
			return num;
		}catch (NumberFormatException exc){
			return -1;
		}
	}

	public int getSecretNumber() { return secretNumber; }

	public int getRightBorder() { return rightBorder; }

	public void setRightBorder(int rightBorder) { this.rightBorder = rightBorder; }

	public int getLeftBorder() { return leftBorder; }

	public void setLeftBorder(int leftBorder) { this.leftBorder = leftBorder; }

	public int getAttempts() { return attempts; }

	public void decrementAttempts(){ attempts--; }

	public List<Integer> getPreviousNumbers() { return previousNumbers; }

}
