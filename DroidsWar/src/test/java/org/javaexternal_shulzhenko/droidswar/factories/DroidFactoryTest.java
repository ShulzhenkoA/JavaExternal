package org.javaexternal_shulzhenko.droidswar.factories;

import org.javaexternal_shulzhenko.droidswar.droids.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DroidFactoryTest {


    @Test
    void gettingBasicDroidD01() {
        DroidB01 droid = DroidFactory.getDroidFactory().getBasicDroidB01();
        assertTrue(droid instanceof DroidB01 ? true : false);
    }

    @Test
    void gettingBattleDroidBD01() {
        DroidB01 droid = DroidFactory.getDroidFactory().getBattleDroidBD01();
        assertTrue(droid instanceof DroidBD01);
    }

    @Test
    void gettingBattleDroidBD02() {
        DroidB01 droid = DroidFactory.getDroidFactory().getBattleDroidBD02();
        assertTrue(droid instanceof DroidBD02);
    }

    @Test
    void gettingDroidDestroyerDD01() {
        DroidB01 droid = DroidFactory.getDroidFactory().getDroidDestroyerDD01();
        assertTrue(droid instanceof DroidDD01);
    }

    @Test
    void gettingRepairDroidR1() {
        DroidB01 droid = DroidFactory.getDroidFactory().getRepairDroidRD01();
        assertTrue(droid instanceof DroidRD01);
    }
}