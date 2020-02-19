package org.javaexternal_shulzhenko.droidswar.droids.abilities.attack;

import org.javaexternal_shulzhenko.droidswar.weapons.Weapon;

public class RightHandBattleAbility implements UseRightHandInBattle {

    protected Weapon rightHandWeapon;


    @Override
    public int attackWithRightHand() {
        if(rightHandWeapon != null){
            return rightHandWeapon.shoot();
        }else{
            return attackWithHands();
        }
    }

    @Override
    public Weapon getRightHandWeapon() {
        return rightHandWeapon;
    }

    @Override
    public void setRightHandWeapon(Weapon weapon) {
        rightHandWeapon = weapon;
    }

    @Override
    public void reloadRightHandWeapon() {
        if(rightHandWeapon != null){
            rightHandWeapon.reloadAmmunition();
        }
    }

    @Override
    public String toString() {
        return rightHandWeapon + "";
    }
}
