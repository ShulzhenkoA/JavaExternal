package org.javaexternal_shulzhenko.droidswar.droids.abilities.defence;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BasicDroidBodyTest {

    BasicDroidBody basicDroidBody;
    @BeforeEach
    void setUp() {
        basicDroidBody = new BasicDroidBody();
    }

    @Test
    void defendingFromAttackWithPeriodicity() {
        int defence = basicDroidBody.defendFromAttack();
        Assertions.assertTrue(defence == 5 || defence == 0);
    }
}