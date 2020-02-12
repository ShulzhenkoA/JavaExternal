package org.javaexternal_shulzhenko.game.factories;


import org.javaexternal_shulzhenko.game.droids.abilities.attack.RightHandBattleAbilities;
import org.javaexternal_shulzhenko.game.droids.abilities.attack.RightHandBattleProperties;
import org.javaexternal_shulzhenko.game.droids.abilities.attack.TwoHandBattleProperties;
import org.javaexternal_shulzhenko.game.droids.abilities.attack.TwoHandsBattleAbilities;
import org.javaexternal_shulzhenko.game.droids.abilities.repearing.RepairAbility;
import org.javaexternal_shulzhenko.game.droids.abilities.repearing.SmallRepairing;

public class DroidAbilitiesFactory {

    RightHandBattleAbilities makeRightHandBattleAbilities() {
        return new RightHandBattleProperties();
    }

    TwoHandsBattleAbilities makeTwoHandsBattleAbilities(){
        return new TwoHandBattleProperties();
    }

    RepairAbility makeRepairAbility(){
        return new SmallRepairing();
    }
}
