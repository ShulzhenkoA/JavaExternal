package org.javaexternal_shulzhenko.droidswar.factories;


import org.javaexternal_shulzhenko.droidswar.droids.abilities.attack.LeftHandBattleAbility;
import org.javaexternal_shulzhenko.droidswar.droids.abilities.attack.RightHandBattleAbility;
import org.javaexternal_shulzhenko.droidswar.droids.abilities.repearing.SmallRepairing;

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
