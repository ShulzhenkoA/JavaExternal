package org.javaexternal_shulzhenko.droidswar.droids;

import org.javaexternal_shulzhenko.droidswar.droids.abilities.attack.LeftHandBattleAbility;
import org.javaexternal_shulzhenko.droidswar.droids.abilities.attack.RightHandBattleAbility;
import org.javaexternal_shulzhenko.droidswar.droids.abilities.defence.TitaniumDestroyerDroidBody;
import org.javaexternal_shulzhenko.droidswar.droids.weapons.BlasterRifleE10;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DroidDD01Test {

    DroidDD01 droidDD01;
    DroidB01 droid;

    @BeforeEach
    void setThis() {
        droidDD01 = new DroidDD01(new RightHandBattleAbility(), new LeftHandBattleAbility(),new TitaniumDestroyerDroidBody());
        droid = new DroidB01();
    }

    @Test
    void attackingNotProtectedDroidWithBasicAttack() {

        int damage = 6;

        droidDD01.attack(droid);
        assertEquals(droid.getMaxHealth() - damage, droid.getHealth());
    }

    @Test
    void attackingNotProtectedDroidWithRightWeapon() {

        droidDD01.setWeaponInRightHand(new BlasterRifleE10());
        int damage = new BlasterRifleE10().shoot();

        droidDD01.attack(droid);
        assertEquals(droid.getMaxHealth() - damage, droid.getHealth());
    }

    @Test
    void attackingNotProtectedDroidWithLeftWeapon() {

        droidDD01.setWeaponInLeftHand(new BlasterRifleE10());
        int damage = new BlasterRifleE10().shoot();

        droidDD01.attack(droid);
        assertEquals(droid.getMaxHealth() - damage, droid.getHealth());
    }

    @Test
    void attackingNotProtectedDroidWithTwoWeapons() {

        droidDD01.setWeaponInRightHand(new BlasterRifleE10());
        droidDD01.setWeaponInLeftHand(new BlasterRifleE10());
        int damage = new BlasterRifleE10().shoot() + new BlasterRifleE10().shoot();

        droidDD01.attack(droid);
        assertEquals(droid.getMaxHealth() - damage, droid.getHealth());
    }

    @Test
    void reloadingWeapons() {
        BlasterRifleE10 blaster1 = new BlasterRifleE10();
        BlasterRifleE10 blaster2 = new BlasterRifleE10();
        blaster1.shoot();
        blaster2.shoot();
        droidDD01.setWeaponInRightHand(blaster1);
        droidDD01.setWeaponInLeftHand(blaster2);
        droidDD01.reloadTwoWeapons();
        assertEquals(100, blaster1.getAmmunition() + blaster2.getAmmunition());
    }
}