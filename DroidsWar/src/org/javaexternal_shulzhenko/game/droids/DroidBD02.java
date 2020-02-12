package org.javaexternal_shulzhenko.game.droids;

import org.javaexternal_shulzhenko.game.weapons.*;

public class DroidBD02 extends DroidBD01 {

    private Weapon leftHandWeapon;


    public DroidBD02(Weapon weapon1, Weapon weapon2) {
        this(weapon1, weapon2, 20, "Battle Droid", "[BD02]");
    }

    protected DroidBD02(Weapon weapon1, Weapon weapon2, int defence, String name, String model) {
        super(weapon1, defence, name, model);
        leftHandWeapon = weapon2;
    }

    @Override
    public int attackEnemy() {
        return super.attackEnemy() + leftHandWeapon.shoot();
    }

    public Weapon getLeftHandWeapon() {
        return leftHandWeapon;
    }

    public void setLeftHandWeapon(Weapon leftHandWeapon) {
        this.leftHandWeapon = leftHandWeapon;
    }

    @Override
    public String toString() {
        return super.toString() +
                 "\n\t-- left hand -- " + leftHandWeapon;
    }
}
