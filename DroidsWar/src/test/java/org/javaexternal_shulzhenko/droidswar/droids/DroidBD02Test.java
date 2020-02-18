package org.javaexternal_shulzhenko.droidswar.droids;

import org.javaexternal_shulzhenko.droidswar.droids.abilities.attack.LeftHandBattleAbility;
import org.javaexternal_shulzhenko.droidswar.droids.abilities.attack.RightHandBattleAbility;
import org.javaexternal_shulzhenko.droidswar.droids.abilities.defence.SteelBattleDroidBody;
import org.javaexternal_shulzhenko.droidswar.weapons.BlasterRifleE5;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DroidBD02Test {

    DroidBD02 droidBD02;
    Droid droid;

    @BeforeEach
    void setThis() {
        droidBD02 = new DroidBD02(new RightHandBattleAbility(), new LeftHandBattleAbility(),new SteelBattleDroidBody());
        droid = new Droid();
    }

    @Test
    void attackingNotProtectedDroidWithBasicAttack() {

        int damage = 4;

        droidBD02.attack(droid);
        assertEquals(droid.getMaxHealth() - damage, droid.getHealth());
    }

    @Test
    void attackingNotProtectedDroidWithRightWeapon() {

        droidBD02.setWeaponInRightHand(new BlasterRifleE5());
        int damage = new BlasterRifleE5().shoot();

        droidBD02.attack(droid);
        assertEquals(droid.getMaxHealth() - damage, droid.getHealth());
    }

    @Test
    void attackingNotProtectedDroidWithLeftWeapon() {

        droidBD02.setWeaponInLeftHand(new BlasterRifleE5());
        int damage = new BlasterRifleE5().shoot();

        droidBD02.attack(droid);
        assertEquals(droid.getMaxHealth() - damage, droid.getHealth());
    }

    @Test
    void attackingNotProtectedDroidWithTwoWeapons() {

        droidBD02.setWeaponInRightHand(new BlasterRifleE5());
        droidBD02.setWeaponInLeftHand(new BlasterRifleE5());
        int damage = new BlasterRifleE5().shoot() + new BlasterRifleE5().shoot();

        droidBD02.attack(droid);
        assertEquals(droid.getMaxHealth() - damage, droid.getHealth());
    }

    @Test
    void reloadingWeapons() {
        BlasterRifleE5 blaster1 = new BlasterRifleE5();
        BlasterRifleE5 blaster2 = new BlasterRifleE5();
        blaster1.shoot();
        blaster2.shoot();
        droidBD02.setWeaponInRightHand(blaster1);
        droidBD02.setWeaponInLeftHand(blaster2);
        droidBD02.reloadTwoWeapons();
        assertEquals(100, blaster1.getAmmunition() + blaster2.getAmmunition());
    }
}