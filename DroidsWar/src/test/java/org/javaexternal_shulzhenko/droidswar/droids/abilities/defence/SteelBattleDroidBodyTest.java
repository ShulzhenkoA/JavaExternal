package org.javaexternal_shulzhenko.droidswar.droids.abilities.defence;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SteelBattleDroidBodyTest {

    SteelBattleDroidBody steelBattleDroidBody;

    @BeforeEach
    void setUp() {
        steelBattleDroidBody = new SteelBattleDroidBody();
    }

    @Test
    void defendingFromAttackWithPeriodicity() {
        int defence = steelBattleDroidBody.defendFromAttack();
        Assertions.assertTrue(defence == 30 || defence == 0);
    }
}