package org.javaexternal_shulzhenko.game.droids;

import org.javaexternal_shulzhenko.game.droids.abilities.attack.TwoHandBattleProperties;
import org.javaexternal_shulzhenko.game.droids.abilities.defence.TitaniumDestroyerDroidBody;
import org.javaexternal_shulzhenko.game.weapons.Weapon;


public class DroidDD01 extends Droid{

    TwoHandBattleProperties twoHandBattleProperties;

    public DroidDD01(TwoHandBattleProperties twoHandBattleProperties, TitaniumDestroyerDroidBody protectiveBody) {
        this("Droid Destroyer", "[DD01]",135, protectiveBody);
        this.twoHandBattleProperties = twoHandBattleProperties;
    }

    public DroidDD01(String name, String model, int maxHealth, TitaniumDestroyerDroidBody protectiveBody) {
        super(name, model, maxHealth, protectiveBody);
    }

    @Override
    public int attack() {
        return twoHandBattleProperties.attackWithTwoHandsWeapons();
    }

    public void setWeaponInTheRightHand(Weapon weapon){
        twoHandBattleProperties.setRightHandWeapon(weapon);
    }

    public void setWeaponInTheLeftHand(Weapon weapon){
        twoHandBattleProperties.setLeftHandWeapon(weapon);
    }

    public void reloadWeapons(){
        twoHandBattleProperties.reloadRightHandWeapon();
        twoHandBattleProperties.getLeftHandWeapon();
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n{weapon \n\t-- right hand -- "  + twoHandBattleProperties.getRightHandWeapon().toString() +
                "\n\t-- left hand -- " + twoHandBattleProperties.getLeftHandWeapon().toString();
    }
}
