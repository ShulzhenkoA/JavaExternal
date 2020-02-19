package org.javaexternal_shulzhenko.droidswar.droids;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DroidB01Test {

    DroidB01 firstDroid;
    DroidB01 secondDroid;

    @BeforeEach
    void setThis() {
        firstDroid = new DroidB01();
        secondDroid = new DroidB01();
    }


    @Test
    void AttackAnotherDroid() {
        firstDroid.attack(secondDroid);
        Assertions.assertEquals(secondDroid.getMaxHealth() - 2, secondDroid.getHealth());
    }

    @Test
    void ReceiveDamage_ReduceItsHealth() {
        int damage = 11;
        firstDroid.receiveDamage(damage);
        Assertions.assertEquals(firstDroid.getMaxHealth() - damage, firstDroid.getHealth());
    }

    @Test
    void CheckAlive_DroidHPFallToZero_SetItsAliveToFalse() {
        firstDroid.setHealth(0);
        firstDroid.checkAlive();
        Assertions.assertTrue(!firstDroid.isAlive());
    }
}