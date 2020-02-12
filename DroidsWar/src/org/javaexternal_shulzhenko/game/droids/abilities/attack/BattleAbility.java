package org.javaexternal_shulzhenko.game.droids.abilities.attack;

public interface BattleAbility {
    default int attackWithHands(){
        return 2;
    }
}
