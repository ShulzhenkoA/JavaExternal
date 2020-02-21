package org.javaexternal_shulzhenko.droidswar.droids.weapons;

import java.io.Serializable;

public interface Weapon extends Serializable {
    int shoot();
    void reloadAmmunition();
}
