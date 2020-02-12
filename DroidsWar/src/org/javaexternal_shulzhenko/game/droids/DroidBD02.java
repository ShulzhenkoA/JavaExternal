package org.javaexternal_shulzhenko.game.droids;

import org.javaexternal_shulzhenko.game.droids.abilities.attack.TwoHandsBattleAbilities;
import org.javaexternal_shulzhenko.game.droids.abilities.defence.SteelBattleDroidBody;
import org.javaexternal_shulzhenko.game.weapons.*;

public class DroidBD02 extends DroidBD01 {

    TwoHandsBattleAbilities twoHandBattleProperties;

    public DroidBD02(TwoHandsBattleAbilities twoHandBattleProperties, SteelBattleDroidBody protectiveBody) {
        this("Battle Droid", "[BD02]", 100, protectiveBody);
        this.twoHandBattleProperties = twoHandBattleProperties;
    }

    protected DroidBD02(String name, String model, int maxHealth, SteelBattleDroidBody protectiveBody) {
        super(name, model,maxHealth, protectiveBody);
    }

    @Override
    public int attack() {
        return twoHandBattleProperties.attackWithTwoHandsWeapons();
    }

    @Override
    public void setWeaponInRightHand(Weapon weapon) {
        twoHandBattleProperties.setRightHandWeapon(weapon);
    }

    public void setWeaponInLeftHand(Weapon weapon){
        twoHandBattleProperties.setLeftHandWeapon(weapon);
    }

    public void reloadWeapons() {
        twoHandBattleProperties.reloadRightHandWeapon();
        twoHandBattleProperties.reloadLeftHandWeapon();
    }

    @Override
    public String toString() {
        return   "Name  - " + getName() +
                "\nModel - "+ getModel() +
                "\n{health = " + getHealth() + '}' +
                "\n{defence = " + protectiveBody.toString() + '}' +
                 "\n\t-- left hand -- " + twoHandBattleProperties.getRightHandWeapon().toString() +
                 "\n\t-- left hand -- " + twoHandBattleProperties.getLeftHandWeapon().toString();
    }
}
