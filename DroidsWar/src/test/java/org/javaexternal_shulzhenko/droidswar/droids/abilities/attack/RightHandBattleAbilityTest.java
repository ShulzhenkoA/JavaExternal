package org.javaexternal_shulzhenko.droidswar.droids.abilities.attack;

import org.javaexternal_shulzhenko.droidswar.droids.weapons.BlasterRifleE5;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RightHandBattleAbilityTest {
    RightHandBattleAbility rightHandBattleAbility;

    @BeforeEach
    void setUp() {
        rightHandBattleAbility = new RightHandBattleAbility();
    }

    @Test
    void attackingWithLeftHandNoWeapon() {
        int damage = 3;
        assertEquals(damage, rightHandBattleAbility.attackWithRightHand());
    }

    @Test
    void attackingWithLeftHandWeapon() {
        int damage = 10;
        rightHandBattleAbility.setRightHandWeapon(new BlasterRifleE5());
        assertEquals(damage, rightHandBattleAbility.attackWithRightHand());
    }

    @Test
    void reloadingLeftHandWeapon() {
        BlasterRifleE5 blasterRifleE5 = new BlasterRifleE5();
        int blasterAmmunition = blasterRifleE5.getAmmunition();
        blasterRifleE5.shoot();
        rightHandBattleAbility.setRightHandWeapon(blasterRifleE5);
        rightHandBattleAbility.reloadRightHandWeapon();
        assertEquals(blasterAmmunition, blasterRifleE5.getAmmunition());
    }

}