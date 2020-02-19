package org.javaexternal_shulzhenko.droidswar.droids;

import org.javaexternal_shulzhenko.droidswar.droids.abilities.defence.BasicDroidBody;
import org.javaexternal_shulzhenko.droidswar.droids.abilities.repearing.SmallRepairing;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DroidR1Test {

    DroidRD01 droidR1;
    DroidB01 droid;

    @BeforeEach
    void setThis() {
        droidR1 = new DroidRD01(new SmallRepairing(), new BasicDroidBody());
        droid = new DroidB01();
    }

    @Test
    void doingRepair() {
        droid.receiveDamage(50);
        droidR1.doRepair(droid);
        Assertions.assertEquals(droid.getMaxHealth(), droid.getHealth());
    }
}