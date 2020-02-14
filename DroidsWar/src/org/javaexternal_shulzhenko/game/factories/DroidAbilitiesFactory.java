package org.javaexternal_shulzhenko.game.factories;


import org.javaexternal_shulzhenko.game.droids.abilities.attack.LeftHandBattleAbility;
import org.javaexternal_shulzhenko.game.droids.abilities.attack.RightHandBattleAbility;
import org.javaexternal_shulzhenko.game.droids.abilities.repearing.SmallRepairing;

public class DroidAbilitiesFactory {

    RightHandBattleAbility makeRightHandBattleAbility() {
        return new RightHandBattleAbility();
    }

    LeftHandBattleAbility makeLeftHandBattleAbility(){
        return new LeftHandBattleAbility();
    }

    SmallRepairing makeSmallRepairAbility(){
        return new SmallRepairing();
    }
}
