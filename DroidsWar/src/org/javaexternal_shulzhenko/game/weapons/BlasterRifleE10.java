package org.javaexternal_shulzhenko.game.weapons;

public class BlasterRifleE10 extends BlasterRifleE5 {

    private int damage;
    private int ammunition;

    public BlasterRifleE10() {
        damage = 17;
        ammunition = 60;
    }

    public int getAmmunition() {
        return ammunition;
    }

    @Override
    public void reloadAmmunition() {
        ammunition = 60;
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
    public String toString() {
        return "BlasterRifleE10{" +
                "damage=" + damage +
                ", ammunition=" + ammunition +
                '}';
    }
}
