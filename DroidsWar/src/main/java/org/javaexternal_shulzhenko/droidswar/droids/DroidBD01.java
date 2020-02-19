package org.javaexternal_shulzhenko.droidswar.droids;

import org.javaexternal_shulzhenko.droidswar.droids.abilities.attack.BattleAble;
import org.javaexternal_shulzhenko.droidswar.droids.abilities.attack.UseRightHandInBattle;
import org.javaexternal_shulzhenko.droidswar.droids.abilities.defence.SteelBattleDroidBody;
import org.javaexternal_shulzhenko.droidswar.weapons.Weapon;

public class DroidBD01 extends DroidB01 implements BattleAble {


    protected UseRightHandInBattle rightHandBattleAbility;


    public DroidBD01(UseRightHandInBattle rightHandBattleProperties, SteelBattleDroidBody protectiveBody) {
        this("Battle DroidBD01", "[BD01]", 110, rightHandBattleProperties, protectiveBody);
    }

    protected DroidBD01(String name, String model, int maxHealth,
                        UseRightHandInBattle rightHandBattleAbility,
                        SteelBattleDroidBody protectiveBody) {
        super(name, model, maxHealth, protectiveBody);
        this.rightHandBattleAbility = rightHandBattleAbility;
    }

    public void attack(DroidB01 droid) {
        if(engine.droidWorkingFromEnergyConsumption()){
            droid.receiveDamage(rightHandBattleAbility.attackWithRightHand());
        }
    }

    public void setWeaponInRightHand(Weapon weapon){
        if(engine.droidWorkingFromEnergyConsumption()){
            rightHandBattleAbility.setRightHandWeapon(weapon);
        }
    }

    public void reloadRightWeapon(){
        if(engine.droidWorkingFromEnergyConsumption()){
            rightHandBattleAbility.reloadRightHandWeapon();
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n{weapon \n\t-- right hand -- "  + rightHandBattleAbility.toString() + "}\n";
    }
}
