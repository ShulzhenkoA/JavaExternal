package org.javaexternal_shulzhenko.game.droids;

import org.javaexternal_shulzhenko.game.droids.abilities.attack.UseRightHandInBattle;
import org.javaexternal_shulzhenko.game.droids.abilities.defence.SteelBattleDroidBody;
import org.javaexternal_shulzhenko.game.weapons.Weapon;

public class DroidBD01 extends Droid{


    protected UseRightHandInBattle rightHandBattleAbility;


    public DroidBD01(UseRightHandInBattle rightHandBattleProperties, SteelBattleDroidBody protectiveBody) {
        this("Battle Droid", "[BD01]", 100, rightHandBattleProperties, protectiveBody);
    }

    protected DroidBD01(String name, String model, int maxHealth,
                        UseRightHandInBattle rightHandBattleAbility,
                        SteelBattleDroidBody protectiveBody) {
        super(name, model, maxHealth, protectiveBody);
        this.rightHandBattleAbility = rightHandBattleAbility;
    }

    @Override
    public void attack(Droid droid) {
        droid.receiveDamage(rightHandBattleAbility.attackWithRightHandWeapon());
    }

    public void setWeaponInRightHand(Weapon weapon){
        rightHandBattleAbility.setRightHandWeapon(weapon);
    }

    public void reloadWeapon(){
        rightHandBattleAbility.reloadRightHandWeapon();
    }

    @Override
    public String toString() {

        return super.toString() +
                "\n{weapon \n\t-- right hand -- "  + rightHandBattleAbility.getRightHandWeapon().toString() + "}\n";
    }
}
