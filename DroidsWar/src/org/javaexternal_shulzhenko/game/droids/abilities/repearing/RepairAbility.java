package org.javaexternal_shulzhenko.game.droids.abilities.repearing;


import org.javaexternal_shulzhenko.game.droids.Droid;

public interface RepairAbility {
    void repair(Droid droid);
    int getRepairUnit();
}
