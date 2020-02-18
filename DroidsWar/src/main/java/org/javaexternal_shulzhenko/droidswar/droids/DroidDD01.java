package org.javaexternal_shulzhenko.droidswar.droids;

import org.javaexternal_shulzhenko.droidswar.droids.abilities.attack.UseLeftHandInBattle;
import org.javaexternal_shulzhenko.droidswar.droids.abilities.attack.UseRightHandInBattle;
import org.javaexternal_shulzhenko.droidswar.droids.abilities.defence.TitaniumDestroyerDroidBody;
import org.javaexternal_shulzhenko.droidswar.weapons.Weapon;


public class DroidDD01 extends Droid{

    protected UseRightHandInBattle rightHandBattleAbility;
    protected UseLeftHandInBattle leftHandBattleAbility;

    public DroidDD01(UseRightHandInBattle rightHandBattleAbility, UseLeftHandInBattle leftHandBattleAbility,
                     TitaniumDestroyerDroidBody protectiveBody) {
        this("Droid Destroyer", "[DD01]",135,
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

    @Override
    public void attack(Droid droid) {
        if((rightHandBattleAbility.attackWithRightHand() > 2 && leftHandBattleAbility.attackWithLeftHand() >2) ||
                (rightHandBattleAbility.attackWithRightHand() == 2 && leftHandBattleAbility.attackWithLeftHand() == 2)){
            droid.receiveDamage(rightHandBattleAbility.attackWithRightHand() +
                    leftHandBattleAbility.attackWithLeftHand());
        }else if(rightHandBattleAbility.attackWithRightHand() > 2 &&
                leftHandBattleAbility.attackWithLeftHand() == 2){
            droid.receiveDamage(rightHandBattleAbility.attackWithRightHand());
        }else{
            droid.receiveDamage(leftHandBattleAbility.attackWithLeftHand());
        }
    }

    public void setWeaponInRightHand(Weapon weapon){
        rightHandBattleAbility.setRightHandWeapon(weapon);
    }

    public void setWeaponInLeftHand(Weapon weapon){
        leftHandBattleAbility.setLeftHandWeapon(weapon);
    }

    public void reloadTwoWeapons(){
        rightHandBattleAbility.reloadRightHandWeapon();
        leftHandBattleAbility.reloadLeftHandWeapon();
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n{weapon \n\t-- right hand -- "  + rightHandBattleAbility.getRightHandWeapon().toString() +
                "\n\t-- left hand -- " + leftHandBattleAbility.getLeftHandWeapon().toString() + "}\n";
    }
}
