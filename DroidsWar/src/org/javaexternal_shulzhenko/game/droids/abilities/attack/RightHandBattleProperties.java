package org.javaexternal_shulzhenko.game.droids.abilities.attack;

import org.javaexternal_shulzhenko.game.weapons.Weapon;

public class RightHandBattleProperties implements RightHandBattleAbilities {

    private Weapon rightHandWeapon;


    @Override
    public int attackWithRightHandWeapon() {
        return rightHandWeapon.shoot();
    }

    @Override
    public Weapon getRightHandWeapon() {
        return rightHandWeapon;
    }

    @Override
    public void setRightHandWeapon(Weapon weapon) {
        rightHandWeapon = weapon;
    }

    @Override
    public void reloadRightHandWeapon() {
        rightHandWeapon.reloadAmmunition();
    }
}
