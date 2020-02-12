package org.javaexternal_shulzhenko.game.droids.abilities.attack;

import org.javaexternal_shulzhenko.game.weapons.Weapon;

public class TwoHandBattleProperties extends RightHandBattleProperties implements TwoHandsBattleAbilities{

    private Weapon leftHandWeapon;

    @Override
    public int attackWithTwoHandsWeapons() {
        return leftHandWeapon.shoot() + rightHandWeapon.shoot();
    }

    @Override
    public int attackWithLeftHandWeapon() {
        return leftHandWeapon.shoot();
    }

    @Override
    public Weapon getLeftHandWeapon() {
        return leftHandWeapon;
    }

    @Override
    public void setLeftHandWeapon(Weapon weapon) {
        leftHandWeapon = weapon;
    }

    @Override
    public void reloadLeftHandWeapon() {
        leftHandWeapon.reloadAmmunition();
    }
}
