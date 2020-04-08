package ua.javaexternal_shulzhenko.port.synchronizers_v_0_2;

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
