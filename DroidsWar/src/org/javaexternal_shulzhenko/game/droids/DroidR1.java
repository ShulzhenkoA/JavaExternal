package org.javaexternal_shulzhenko.game.droids;

public class DroidR1 extends Droid implements RepairDroid {

    private final String NAME = "Repair Droid";
    private final String MODEL = "[R1]";

    private final int REPAIR_UNIT = 50;

    @Override
    public void repair(Droid droid) {
        int points = droid.getHealth() + 50;
        if(points <= droid.getMAX_HEALTH()){
            droid.setHealth(points);
            droid.setAlive(true);
        }else {
            droid.setHealth(droid.getMAX_HEALTH());
            setAlive(true);
        }
    }

    @Override
    public String getNAME() {
        return NAME;
    }

    @Override
    public String getMODEL() {
        return MODEL;
    }

    public int getREPAIR_UNIT() {
        return REPAIR_UNIT;
    }

    @Override
    public String toString() {
        return "Name  - " + NAME +
                "\nModel - "+ MODEL +
                "\n{health = " + getHealth() + '}' +
                "\n{REPAIR_UNIT = " + REPAIR_UNIT + '}';
    }
}
