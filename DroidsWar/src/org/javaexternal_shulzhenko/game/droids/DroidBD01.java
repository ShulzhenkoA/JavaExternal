package org.javaexternal_shulzhenko.game.droids;

import org.javaexternal_shulzhenko.game.droids.abilities.attack.RightHandBattleProperties;
import org.javaexternal_shulzhenko.game.droids.abilities.defence.ProtectiveBody;

public class DroidBD01 extends Droid{


    private RightHandBattleProperties rightHandBattleProperties;

    public DroidBD01(RightHandBattleProperties rightHandBattleProperties, ProtectiveBody protectiveBody) {
        this("Battle Droid", "[BD01]", 100, protectiveBody);
        this.rightHandBattleProperties = rightHandBattleProperties;
        this.protectiveBody = protectiveBody;
    }

    protected DroidBD01(String name, String model, int maxHealth, ProtectiveBody protectiveBody) {
        super(name, model, maxHealth, protectiveBody);
    }



    @Override
    public String toString() {

        return super.toString() +
                "\n{weapon \n\t-- right hand -- "  + rightHandBattleProperties.getRightHandWeapon();
    }
}
