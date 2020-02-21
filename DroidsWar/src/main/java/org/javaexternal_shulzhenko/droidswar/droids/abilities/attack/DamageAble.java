package org.javaexternal_shulzhenko.droidswar.droids.abilities.attack;

import org.javaexternal_shulzhenko.droidswar.droids.DroidB01;

import java.io.Serializable;

public interface DamageAble extends Serializable {

    int BASIC_DAMAGE = 2;

    default void attack(DroidB01 droid){
       droid.receiveDamage(BASIC_DAMAGE);
   }
}
