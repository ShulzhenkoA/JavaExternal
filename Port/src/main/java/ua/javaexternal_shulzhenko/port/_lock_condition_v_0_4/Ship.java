package ua.javaexternal_shulzhenko.port._lock_condition_v_0_4;

public class Ship implements Runnable{

    private Port destinedPort;
    private String name;
    private int containersNumber;

    public Ship(Port destinedPort, String name) {
        this.name = name;
        this.destinedPort = destinedPort;
        containersNumber = 1000000;
    }

    public void run(){
        try {
            destinedPort.allowShipEnterToPortPier(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public void unload() {
        containersNumber--;
    }

    public boolean isEmpty(){
        return containersNumber == 0;
    }
}
