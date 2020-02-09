package org.javaexternal_shulzhenko.game.droids;

import org.javaexternal_shulzhenko.game.weapons.*;

public class DroidBD02 extends DroidBD01 {

    private Blaster leftHandWeapon;
    private final String MODEL = "[BD02]";

    public DroidBD02() {
        super();
    }

    public DroidBD02(Blaster weapon1, Blaster weapon2) {
        super(weapon1);
        leftHandWeapon = weapon2;
    }

    @Override
    public int attack() {
        return super.attack() + leftHandWeapon.shoot();
    }

    public Blaster getLeftHandWeapon() {
        return leftHandWeapon;
    }

    public void setLeftHandWeapon(Blaster leftHandWeapon) {
        this.leftHandWeapon = leftHandWeapon;
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
                getRightHandWeapon() + "\n\t-- left hand -- " + leftHandWeapon +"}" +
                "\n{defence -- " + getDefence() +" }";
    }
}
