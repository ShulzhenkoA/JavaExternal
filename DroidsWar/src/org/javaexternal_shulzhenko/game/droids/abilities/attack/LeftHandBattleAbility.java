package org.javaexternal_shulzhenko.game.droids.abilities.attack;

import org.javaexternal_shulzhenko.game.weapons.Weapon;

public class LeftHandBattleAbility implements UseLeftHandInBattle {

    protected Weapon weapon;

    @Override
    public int attackWithLeftHandWeapon() {
        return weapon.shoot();
    }

    @Override
    public Weapon getLeftHandWeapon() {
        return weapon;
    }

    @Override
    public void setLeftHandWeapon(Weapon weapon) {
        this.weapon=weapon;
    }

    @Override
    public void reloadLeftHandWeapon() {
        weapon.reloadAmmunition();
    }
}
