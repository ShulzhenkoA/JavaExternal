package org.javaexternal_shulzhenko.droidswar.droids.abilities.defence;

import java.util.Random;

public class SteelBattleDroidBody implements ProtectiveBody {

    private final int RESISTANCE = 30;
    private final int RESISTANCE_CHANCE = 40;

    @Override
    public int defendFromAttack() {
        Random random = new Random();
        if(RESISTANCE_CHANCE > random.nextInt(99)){
            return RESISTANCE;
        }else{
            return 0;
        }
    }

    @Override
    public String toString() {
        return RESISTANCE + "/" + RESISTANCE_CHANCE;
    }
}
