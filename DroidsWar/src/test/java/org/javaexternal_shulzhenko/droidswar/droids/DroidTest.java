package org.javaexternal_shulzhenko.droidswar.droids;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DroidTest {

    Droid firstDroid;
    Droid secondDroid;

    @BeforeEach
    void setThis() {
        firstDroid = new Droid();
        secondDroid = new Droid();
    }

    @Test
    void BasicAttackOfDroid() {
        int damage = firstDroid.attackWithHands();
        Assertions.assertEquals(2, damage);
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