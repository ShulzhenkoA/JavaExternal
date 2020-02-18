package org.javaexternal_shulzhenko.droidswar.droids;

import org.javaexternal_shulzhenko.droidswar.droids.abilities.attack.UseLeftHandInBattle;
import org.javaexternal_shulzhenko.droidswar.droids.abilities.attack.UseRightHandInBattle;
import org.javaexternal_shulzhenko.droidswar.droids.abilities.defence.SteelBattleDroidBody;
import org.javaexternal_shulzhenko.droidswar.weapons.*;

public class DroidBD02 extends DroidBD01 {

    protected UseLeftHandInBattle leftHandBattleAbility;

    public DroidBD02(UseRightHandInBattle rightHandBattleAbility,
                     UseLeftHandInBattle leftHandBattleAbility,
                     SteelBattleDroidBody protectiveBody) {
        this("Battle Droid", "[BD02]", 100,
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

    @Override
    public void setWeaponInRightHand(Weapon weapon) {
        rightHandBattleAbility.setRightHandWeapon(weapon);
    }

    public void setWeaponInLeftHand(Weapon weapon){
        leftHandBattleAbility.setLeftHandWeapon(weapon);
    }

    public void reloadTwoWeapons() {
        rightHandBattleAbility.reloadRightHandWeapon();
        leftHandBattleAbility.reloadLeftHandWeapon();
    }

    @Override
    public String toString() {
        return   "Name  - " + getName() +
                "\nModel - "+ getModel() +
                "\n{health = " + getHealth() + '}' +
                "\n{defence = " + protectiveBody.toString() + '}' +
                 "\n\t-- left hand -- " + rightHandBattleAbility.getRightHandWeapon().toString() +
                 "\n\t-- left hand -- " + leftHandBattleAbility.getLeftHandWeapon().toString() + "}\n";

    }
}
