package org.javaexternal_shulzhenko.game.weapons;

public class BlasterRifleE5 implements Weapon {

    private int damage;
    private int ammunition;
    private int ammunitionCapacity;

    public BlasterRifleE5() {
        this(10, 50);
    }

    protected BlasterRifleE5(int damage, int ammunition) {
        this.damage = damage;
        this.ammunition = ammunition;
        ammunitionCapacity = ammunition;
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
        ammunition = ammunitionCapacity;
    }


    @Override
    public String toString() {
        return getClass().getSimpleName() + " (" +
                "damage=" + damage +
                ", ammunition=" + ammunition +
                ')';
    }
}
