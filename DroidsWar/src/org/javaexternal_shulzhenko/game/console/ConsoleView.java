package org.javaexternal_shulzhenko.game.console;

import org.javaexternal_shulzhenko.game.droids.Droid;

public class ConsoleView {

    public static void showResultsOfTheFight(Droid firstDroid, Droid secondDroid, String typeOfTheFight) {

        String firstDroidInfo;
        String secondDroidInfo;

        if (firstDroid.isAlive()) {
            firstDroidInfo = firstDroid.toString();
        } else {
            firstDroidInfo = firstDroid.getName() + firstDroid.getModel() + " was defeated";
        }

        if (secondDroid.isAlive()) {
            secondDroidInfo = secondDroid.toString();
        } else {
            secondDroidInfo = secondDroid.getName() + secondDroid.getModel() + " was defeated.";
        }

        String betweenInfo = "= between " + firstDroid.getName() + firstDroid.getModel() +
                " and " + secondDroid.getName() + secondDroid.getModel();

        String equalSignsLine = "";

        for (int i = 0; i < betweenInfo.length(); i++) {
            equalSignsLine = equalSignsLine.concat("=");
        }
        System.out.println(equalSignsLine +
                "\n= Result of " + typeOfTheFight +
                betweenInfo + "\n= Surviving droid info\n" + equalSignsLine +
                "\n****************************************************************\n" + firstDroidInfo +
                "\n****************************************************************\n" + secondDroidInfo +
                "\n****************************************************************\n\n");
    }

    public static void printDroidInfo(Droid droid) {
        System.out.println("........................Droid Information........................\n" + droid +
                "\n........................Droid Information........................\n\n");
    }

    public void printGreeting() {
        System.out.println("____________________THIS IS DROIDS WARS___________________\n" +
                "1. To log in to your account enter *** login ***\n" +
                "2. Create new account enter *** create ***\n");
    }

    public void printCreatingAccInfo() {
        System.out.println("____________________ACCOUNT CREATING____________________\n");
    }

    public void printEnterNickName() {
        System.out.println("Enter your game NickName (only letters are allowed, at least one " +
                "uppercase latter is required)");
    }

    public void printEnterPassword() {
        System.out.println("Enter the Password from your account (its length must be from 4 to 8, at least one " +
                "uppercase letter, lowercase letter and number)");
    }

    public void printCreateAdmOrUserAcc() {
        System.out.println("Do you want to create admin or user account? Enter *** admin *** or *** user *** ");
    }

    public void printAccountCreated() {
        System.out.println("Your account was succesfully created.");
    }

    public void printLoginAccountInfo() {
        System.out.println("____________________LOGIN ACCOUNT____________________\n");
    }

    public void printEnterForLogin() {
        System.out.println("Enter your account NickName");
    }

    public void printEnterPasswordForLogin() {
        System.out.println("Enter your account Password");
    }
}
