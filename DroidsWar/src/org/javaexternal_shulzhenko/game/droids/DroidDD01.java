package org.javaexternal_shulzhenko.game.droids;

import org.javaexternal_shulzhenko.game.weapons.Weapon;

public class DroidDD01 extends DroidBD02 {


    public DroidDD01(Weapon weapon1, Weapon weapon2) {
        this(weapon1, weapon2, "Droid Destroyer", "[DD01]");

    }

    protected DroidDD01(Weapon weapon1, Weapon weapon2, String name, String model) {
        super(weapon1, weapon2, name, model);
    }

}
