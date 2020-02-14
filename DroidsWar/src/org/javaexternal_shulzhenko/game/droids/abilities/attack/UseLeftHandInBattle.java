package org.javaexternal_shulzhenko.game.droids.abilities.attack;

import org.javaexternal_shulzhenko.game.weapons.Weapon;

public interface UseLeftHandInBattle extends BattleAbility{
    int attackWithLeftHandWeapon();
    Weapon getLeftHandWeapon();
    void setLeftHandWeapon(Weapon weapon);
    void reloadLeftHandWeapon();
}
