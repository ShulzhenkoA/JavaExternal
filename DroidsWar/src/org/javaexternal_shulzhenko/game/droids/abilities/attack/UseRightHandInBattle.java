package org.javaexternal_shulzhenko.game.droids.abilities.attack;

import org.javaexternal_shulzhenko.game.weapons.Weapon;

public interface UseRightHandInBattle extends BattleAbility {

    int attackWithRightHandWeapon();
    Weapon getRightHandWeapon();
    void setRightHandWeapon(Weapon weapon);
    void reloadRightHandWeapon();
}
