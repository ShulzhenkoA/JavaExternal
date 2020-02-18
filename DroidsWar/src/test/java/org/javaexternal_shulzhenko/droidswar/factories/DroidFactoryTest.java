package org.javaexternal_shulzhenko.droidswar.factories;

import org.javaexternal_shulzhenko.droidswar.droids.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DroidFactoryTest {

    DroidFactory factory;
    @BeforeEach
    void setUp() {
        factory = new DroidFactory();
    }

    @Test
    void gettingBasicDroidD01() {
        Droid droid = factory.getBasicDroidD01();
        assertTrue(droid instanceof Droid ? true : false);
    }

    @Test
    void gettingBattleDroidBD01() {
        Droid droid = factory.getBattleDroidBD01();
        assertTrue(droid instanceof DroidBD01);
    }

    @Test
    void gettingBattleDroidBD02() {
        Droid droid = factory.getBattleDroidBD02();
        assertTrue(droid instanceof DroidBD02);
    }

    @Test
    void gettingDroidDestroyerDD01() {
        Droid droid = factory.getDroidDestroyerDD01();
        assertTrue(droid instanceof DroidDD01);
    }

    @Test
    void gettingRepairDroidR1() {
        Droid droid = factory.getRepairDroidR1();
        assertTrue(droid instanceof DroidR1);
    }
}