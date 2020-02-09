package org.javaexternal_shulzhenko.game.droids;

import org.javaexternal_shulzhenko.game.weapons.Blaster;

public class DroidDD01 extends DroidBD02 {


    private int defence;
    private final String NAME = "Droid Destroyer";
    private final String MODEL = "[DD01]";


    public DroidDD01(Blaster weapon1, Blaster weapon2) {
        super(weapon1,weapon2);
        defence = 35;
    }

    @Override
    public int getDefence() {
        return defence;
    }

    @Override
    public String getNAME() {
        return NAME;
    }

    @Override
    public String getMODEL() {
        return MODEL;
    }

    @Override
    public String toString() {
        return "Name - " + getNAME() +
                "\nModel - "+ MODEL +
                "\n{health -- " + getHealth() +"}" +
                "\n{weapon \n\t-- right hand -- "  +
                getRightHandWeapon() + "\n\t-- left hand -- " + getLeftHandWeapon() +"}" +
                "\n{defence -- " + getDefence() +" }";
    }
}
