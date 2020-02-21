package org.javaexternal_shulzhenko.droidswar.droids.abilities.attack;

import org.javaexternal_shulzhenko.droidswar.droids.weapons.Weapon;

public interface UseLeftHandInBattle extends BattleAble {
    int attackWithLeftHand();
    Weapon getLeftHandWeapon();
    void setLeftHandWeapon(Weapon weapon);
    void reloadLeftHandWeapon();
}
