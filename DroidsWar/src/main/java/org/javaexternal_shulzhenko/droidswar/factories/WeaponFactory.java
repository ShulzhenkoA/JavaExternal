package org.javaexternal_shulzhenko.droidswar.factories;

import org.javaexternal_shulzhenko.droidswar.droids.weapons.BlasterRifleE10;
import org.javaexternal_shulzhenko.droidswar.droids.weapons.BlasterRifleE5;
import org.javaexternal_shulzhenko.droidswar.droids.weapons.Weapon;

public class WeaponFactory {

    public Weapon makeWeapon(String weaponModel){
        if(weaponModel.equalsIgnoreCase("E5")){
            return new BlasterRifleE5();
        }else if(weaponModel.equalsIgnoreCase("E10")){
            return new BlasterRifleE10();
        }
        return null;
    }
}
