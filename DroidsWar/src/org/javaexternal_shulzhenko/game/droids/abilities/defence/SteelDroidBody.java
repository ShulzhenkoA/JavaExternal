package org.javaexternal_shulzhenko.game.droids.abilities.defence;

import java.util.Random;

public class SteelDroidBody implements ProtectiveBody {

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
}
