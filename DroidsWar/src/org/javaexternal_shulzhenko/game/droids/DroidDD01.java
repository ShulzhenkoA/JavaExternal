package org.javaexternal_shulzhenko.game.droids;

import org.javaexternal_shulzhenko.game.weapons.Blaster;

public class DroidDD01 extends DroidBD02 {


    public DroidDD01(Blaster weapon1, Blaster weapon2) {
        this(weapon1, weapon2, 35, "Droid Destroyer", "[DD01]");

    }

    protected DroidDD01(Blaster weapon1, Blaster weapon2, int defence, String name, String model) {
        super(weapon1, weapon2, defence, name, model);
    }

}
