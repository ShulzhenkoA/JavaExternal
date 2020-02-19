package org.javaexternal_shulzhenko.droidswar.droids.abilities.attack;

import org.javaexternal_shulzhenko.droidswar.weapons.Weapon;

public class LeftHandBattleAbility implements UseLeftHandInBattle {

    protected Weapon leftHandWeapon;

    @Override
    public int attackWithLeftHand() {
        if(leftHandWeapon != null){
            return leftHandWeapon.shoot();
        }else{
            return attackWithHands();
        }
    }

    @Override
    public Weapon getLeftHandWeapon() {
        return leftHandWeapon;
    }

    @Override
    public void setLeftHandWeapon(Weapon weapon) {
        this.leftHandWeapon = weapon;
    }

    @Override
    public void reloadLeftHandWeapon() {
        if(leftHandWeapon!=null){
            leftHandWeapon.reloadAmmunition();
        }
    }

    @Override
    public String toString() {
        return leftHandWeapon + "";
    }
}
