package org.javaexternal_shulzhenko.game.droids;

import org.javaexternal_shulzhenko.game.droids.abilities.attack.BattleAbility;
import org.javaexternal_shulzhenko.game.droids.abilities.defence.ProtectiveBody;

public class Droid implements BattleAbility {

    private String name = "Basic Droid";
    private String model = "[D01]";
    private int maxHealth = 100;
    private int health = maxHealth;
    private boolean alive;
    ProtectiveBody protectiveBody;

    public Droid(ProtectiveBody protectiveBody) {
        alive = true;
        this.protectiveBody = protectiveBody;
    }

    protected Droid(String name, String model, int maxHealth, ProtectiveBody protectiveBody) {
        this(protectiveBody);
        this.maxHealth = maxHealth;
        this.name = name;
        this.model = model;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void receiveDamage(int damage){
        health -= damage;
        if(health <=0){
            alive = false;
        }
    }

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
                "\n{health = " + health + '}';
    }
}
