package org.javaexternal_shulzhenko.droidswar.droids.abilities.attack;

public interface BattleAbility {
    default int attackWithHands(){
        return 2;
    }
}
