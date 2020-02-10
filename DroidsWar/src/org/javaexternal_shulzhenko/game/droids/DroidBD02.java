package org.javaexternal_shulzhenko.game.droids;

import org.javaexternal_shulzhenko.game.weapons.*;

public class DroidBD02 extends DroidBD01 {

    private Blaster leftHandWeapon;


    public DroidBD02(Blaster weapon1, Blaster weapon2) {
        this(weapon1, weapon2, 20, "Battle Droid", "[BD02]");
    }

    protected DroidBD02(Blaster weapon1, Blaster weapon2, int defence, String name, String model) {
        super(weapon1, defence, name, model);
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
    public String toString() {
        return super.toString() +
                 "\n\t-- left hand -- " + leftHandWeapon;
    }
}
