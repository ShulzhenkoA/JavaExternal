package org.javaexternal_shulzhenko.game.droids;

public class Droid {

    private int health;
    private int MAX_HEALTH = 100;
    private final String NAME = "Basic Droid";
    private final String MODEL = "[D01]";
    private boolean alive;

    public Droid() {
        health = 100;
        alive = true;

    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMAX_HEALTH() {
        return MAX_HEALTH;
    }

    public int attack(){ return 2;}

    public void receiveDamage(int damage){
        health -= damage;
        if(health <=0){
            alive = false;
        }
    }

    public int getDefence(){ return -1;}

    public String getNAME() {
        return NAME;
    }

    public String getMODEL() {
        return MODEL;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    @Override
    public String toString() {
        return "Name  - " + NAME +
                "\nModel - "+ MODEL +
                "\n{health=" + health + '}';
    }
}
