package org.javaexternal_shulzhenko.droidswar.droids.abilities.attack;

import org.javaexternal_shulzhenko.droidswar.weapons.Weapon;

public interface UseRightHandInBattle extends BattleAbility {

    int attackWithRightHand();
    Weapon getRightHandWeapon();
    void setRightHandWeapon(Weapon weapon);
    void reloadRightHandWeapon();
}
