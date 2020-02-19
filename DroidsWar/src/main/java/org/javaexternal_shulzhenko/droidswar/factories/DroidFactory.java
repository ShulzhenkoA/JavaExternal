package org.javaexternal_shulzhenko.droidswar.factories;

import org.javaexternal_shulzhenko.droidswar.droids.*;

public class DroidFactory {

    private static DroidFactory droidFactory = new DroidFactory();
    DroidAbilitiesFactory droidAbilitiesFactory;
    ArmorFactory armorFactory;
    WeaponFactory weaponFactory;

    private DroidFactory() {
        droidAbilitiesFactory = new DroidAbilitiesFactory();
        armorFactory = new ArmorFactory();
        weaponFactory = new WeaponFactory();
    }

    public static DroidFactory getDroidFactory(){
        return droidFactory;
    }

    public DroidB01 getBasicDroidB01() {
        return new DroidB01(armorFactory.makeBasicProtectiveBody());
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

    public DroidRD01 getRepairDroidRD01(){
        DroidRD01 factoryDroid;
        factoryDroid = new DroidRD01( droidAbilitiesFactory.makeSmallRepairAbility(),
                armorFactory.makeBasicProtectiveBody());
        return factoryDroid;
    }

    public DroidB01 createDroid(String typeOfDroid){
        switch (typeOfDroid){
            case "[B01]":
                return getBasicDroidB01();
            case "[BD01]":
                return getBattleDroidBD01();
            case "[BD02]":
                return getBattleDroidBD02();
            case "[DD01]":
                return getDroidDestroyerDD01();
            case "[RD01]":
                return getRepairDroidRD01();
            default:
                return null;
        }
    }
}
