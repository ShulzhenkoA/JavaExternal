package org.javaexternal_shulzhenko.game.droids;

import org.javaexternal_shulzhenko.game.droids.abilities.defence.ProtectiveBody;
import org.javaexternal_shulzhenko.game.droids.abilities.repearing.RepairAbility;

public class DroidR1 extends Droid{

    RepairAbility repairAbility;

    public DroidR1(RepairAbility repairAbility, ProtectiveBody protectiveBody) {
        this("Repair Droid", "[R1]", 100, protectiveBody);
        this.repairAbility = repairAbility;
    }

    protected DroidR1(String name, String model, int maxHealth, ProtectiveBody protectiveBody) {
        super(name, model, maxHealth, protectiveBody);
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
