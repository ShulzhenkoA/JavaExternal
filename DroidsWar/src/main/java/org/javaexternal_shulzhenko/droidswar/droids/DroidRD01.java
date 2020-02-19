package org.javaexternal_shulzhenko.droidswar.droids;

import org.javaexternal_shulzhenko.droidswar.droids.abilities.defence.ProtectiveBody;
import org.javaexternal_shulzhenko.droidswar.droids.abilities.repearing.RepairAbility;
import org.javaexternal_shulzhenko.droidswar.droids.abilities.repearing.SelfRepairAble;

public class DroidRD01 extends DroidB01 implements SelfRepairAble {

    RepairAbility repairAbility;

    public DroidRD01(RepairAbility repairAbility, ProtectiveBody protectiveBody) {
        this("Repair DroidRD01", "[RD01]", 105, protectiveBody);
        this.repairAbility = repairAbility;
    }

    protected DroidRD01(String name, String model, int maxHealth, ProtectiveBody protectiveBody) {
        super(name, model, maxHealth, protectiveBody);
    }

    public void doRepair(DroidB01 droid){
        if(engine.droidWorkingFromEnergyConsumption()){
            repairAbility.repair(droid);
        }
    }

    @Override
    public void repairIfSelf() {
        if(isAlive() && engine.droidWorkingFromEnergyConsumption()){
            int pointsToHeal = getHealth() + 30;
            if(pointsToHeal<=getMaxHealth()){
                setHealth(pointsToHeal);
            }else{
                setHealth(getMaxHealth());
            }
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n{REPAIR_UNIT = " + repairAbility.getRepairUnit() + '}';
    }

}
