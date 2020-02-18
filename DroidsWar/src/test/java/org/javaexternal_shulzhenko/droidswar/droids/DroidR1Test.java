package org.javaexternal_shulzhenko.droidswar.droids;

import org.javaexternal_shulzhenko.droidswar.droids.abilities.defence.BasicDroidBody;
import org.javaexternal_shulzhenko.droidswar.droids.abilities.repearing.SmallRepairing;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DroidR1Test {

    DroidR1 droidR1;
    Droid droid;

    @BeforeEach
    void setThis() {
        droidR1 = new DroidR1(new SmallRepairing(), new BasicDroidBody());
        droid = new Droid();
    }

    @Test
    void doingRepair() {
        droid.receiveDamage(50);
        droidR1.doRepair(droid);
        Assertions.assertEquals(droid.getMaxHealth(), droid.getHealth());
    }
}