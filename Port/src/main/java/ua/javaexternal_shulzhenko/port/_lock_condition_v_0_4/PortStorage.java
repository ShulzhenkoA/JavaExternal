package ua.javaexternal_shulzhenko.port._lock_condition_v_0_4;

import java.util.concurrent.atomic.AtomicInteger;

public class PortStorage {

    private static PortStorage portStorage = new PortStorage();
    private AtomicInteger containers;

    private PortStorage() {
        containers = new AtomicInteger(0);
    }

    public static PortStorage getPortStorage(){
        return portStorage;
    }

    public void load() {
        containers.addAndGet(1);
    }

    public int getContainers() {
        return containers.get();
    }
}
