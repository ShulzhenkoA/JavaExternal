package org.javaexternal_shulzhenko.game.droids;

import org.javaexternal_shulzhenko.game.weapons.*;

public class DroidBD02 extends DroidBD01 {

    public DroidBD02(Weapon weapon1, Weapon weapon2) {
        this(weapon1, weapon2, "Battle Droid", "[BD02]");
    }

    protected DroidBD02(Weapon weapon1, Weapon weapon2, String name, String model) {
        super(name, model, );
        leftHandWeapon = weapon2;
    }

    @Override
    public int attackEnemy() {
        return super.attackEnemy() + leftHandWeapon.shoot();
    }



    @Override
    public String toString() {
        return super.toString() +
                 "\n\t-- left hand -- " + leftHandWeapon;
    }
}
