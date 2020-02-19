package org.javaexternal_shulzhenko.droidswar.droids;

import org.javaexternal_shulzhenko.droidswar.console.ConsoleView;
import org.javaexternal_shulzhenko.droidswar.droids.abilities.attack.LeftHandBattleAbility;
import org.javaexternal_shulzhenko.droidswar.droids.abilities.attack.RightHandBattleAbility;
import org.javaexternal_shulzhenko.droidswar.droids.abilities.attack.UseLeftHandInBattle;
import org.javaexternal_shulzhenko.droidswar.droids.abilities.attack.UseRightHandInBattle;
import org.javaexternal_shulzhenko.droidswar.droids.abilities.defence.SteelBattleDroidBody;
import org.javaexternal_shulzhenko.droidswar.weapons.*;

public class DroidBD02 extends DroidBD01 {

    protected UseLeftHandInBattle leftHandBattleAbility;

    public DroidBD02(UseRightHandInBattle rightHandBattleAbility,
                     UseLeftHandInBattle leftHandBattleAbility,
                     SteelBattleDroidBody protectiveBody) {
        this("Battle DroidBD02", "[BD02]", 120,
                rightHandBattleAbility, leftHandBattleAbility, protectiveBody);

    }

    protected DroidBD02(String name, String model, int maxHealth,
                        UseRightHandInBattle rightHandBattleAbility,
                        UseLeftHandInBattle leftHandBattleAbility,
                        SteelBattleDroidBody protectiveBody) {
        super(name, model,maxHealth, rightHandBattleAbility,protectiveBody);
        this.leftHandBattleAbility = leftHandBattleAbility;
    }

    @Override
    public void attack(DroidB01 droid) {
        if(engine.droidWorkingFromEnergyConsumption()){
            if((rightHandBattleAbility.attackWithRightHand() > 3 && leftHandBattleAbility.attackWithLeftHand() >3) ||
                    (rightHandBattleAbility.attackWithRightHand() == 3 && leftHandBattleAbility.attackWithLeftHand() == 3)){
                droid.receiveDamage(rightHandBattleAbility.attackWithRightHand() +
                        leftHandBattleAbility.attackWithLeftHand());
            }else if(rightHandBattleAbility.attackWithRightHand() > 3 &&
                    leftHandBattleAbility.attackWithLeftHand() == 3){
                droid.receiveDamage(rightHandBattleAbility.attackWithRightHand());
            }else{
                droid.receiveDamage(leftHandBattleAbility.attackWithLeftHand());
            }
        }
    }

    @Override
    public void setWeaponInRightHand(Weapon weapon) {
        if(engine.droidWorkingFromEnergyConsumption()){
            rightHandBattleAbility.setRightHandWeapon(weapon);
        }
    }

    public void setWeaponInLeftHand(Weapon weapon){
        if(engine.droidWorkingFromEnergyConsumption()){
            leftHandBattleAbility.setLeftHandWeapon(weapon);
        }
    }

    public void reloadTwoWeapons() {
        if(engine.droidWorkingFromEnergyConsumption()){
            rightHandBattleAbility.reloadRightHandWeapon();
            leftHandBattleAbility.reloadLeftHandWeapon();
        }
    }

    @Override
    public String toString() {
        String toReturn = super.toString();
        return  toReturn.substring(0,toReturn.length() - 2) +
                 "\n\t-- left hand -- " + leftHandBattleAbility.toString() + "}\n";

    }
}
