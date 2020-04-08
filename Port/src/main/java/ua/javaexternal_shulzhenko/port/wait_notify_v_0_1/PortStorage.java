package ua.javaexternal_shulzhenko.port.wait_notify_v_0_1;

public class PortStorage {

    private static PortStorage portStorage = new PortStorage();
    private int containers = 0;

    private PortStorage() {
    }

    public static PortStorage getPortStorage(){
        return portStorage;
    }

    public synchronized void load() {
        containers++;
    }
    public int getContainers() {
        return containers;
    }
}
