package org.javaexternal_shulzhenko.game.droids;

import org.javaexternal_shulzhenko.game.droids.abilities.attack.TwoHandBattleProperties;
import org.javaexternal_shulzhenko.game.droids.abilities.defence.SteelBattleDroidBody;
import org.javaexternal_shulzhenko.game.weapons.*;

public class DroidBD02 extends DroidBD01 {

    TwoHandBattleProperties twoHandBattleProperties;

    public DroidBD02(TwoHandBattleProperties twoHandBattleProperties, SteelBattleDroidBody protectiveBody) {
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

    public void setWeaponInLeftHand(Weapon weapon){
        twoHandBattleProperties.setLeftHandWeapon(weapon);
    }

    public void reloadWeapons() {
        twoHandBattleProperties.reloadRightHandWeapon();
        twoHandBattleProperties.reloadLeftHandWeapon();
    }

    @Override
    public String toString() {
        return super.toString() +
                 "\n\t-- left hand -- " + twoHandBattleProperties.getLeftHandWeapon().toString();
    }
}
