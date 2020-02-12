package org.javaexternal_shulzhenko.game.droids.abilities.attack;

import org.javaexternal_shulzhenko.game.weapons.Weapon;

public interface BattleAbility {
    default int attackWithHands(){
        return 2;
    }
}
