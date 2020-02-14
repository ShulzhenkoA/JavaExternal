package org.javaexternal_shulzhenko.game.droids;

import org.javaexternal_shulzhenko.game.droids.abilities.attack.UseLeftHandInBattle;
import org.javaexternal_shulzhenko.game.droids.abilities.attack.UseRightHandInBattle;
import org.javaexternal_shulzhenko.game.droids.abilities.defence.SteelBattleDroidBody;
import org.javaexternal_shulzhenko.game.weapons.*;

public class DroidBD02 extends DroidBD01 {

    UseLeftHandInBattle leftHandBattleAbility;

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
        droid.receiveDamage(rightHandBattleAbility.attackWithRightHandWeapon() +
                leftHandBattleAbility.attackWithLeftHandWeapon());
    }

    @Override
    public void setWeaponInRightHand(Weapon weapon) {
        rightHandBattleAbility.setRightHandWeapon(weapon);
    }

    public void setWeaponInLeftHand(Weapon weapon){
        leftHandBattleAbility.setLeftHandWeapon(weapon);
    }

    public void reloadWeapons() {
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
                 "\n\t-- left hand -- " + leftHandBattleAbility.getLeftHandWeapon().toString();
    }
}
