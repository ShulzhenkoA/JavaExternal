package org.javaexternal_shulzhenko.droidswar.droids.abilities.attack;

import org.javaexternal_shulzhenko.droidswar.weapons.BlasterRifleE5;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeftHandBattleAbilityTest {

    LeftHandBattleAbility leftHandBattleAbility;

    @BeforeEach
    void setUp() {
        leftHandBattleAbility = new LeftHandBattleAbility();
    }

    @Test
    void attackingWithLeftHandNoWeapon() {
        int damage = 2;
        assertEquals(damage,leftHandBattleAbility.attackWithLeftHand());
    }

    @Test
    void attackingWithLeftHandWeapon() {
        int damage = 10;
        leftHandBattleAbility.setLeftHandWeapon(new BlasterRifleE5());
        assertEquals(damage, leftHandBattleAbility.attackWithLeftHand());
    }

    @Test
    void reloadingLeftHandWeapon() {
        BlasterRifleE5 blasterRifleE5 = new BlasterRifleE5();
        int blasterAmmunition = blasterRifleE5.getAmmunition();
        blasterRifleE5.shoot();
        leftHandBattleAbility.setLeftHandWeapon(blasterRifleE5);
        leftHandBattleAbility.reloadLeftHandWeapon();
        assertEquals(blasterAmmunition, blasterRifleE5.getAmmunition());
    }
}