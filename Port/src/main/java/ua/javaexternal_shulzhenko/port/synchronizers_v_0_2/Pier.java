package ua.javaexternal_shulzhenko.port.synchronizers_v_0_2;

import java.util.HashSet;
import java.util.Set;

public class Pier implements Runnable{

    private  Thread pierThread;
    private Port port;
    private Ship shipAtPier;
    private PortStorage portStorage = PortStorage.getPortStorage();

    public Pier(Port port, String name) {
        this.port = port;
        pierThread = new Thread(this, name);
        pierThread.start();
    }

    @Override
    public void run() {
        while (true){
            while(!isEmptyPier()){
                System.out.println(Thread.currentThread().getName() + " accept the ship " + shipAtPier.getName());
                while (!shipAtPier.isEmpty()){
                    shipAtPier.unload();
                    portStorage.load();
                }
                System.out.println("++++++++++++++++++++++++++ " + shipAtPier.getName() + " unloaded  and sailed away ++++++++++++++++++++++++++");
                System.out.println("Storage is loaded by " + portStorage.getContainers());
                setShipAtPier(null);
                Port.SEMAPHORE.release();
            }
            synchronized (this){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setShipAtPier(Ship shipAtPier) {
        this.shipAtPier = shipAtPier;
        synchronized (this){
            notify();
        }
    }

    public boolean isEmptyPier(){
        return shipAtPier == null;
    }
}
