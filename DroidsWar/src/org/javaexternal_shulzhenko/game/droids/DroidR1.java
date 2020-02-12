package org.javaexternal_shulzhenko.game.droids;

import org.javaexternal_shulzhenko.game.droids.abilities.repearing.RepairAbility;

public class DroidR1 extends Droid{

    RepairAbility repairAbility;

    public DroidR1(RepairAbility repairAbility) {
        this(100,"Repair Droid", "R1");
        this.repairAbility = repairAbility;
    }

    protected DroidR1(int maxHealth ,String name, String model) {
        super(name, model, );
    }

    public void doRepair(Droid droid){
        repairAbility.repair(droid);
    }


    @Override
    public String toString() {
        return super.toString() +
                "\n{REPAIR_UNIT = " + repairAbility.getRepairUnit() + '}';
    }
}
