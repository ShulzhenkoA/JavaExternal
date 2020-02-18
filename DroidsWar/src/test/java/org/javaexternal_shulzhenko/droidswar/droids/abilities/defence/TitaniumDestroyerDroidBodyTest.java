package org.javaexternal_shulzhenko.droidswar.droids.abilities.defence;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TitaniumDestroyerDroidBodyTest {

    TitaniumDestroyerDroidBody titaniumDestroyerDroidBody;

    @BeforeEach
    void setUp() {
        titaniumDestroyerDroidBody = new TitaniumDestroyerDroidBody();
    }

    @Test
    void defendingFromAttackWithPeriodicity() {
        int defence = titaniumDestroyerDroidBody.defendFromAttack();
        Assertions.assertTrue(defence == 40 || defence == 0);
    }

}