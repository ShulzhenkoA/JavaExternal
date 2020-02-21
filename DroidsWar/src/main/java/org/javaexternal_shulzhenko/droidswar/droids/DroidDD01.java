package org.javaexternal_shulzhenko.droidswar.droids;

import org.javaexternal_shulzhenko.droidswar.droids.abilities.attack.BattleAble;
import org.javaexternal_shulzhenko.droidswar.droids.abilities.attack.UseLeftHandInBattle;
import org.javaexternal_shulzhenko.droidswar.droids.abilities.attack.UseRightHandInBattle;
import org.javaexternal_shulzhenko.droidswar.droids.abilities.defence.TitaniumDestroyerDroidBody;
import org.javaexternal_shulzhenko.droidswar.droids.weapons.Weapon;


public class DroidDD01 extends DroidB01 implements BattleAble {

    protected UseRightHandInBattle rightHandBattleAbility;
    protected UseLeftHandInBattle leftHandBattleAbility;

    public DroidDD01(UseRightHandInBattle rightHandBattleAbility, UseLeftHandInBattle leftHandBattleAbility,
                     TitaniumDestroyerDroidBody protectiveBody) {
        this("Destroyer DroidDD01", "[DD01]",135,
                rightHandBattleAbility,
                leftHandBattleAbility,
                protectiveBody);

    }

    protected DroidDD01(String name, String model, int maxHealth,
                     UseRightHandInBattle rightHandBattleAbility,
                     UseLeftHandInBattle leftHandBattleAbility,
                     TitaniumDestroyerDroidBody protectiveBody) {
        super(name, model, maxHealth, protectiveBody);
        this.rightHandBattleAbility = rightHandBattleAbility;
        this.leftHandBattleAbility = leftHandBattleAbility;
    }

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

    public void setWeaponInRightHand(Weapon weapon){
        if(engine.droidWorkingFromEnergyConsumption()){
            rightHandBattleAbility.setRightHandWeapon(weapon);
        }
    }

    public void setWeaponInLeftHand(Weapon weapon){
        if(engine.droidWorkingFromEnergyConsumption()){
            leftHandBattleAbility.setLeftHandWeapon(weapon);
        }
    }

    public void reloadTwoWeapons(){
        if(engine.droidWorkingFromEnergyConsumption()){
            rightHandBattleAbility.reloadRightHandWeapon();
            leftHandBattleAbility.reloadLeftHandWeapon();
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n{weapon \n\t-- right hand -- "  + rightHandBattleAbility.toString() +
                "\n\t-- left hand -- " + leftHandBattleAbility.toString() + "}\n";
    }
}
