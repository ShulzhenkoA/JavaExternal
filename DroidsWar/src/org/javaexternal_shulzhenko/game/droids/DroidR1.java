package org.javaexternal_shulzhenko.game.droids;

public class DroidR1 extends Droid implements RepairDroid {

    private final int REPAIR_UNIT = 50;

    public DroidR1() {
        this(0, "Repair Droid", "R1");
    }

    protected DroidR1(int defense, String name, String model) {
        super(defense, name, model);
    }

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
    public int getREPAIR_UNIT() {
        return REPAIR_UNIT;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n{REPAIR_UNIT = " + REPAIR_UNIT + '}';
    }
}
