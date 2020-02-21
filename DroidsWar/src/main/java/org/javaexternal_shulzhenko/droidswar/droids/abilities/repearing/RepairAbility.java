package org.javaexternal_shulzhenko.droidswar.droids.abilities.repearing;


import org.javaexternal_shulzhenko.droidswar.droids.DroidB01;

import java.io.Serializable;

public interface RepairAbility extends Serializable {
    void repair(DroidB01 droid);
    int getRepairUnit();
}
