package org.javaexternal_shulzhenko.game.droids;

import org.javaexternal_shulzhenko.game.droids.abilities.attack.BattleAbility;
import org.javaexternal_shulzhenko.game.weapons.*;

public class DroidBD01 extends Droid implements BattleAbility {


    private Weapon rightHandWeapon;

    public DroidBD01(Weapon weapon) {
        this(weapon, 20, "Battle Droid", "[BD01]");
    }

    protected DroidBD01(Weapon weapon, int defence, String name, String model) {
        super(defence, name, model);
        rightHandWeapon = weapon;
    }

    public int attackEnemy(){
       return rightHandWeapon.shoot();
    }

    public Weapon getRightHandWeapon() {
        return rightHandWeapon;
    }

    public void setRightHandWeapon(Weapon rightHandWeapon) {
        this.rightHandWeapon = rightHandWeapon;
    }


    @Override
    public String toString() {

        return super.toString() +
                "\n{weapon \n\t-- right hand -- "  + rightHandWeapon;
    }
}
