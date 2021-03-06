package org.javaexternal_shulzhenko.droidswar.droids.abilities.repearing;

import org.javaexternal_shulzhenko.droidswar.droids.DroidB01;

public class SmallRepairing implements RepairAbility {

    private final int REPAIR_UNIT = 50;

    @Override
    public void repair(DroidB01 droid) {

        if(!droid.isAlive()){
            droid.setAlive(true);
            droid.setHealth(REPAIR_UNIT);
        }else if(droid.getHealth() < droid.getMaxHealth()){
            droid.setHealth(droid.getHealth()+REPAIR_UNIT);

            if(droid.getHealth() > droid.getMaxHealth()){
                droid.setHealth(droid.getMaxHealth());
            }
        }
    }

    @Override
    public int getRepairUnit() {
        return REPAIR_UNIT;
    }
}
