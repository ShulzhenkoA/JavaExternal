package org.javaexternal_shulzhenko.game.factories;

import org.javaexternal_shulzhenko.game.droids.abilities.defence.BasicDroidBody;
import org.javaexternal_shulzhenko.game.droids.abilities.defence.ProtectiveBody;
import org.javaexternal_shulzhenko.game.droids.abilities.defence.SteelBattleDroidBody;
import org.javaexternal_shulzhenko.game.droids.abilities.defence.TitaniumDestroyerDroidBody;

public class ArmorFactory {

    ProtectiveBody makeBasicProtectiveBody(){
        return new BasicDroidBody();
    }

    SteelBattleDroidBody makeSteelBDB(){
        return new SteelBattleDroidBody();
    }

    TitaniumDestroyerDroidBody makeTitaniumDDB(){
        return new TitaniumDestroyerDroidBody();
    }
}
