package org.javaexternal_shulzhenko.droidswar.factories;

import org.javaexternal_shulzhenko.droidswar.weapons.BlasterRifleE10;
import org.javaexternal_shulzhenko.droidswar.weapons.BlasterRifleE5;
import org.javaexternal_shulzhenko.droidswar.weapons.Weapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;

import static org.junit.jupiter.api.Assertions.*;

class WeaponFactoryTest {

    WeaponFactory weaponFactory;

    @BeforeEach
    void setUp() {
        weaponFactory = new WeaponFactory();
    }

    @Test
    void makingBlasterRifleE5() {
        String model = "E5";
        Weapon weapon = weaponFactory.makeWeapon(model);
        assertTrue(weapon instanceof BlasterRifleE5);
    }

    @Test
    void makingBlasterRifleE10() {
        String model = "E10";
        Weapon weapon = weaponFactory.makeWeapon(model);
        assertTrue(weapon instanceof BlasterRifleE10);
    }
}