package org.javaexternal_shulzhenko.game.droids.abilities.defence;

import java.util.Random;

public class BasicDroidBody implements ProtectiveBody {


    private final int RESISTANCE = 5;
    private final int RESISTANCE_CHANCE = 35;

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
