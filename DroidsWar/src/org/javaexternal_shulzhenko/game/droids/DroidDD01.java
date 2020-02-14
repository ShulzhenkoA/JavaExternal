package org.javaexternal_shulzhenko.game.droids;

import org.javaexternal_shulzhenko.game.droids.abilities.attack.UseLeftHandInBattle;
import org.javaexternal_shulzhenko.game.droids.abilities.attack.UseRightHandInBattle;
import org.javaexternal_shulzhenko.game.droids.abilities.defence.TitaniumDestroyerDroidBody;
import org.javaexternal_shulzhenko.game.weapons.Weapon;


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

    public DroidDD01(String name, String model, int maxHealth,
                     UseRightHandInBattle rightHandBattleAbility,
                     UseLeftHandInBattle leftHandBattleAbility,
                     TitaniumDestroyerDroidBody protectiveBody) {
        super(name, model, maxHealth, protectiveBody);
        this.rightHandBattleAbility = rightHandBattleAbility;
        this.leftHandBattleAbility = leftHandBattleAbility;
    }

    @Override
    public void attack(Droid droid) {
        droid.receiveDamage(rightHandBattleAbility.attackWithRightHandWeapon() +
                leftHandBattleAbility.attackWithLeftHandWeapon());
    }

    public void setWeaponInRightHand(Weapon weapon){
        rightHandBattleAbility.setRightHandWeapon(weapon);
    }

    public void setWeaponInLeftHand(Weapon weapon){
        leftHandBattleAbility.setLeftHandWeapon(weapon);
    }

    public void reloadWeapons(){
        rightHandBattleAbility.reloadRightHandWeapon();
        leftHandBattleAbility.getLeftHandWeapon();
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n{weapon \n\t-- right hand -- "  + rightHandBattleAbility.getRightHandWeapon().toString() +
                "\n\t-- left hand -- " + leftHandBattleAbility.getLeftHandWeapon().toString();
    }
}
