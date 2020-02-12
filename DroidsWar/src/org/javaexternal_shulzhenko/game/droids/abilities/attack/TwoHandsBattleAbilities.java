package org.javaexternal_shulzhenko.game.droids.abilities.attack;

import org.javaexternal_shulzhenko.game.weapons.Weapon;

public interface TwoHandsBattleAbilities extends RightHandBattleAbilities {

    int attackWithTwoHandsWeapons();
    int attackWithLeftHandWeapon();
    Weapon getLeftHandWeapon();
    void setLeftHandWeapon(Weapon weapon);
    void reloadLeftHandWeapon();
    default int attackWithLeftHand(){
        return 1;
    }
}
