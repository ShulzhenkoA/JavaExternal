package org.javaexternal_shulzhenko.droidswar.weapons;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlasterRifleE10Test {
    BlasterRifleE10 blasterRifleE10;

    @BeforeEach
    void setUp() {
        blasterRifleE10 = new BlasterRifleE10();
    }

    @Test
    void shootingDealsDamage() {
        int damage = 17;
        assertEquals(damage, blasterRifleE10.shoot());
    }

    @Test
    void shootingWithNoAmmunition() {
        for (int i = 0; i < 50; i++) {
            blasterRifleE10.shoot();
        }
        int damage = 0;
        assertEquals(damage, blasterRifleE10.shoot());
    }

}