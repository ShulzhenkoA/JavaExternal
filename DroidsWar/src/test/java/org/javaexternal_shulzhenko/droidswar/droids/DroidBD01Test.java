package org.javaexternal_shulzhenko.droidswar.droids;

import org.javaexternal_shulzhenko.droidswar.droids.abilities.attack.DamageAble;
import org.javaexternal_shulzhenko.droidswar.droids.abilities.attack.RightHandBattleAbility;
import org.javaexternal_shulzhenko.droidswar.droids.abilities.defence.SteelBattleDroidBody;
import org.javaexternal_shulzhenko.droidswar.droids.weapons.BlasterRifleE5;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DroidBD01Test {

    DroidBD01 droidBD01;
    DroidB01 droid;

    @BeforeEach
    void setThis() {
        droidBD01 = new DroidBD01(new RightHandBattleAbility(), new SteelBattleDroidBody());
        droid = new DroidB01();
    }

    @Test
    void attackingNotProtectedDroidWithBasicAttack() {

        int damage = droidBD01.INCR_BASIC_DAMAGE;

        droidBD01.attack(droid);
        assertEquals(droid.getMaxHealth() - damage, droid.getHealth());
    }

    @Test
    void attackingNotProtectedDroidWithWeapon() {

        droidBD01.setWeaponInRightHand(new BlasterRifleE5());
        int damage = new BlasterRifleE5().shoot();

        droidBD01.attack(droid);
        assertEquals(droid.getMaxHealth() - damage, droid.getHealth());
    }

    @Test
    void reloadingWeapon() {
        BlasterRifleE5 blaster = new BlasterRifleE5();
        blaster.shoot();
        blaster.shoot();
        droidBD01.setWeaponInRightHand(blaster);
        droidBD01.reloadRightWeapon();
        assertEquals(50, blaster.getAmmunition());

    }
}