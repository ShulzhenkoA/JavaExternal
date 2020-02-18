package org.javaexternal_shulzhenko.droidswar.droids.abilities.repearing;

import org.javaexternal_shulzhenko.droidswar.droids.Droid;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmallRepairingTest {

    Droid droid;
    SmallRepairing smallRepairing;
    @BeforeEach

    void setUp() {
        droid = new Droid();
        smallRepairing = new SmallRepairing();
    }

    @Test
    void performingRepairAbility() {
        droid.receiveDamage(50);
        smallRepairing.repair(droid);
        Assertions.assertEquals(droid.getMaxHealth(), droid.getHealth());
    }

    @Test
    void performingAbilityToRepairDestroyedDroid() {
        droid.receiveDamage(droid.getMaxHealth());
        smallRepairing.repair(droid);
        Assertions.assertTrue(droid.isAlive());
    }
}