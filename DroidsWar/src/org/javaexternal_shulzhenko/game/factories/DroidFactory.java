package org.javaexternal_shulzhenko.game.factories;

import org.javaexternal_shulzhenko.game.droids.*;

public class DroidFactory {

    DroidAbilitiesFactory droidAbilitiesFactory;
    ArmorFactory armorFactory;
    WeaponFactory weaponFactory;

    public DroidFactory() {
        droidAbilitiesFactory = new DroidAbilitiesFactory();
        armorFactory = new ArmorFactory();
        weaponFactory = new WeaponFactory();
    }

    public Droid getBasicDroidD01() {
        return new Droid(armorFactory.makeBasicProtectiveBody());
    }

    public DroidBD01 getBattleDroidBD01(){
        DroidBD01 factoryDroid;
        factoryDroid = new DroidBD01(droidAbilitiesFactory.makeRightHandBattleAbility(),
                armorFactory.makeSteelBDB());
        factoryDroid.setWeaponInRightHand(weaponFactory.makeWeapon("E5"));
        return factoryDroid;
    }

    public DroidBD02 getBattleDroidBD02(){
        DroidBD02 factoryDroid;
        factoryDroid = new DroidBD02(droidAbilitiesFactory.makeRightHandBattleAbility(),
                droidAbilitiesFactory.makeLeftHandBattleAbility(),
                armorFactory.makeSteelBDB());
        factoryDroid.setWeaponInLeftHand((weaponFactory.makeWeapon("E5")));
        factoryDroid.setWeaponInRightHand(weaponFactory.makeWeapon("E5"));

        return factoryDroid;
    }

    public DroidDD01 getDroidDestroyerDD01(){
        DroidDD01 factoryDroid;
        factoryDroid = new DroidDD01(droidAbilitiesFactory.makeRightHandBattleAbility(),
                droidAbilitiesFactory.makeLeftHandBattleAbility(),
                armorFactory.makeTitaniumDDB());
        factoryDroid.setWeaponInRightHand(weaponFactory.makeWeapon("E10"));
        factoryDroid.setWeaponInLeftHand(weaponFactory.makeWeapon("E10"));
        return factoryDroid;
    }

    public DroidR1 getRepairDroidR1(){
        DroidR1 factoryDroid;
        factoryDroid = new DroidR1( droidAbilitiesFactory.makeSmallRepairAbility(),
                armorFactory.makeBasicProtectiveBody());
        return factoryDroid;
    }
}
