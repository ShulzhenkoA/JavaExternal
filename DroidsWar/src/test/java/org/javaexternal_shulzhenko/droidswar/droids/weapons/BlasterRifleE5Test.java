package org.javaexternal_shulzhenko.droidswar.droids.weapons;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlasterRifleE5Test {

    BlasterRifleE5 blasterRifleE5;

    @BeforeEach
    void setUp() {
        blasterRifleE5 = new BlasterRifleE5();
    }

    @Test
    void shootingDealsDamage() {
        int damage = 10;
        assertEquals(damage, blasterRifleE5.shoot());
    }

    @Test
    void shootingWithNoAmmunition() {
        for (int i = 0; i < 50; i++) {
            blasterRifleE5.shoot();
        }
        int damage = 0;
        assertEquals(damage, blasterRifleE5.shoot());
    }
}