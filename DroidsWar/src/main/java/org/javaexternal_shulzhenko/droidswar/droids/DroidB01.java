package org.javaexternal_shulzhenko.droidswar.droids;

import org.javaexternal_shulzhenko.droidswar.droids.abilities.attack.DamageAble;
import org.javaexternal_shulzhenko.droidswar.droids.abilities.defence.ProtectiveBody;

public class DroidB01 implements DamageAble {

    private String name;
    private String model;
    private int maxHealth;
    private int health;
    private int energy;
    private boolean alive;
    protected Engine engine;
    ProtectiveBody protectiveBody;

    public DroidB01(ProtectiveBody protectiveBody) {
        this();
        this.protectiveBody = protectiveBody;
    }

    public DroidB01(){
        name = "Basic DroidB01";
        model = "[B01]";
        maxHealth = 100;
        health = maxHealth;
        energy = 30;
        engine = new Engine();
        alive = true;
    }

    protected DroidB01(String name, String model, int maxHealth, ProtectiveBody protectiveBody) {
        this(protectiveBody);
        this.maxHealth = maxHealth;
        health = maxHealth;
        this.name = name;
        this.model = model;
    }

    public class Engine{
         protected boolean droidWorkingFromEnergyConsumption(){
            if(energy!=0){
                energy--;
                return true;
            }else {
                return false;
            }
        }
    }

    @Override
    public void attack(DroidB01 droid) {
        if(engine.droidWorkingFromEnergyConsumption()){
            droid.receiveDamage(2);
        }
    }
    public void receiveDamage(int damage){

        if(protectiveBody != null){
            damage = damage - protectiveBody.defendFromAttack();
        }

        if(damage>0){
            health -= damage;
        }
        checkAlive();
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

    public void checkAlive(){
        if(health <=0){
            alive = false;
        }
    }

    @Override
    public String toString() {
        if(protectiveBody == null){
            return "Name  - " + name +
                    "\nModel - "+ model +
                    "\n{HP = " + health + '}' +
                    "\n{Energy = " + energy + '}' +
                    "\n{Defence = hasn't protective body}";
        }else{
            return "Name  - " + name +
                    "\nModel - "+ model +
                    "\n{HP = " + health + '}' +
                    "\n{Energy = " + energy + '}' +
                    "\n{Defence = " + protectiveBody.toString() + '}';
        }
    }
}
