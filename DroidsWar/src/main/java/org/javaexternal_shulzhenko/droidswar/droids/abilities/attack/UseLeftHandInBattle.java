package org.javaexternal_shulzhenko.droidswar.droids.abilities.attack;

import org.javaexternal_shulzhenko.droidswar.weapons.Weapon;

public interface UseLeftHandInBattle extends BattleAbility{
    int attackWithLeftHand();
    Weapon getLeftHandWeapon();
    void setLeftHandWeapon(Weapon weapon);
    void reloadLeftHandWeapon();
}
