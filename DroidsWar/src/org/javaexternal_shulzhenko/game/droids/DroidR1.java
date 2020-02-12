package org.javaexternal_shulzhenko.game.droids;

import org.javaexternal_shulzhenko.game.droids.abilities.repearing.RepairAbility;

public class DroidR1 extends Droid{

    private final int REPAIR_UNIT = 50;

    public DroidR1() {
        this(0, "Repair Droid", "R1");
    }

    protected DroidR1(int defense, String name, String model) {
        super(defense, name, model);
    }


    @Override
    public String toString() {
        return super.toString() +
                "\n{REPAIR_UNIT = " + REPAIR_UNIT + '}';
    }
}
