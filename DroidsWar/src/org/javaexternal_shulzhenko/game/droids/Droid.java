package org.javaexternal_shulzhenko.game.droids;

public class Droid {

    private int health;
    private int MAX_HEALTH = 100;
    private int defense;
    private String name = "Basic Droid";
    private String model = "[D01]";
    private boolean alive;

    public Droid() {
        health = 100;
        alive = true;
    }

    protected Droid(int defense, String name, String model) {
        this();
        this.defense = defense;
        this.name = name;
        this.model = model;
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

    public int getDefence(){ return defense;}

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    @Override
    public String toString() {
        return "Name  - " + name +
                "\nModel - "+ model +
                "\n{health = " + health + '}'+
                "\n{defence -- " + getDefence() +" }";
    }
}
