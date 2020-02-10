package org.javaexternal_shulzhenko.game.droids;

import org.javaexternal_shulzhenko.game.weapons.*;

public class DroidBD01 extends Droid implements BattleDroid{

    private Blaster rightHandWeapon;

    public DroidBD01(Blaster weapon) {
        this(weapon, 20, "Battle Droid", "[BD01]");
    }

    protected DroidBD01(Blaster weapon, int defence, String name, String model) {
        super(defence, name, model);
        rightHandWeapon = weapon;
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


    @Override
    public String toString() {

        return super.toString() +
                "\n{weapon \n\t-- right hand -- "  + rightHandWeapon;
    }
}
