package ua.javaexternal_shulzhenko.port.synchronization;

import java.util.Random;

public class Ship implements Runnable{

    private Port destinedPort;
    private String name;
    private int containersNumber;

    public Ship() {
        containersNumber = 10;
    }

    public Ship(Port destinedPort, String name) {
        this.name = name;
        this.destinedPort = destinedPort;
        new Thread(this, name).start();
        containersNumber = new Random().nextInt(100);
    }

    public void run(){
        destinedPort.allowEntranceToPort(this);
    }

    public String getName() {
        return name;
    }

    public int getContainersNumber() {
        return containersNumber;
    }

    public void pickupContainer() {
        containersNumber--;
    }
}
