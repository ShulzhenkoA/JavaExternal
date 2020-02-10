package org.javaexternal_shulzhenko.game;


import org.javaexternal_shulzhenko.game.battle.BattleField;
import org.javaexternal_shulzhenko.game.console.ConsoleView;
import org.javaexternal_shulzhenko.game.droids.*;
import org.javaexternal_shulzhenko.game.weapons.BlasterRifleE10;
import org.javaexternal_shulzhenko.game.weapons.BlasterRifleE5;


// Class with main method
public class DroidsWar {
    public static void main(String[] args){

        // Creating 10 blasters "BlasterRifleE5" for droids
        BlasterRifleE5[] blE5 = new BlasterRifleE5[10];
        for(int i = 0; i< blE5.length; i++){
            blE5[i] = new BlasterRifleE5();
        }

        // Creating 2 blasters "BlasterRifleE10" for Droid Destroyer
        BlasterRifleE10 blE10_1= new BlasterRifleE10();
        BlasterRifleE10 blE10_2 = new BlasterRifleE10();

        //Create Basic Droid[D01] with no weapons (can do damage by hands) and no defense.
        // Print its info to console.
        Droid basicDroid = new Droid();
        ConsoleView.printDroidInfo(basicDroid);

        //Create two Battle Droid[BD01] with single weapon "BlasterRifleE5" and 20 points of defence.
        //Print info to console.
        DroidBD01 firstBattleDroidV01 = new DroidBD01(blE5[0]);
        ConsoleView.printDroidInfo(firstBattleDroidV01);
        DroidBD01 secondBattleDroidV01 = new DroidBD01(blE5[1]);
        ConsoleView.printDroidInfo(secondBattleDroidV01);

        //Create Battle Droid[BD02] with two weapons "BlasterRifleE5" and 20 points of defence.
        //Print its info to console.
        DroidBD02 battleDroidV02= new DroidBD02(blE5[2],blE5[3]);
        ConsoleView.printDroidInfo(battleDroidV02);

        //Create Droid Destroyer[DD] with two weapons "BlasterRifleE10" and 20 points of defence.
        //Print its info to console
        DroidDD01 destroyer = new DroidDD01(blE10_1, blE10_2);
        ConsoleView.printDroidInfo(destroyer);

        //Create Repair Droid[01]. Print its info to console
        DroidR1 repairDroid = new DroidR1();
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

        BattleField.fightToTheEnd(firstBattleDroidV01, secondBattleDroidV01);

        repairDroid.repair(firstBattleDroidV01);
        repairDroid.repair(firstBattleDroidV01);

        blE5[0].reloadAmmunition();

        System.out.println(
                "//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>//\n"+
                "//Modeling battle among Battle Droid[BD01] and Battle Droid[BD02] (firstBattleDroidV01 and battleDroidV02)//\n" +
                "//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<//\n");

        //Modeling battle among Battle Droid[BD01] and Battle Droid[BD02] (firstBattleDroidV01 and battleDroidV02)
        //Battle Droid[BD02] has two weapons and it must win.
        //Print the result of the battle to console
        //Repair them for the next fight
        //Reload their weapon for the next fight.

        BattleField.fightToTheEnd(firstBattleDroidV01,battleDroidV02);
        repairDroid.repair(firstBattleDroidV01);
        repairDroid.repair(firstBattleDroidV01);

        repairDroid.repair(battleDroidV02);
        repairDroid.repair(battleDroidV02);

        blE5[0].reloadAmmunition();
        blE5[2].reloadAmmunition();
        blE5[3].reloadAmmunition();

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

        BattleField.fightToTheEnd(destroyer, firstBattleDroidV01);
        BattleField.fightToTheEnd(destroyer, battleDroidV02);

    }
}
