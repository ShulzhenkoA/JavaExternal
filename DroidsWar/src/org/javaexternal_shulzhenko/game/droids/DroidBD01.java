package org.javaexternal_shulzhenko.game.droids;

import org.javaexternal_shulzhenko.game.weapons.*;

public class DroidBD01 extends Droid implements BattleDroid{

    private Blaster rightHandWeapon;
    private int defence;
    private final String NAME = "Battle Droid";
    private final String MODEL = "[BD01]";

    public DroidBD01() {
    }

    public DroidBD01(Blaster weapon) {
        rightHandWeapon = weapon;
        defence = 20;
    }



    public int attack(){
       return rightHandWeapon.shoot();
    }

    public Blaster getRightHandWeapon() {
        return rightHandWeapon;
    }

    public void setRightHandWeapon(Blaster rightHandWeapon) {
        this.rightHandWeapon = rightHandWeapon;
    }

    public int getDefence(){
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

        return "Name - " + NAME +
                "\nModel - "+ MODEL +
                "\n{health -- " + getHealth() +"}" +
                "\n{weapon \n\t-- right hand -- "  + rightHandWeapon + "}" +
                "\n{defence -- " + defence +" }";
    }
}
