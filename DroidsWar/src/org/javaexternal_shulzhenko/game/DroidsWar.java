package org.javaexternal_shulzhenko.game;


import org.javaexternal_shulzhenko.game.battle.BattleFieldController;

import org.javaexternal_shulzhenko.game.console.ConsoleView;
import org.javaexternal_shulzhenko.game.droids.*;
import org.javaexternal_shulzhenko.game.factories.DroidFactory;


// Class with main method
public class DroidsWar {
    public static void main(String[] args){

        //Create DroidFactory
        DroidFactory factory = new DroidFactory();


        //Create Basic Droid[D01] with no weapons (can do damage by hands), 100hp and low defense.
        // Print its info to console.
        Droid basicDroid = factory.getBasicDroidD01();
        ConsoleView.printDroidInfo(basicDroid);


        //Create two Battle Droid[BD01] with single weapon "BlasterRifleE5", 100hp and middle defence.
        //Print info to console.
        DroidBD01 firstBattleDroidV01 = factory.getBattleDroidBD01();
        ConsoleView.printDroidInfo(firstBattleDroidV01);
        DroidBD01 secondBattleDroidV01 = factory.getBattleDroidBD01();
        ConsoleView.printDroidInfo(secondBattleDroidV01);


        //Create Battle Droid[BD02] with two weapons "BlasterRifleE5", 100hp and middle defence.
        //Print its info to console.
        DroidBD02 battleDroidV02= factory.getBattleDroidBD02();
        ConsoleView.printDroidInfo(battleDroidV02);

        //Create Droid Destroyer[DD] with two weapons "BlasterRifleE10", 135hp and high defence.
        //Print its info to console
        DroidDD01 destroyer = factory.getDroidDestroyerDD01();
        ConsoleView.printDroidInfo(destroyer);

        //Create Repair Droid[01] with 50 repair units, 100hp and low defence. Print its info to console
        DroidR1 repairDroid = factory.getRepairDroidR1();
        ConsoleView.printDroidInfo(repairDroid);


        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>//
        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>//
        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>//

        System.out.println(
                "//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>//\n"+
                "//Modeling battle among two same droids Battle Droid[BD01](firstBattleDroidV01 and secondBattleDroidV01)//\n" +
                "//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<//\n");


        //Modeling battle among two same droids (firstBattleDroidV01 and secondBattleDroidV01)
        //The result of the battle is unknown because the strength of both droids is equal.
        //Print the result of the battle to console.
        //Repair(if not alive - set to alive and add 50hp) firstBattleDroidV01 with Repair Droid[R1] for the next fight.
        //Reload firstBattleDroidV01 weapon for the next fight.

        BattleFieldController.fightToTheEnd(firstBattleDroidV01, secondBattleDroidV01);

        repairDroid.doRepair(firstBattleDroidV01);
        repairDroid.doRepair(firstBattleDroidV01);

        firstBattleDroidV01.reloadWeapon();

        System.out.println(
                "//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>//\n"+
                "//Modeling battle among Battle Droid[BD01] and Battle Droid[BD02] (firstBattleDroidV01 and battleDroidV02)//\n" +
                "//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<//\n");

        //Modeling battle among Battle Droid[BD01] and Battle Droid[BD02] (firstBattleDroidV01 and battleDroidV02)
        //Battle Droid[BD02] has two weapons and it must win.
        //Print the result of the battle to console
        //Repair them for the next fight

        BattleFieldController.fightToTheEnd(firstBattleDroidV01,battleDroidV02);
        repairDroid.doRepair(firstBattleDroidV01);
        repairDroid.doRepair(firstBattleDroidV01);

        repairDroid.doRepair(battleDroidV02);
        repairDroid.doRepair(battleDroidV02);
        
        firstBattleDroidV01.reloadWeapon();
        battleDroidV02.reloadWeapon();
        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>//
        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>//
        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>//

        System.out.println(
                "//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>//\n"+
                "/Modeling fights among Battle Droid[BD01], Battle Droid[BD02] against the strongest droid Droid Destroyer[DD01]//\n" +
                "//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<//\n");

        // Modeling battle among Battle Droid[BD01], Battle Droid[BD02] against the strongest droid Droid Destroyer[DD01]
        //Print info about all droid before fight
        //Droid Destroyer[DD01] must win.
        //Print the result of the battle to console

        ConsoleView.printDroidInfo(firstBattleDroidV01);
        ConsoleView.printDroidInfo(battleDroidV02);
        ConsoleView.printDroidInfo(destroyer);

        BattleFieldController.fightToTheEnd(destroyer, firstBattleDroidV01);
        BattleFieldController.fightToTheEnd(destroyer, battleDroidV02);
    }
}
