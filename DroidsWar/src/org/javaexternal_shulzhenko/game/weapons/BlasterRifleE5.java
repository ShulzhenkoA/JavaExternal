package org.javaexternal_shulzhenko.game.weapons;

public class BlasterRifleE5 implements Blaster {

    private int damage;
    private int ammunition;

    public BlasterRifleE5() {
        damage = 10;
        ammunition = 50;
    }

    @Override
    public int shoot() {
        if(ammunition == 0){
            return -1;
        }else{
            ammunition--;
            return damage;
        }
    }

    @Override
    public void reloadAmmunition() {
        ammunition = 100;
    }

    @Override
    public String toString() {
        return "BlasterRifleE5 (" +
                "damage=" + damage +
                ", ammunition=" + ammunition +
                ')';
    }
}
