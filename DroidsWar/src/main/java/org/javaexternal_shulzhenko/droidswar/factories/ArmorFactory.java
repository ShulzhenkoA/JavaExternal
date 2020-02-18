package org.javaexternal_shulzhenko.droidswar.factories;

import org.javaexternal_shulzhenko.droidswar.droids.abilities.defence.BasicDroidBody;
import org.javaexternal_shulzhenko.droidswar.droids.abilities.defence.ProtectiveBody;
import org.javaexternal_shulzhenko.droidswar.droids.abilities.defence.SteelBattleDroidBody;
import org.javaexternal_shulzhenko.droidswar.droids.abilities.defence.TitaniumDestroyerDroidBody;

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
