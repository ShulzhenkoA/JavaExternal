package org.javaexternal_shulzhenko.game.droids.abilities.defence;

import java.util.Random;

public class TitaniumDestroyerDroidBody implements ProtectiveBody {
    private final int RESISTANCE = 40;
    private final int RESISTANCE_CHANCE = 45;

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
