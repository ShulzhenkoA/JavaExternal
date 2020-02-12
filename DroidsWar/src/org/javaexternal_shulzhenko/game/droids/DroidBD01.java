package org.javaexternal_shulzhenko.game.droids;

import org.javaexternal_shulzhenko.game.droids.abilities.attack.RightHandBattleProperties;
import org.javaexternal_shulzhenko.game.droids.abilities.defence.SteelBattleDroidBody;
import org.javaexternal_shulzhenko.game.weapons.Weapon;

public class DroidBD01 extends Droid{


    private RightHandBattleProperties rightHandBattleProperties;


    public DroidBD01(RightHandBattleProperties rightHandBattleProperties, SteelBattleDroidBody protectiveBody) {
        this("Battle Droid", "[BD01]", 100, protectiveBody);
        this.rightHandBattleProperties = rightHandBattleProperties;

    }

    protected DroidBD01(String name, String model, int maxHealth, SteelBattleDroidBody protectiveBody) {
        super(name, model, maxHealth, protectiveBody);
    }

    @Override
    public int attack() {
        return rightHandBattleProperties.attackWithRightHandWeapon();
    }

    public void setWeaponInRightHand(Weapon weapon){
        rightHandBattleProperties.setRightHandWeapon(weapon);
    }

    public void reloadWeapon(){
        rightHandBattleProperties.reloadRightHandWeapon();
    }

    @Override
    public String toString() {

        return super.toString() +
                "\n{weapon \n\t-- right hand -- "  + rightHandBattleProperties.getRightHandWeapon().toString();
    }
}
