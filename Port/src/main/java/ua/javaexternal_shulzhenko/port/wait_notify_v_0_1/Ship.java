package ua.javaexternal_shulzhenko.port.wait_notify_v_0_1;

public class Ship implements Runnable{

    private Port destinedPort;
    private String name;
    private int containersNumber;

    public Ship(Port destinedPort, String name) {
        this.name = name;
        this.destinedPort = destinedPort;
        containersNumber = 10;
        new Thread(this, name).start();
    }

    public void run(){
        destinedPort.allowShipEnterToPortPier(this);
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
