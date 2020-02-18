package org.javaexternal_shulzhenko.droidswar.droids;

import org.javaexternal_shulzhenko.droidswar.droids.abilities.attack.BattleAbility;
import org.javaexternal_shulzhenko.droidswar.droids.abilities.defence.BasicDroidBody;
import org.javaexternal_shulzhenko.droidswar.droids.abilities.defence.ProtectiveBody;

public class Droid implements BattleAbility {

    private String name;
    private String model;
    private int maxHealth;
    private int health;
    private boolean alive;
    ProtectiveBody protectiveBody;

    public Droid(ProtectiveBody protectiveBody) {
        this();
        this.protectiveBody = protectiveBody;
    }

    protected Droid(){
        name = "Basic Droid";
        model = "[D01]";
        maxHealth = 100;
        health = maxHealth;
        alive = true;
        protectiveBody = new BasicDroidBody();
    }

    protected Droid(String name, String model, int maxHealth, ProtectiveBody protectiveBody) {
        this(protectiveBody);
        this.maxHealth = maxHealth;
        health = maxHealth;
        this.name = name;
        this.model = model;
    }

    public void attack(Droid droid){
        droid.receiveDamage(attackWithHands());
    }

    public void receiveDamage(int damage){
        int amountNotProtectedDamage = damage - performDefence(); //without protection from ProtectiveBody

        if(amountNotProtectedDamage>0){
            health -= damage;
        }
        if(health <=0){
            alive = false;
        }
    }

    public int performDefence(){
        return protectiveBody.defendFromAttack();
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
                "\n{health = " + health + '}' +
                "\n{defence = " + protectiveBody.toString() + '}';
    }
}
