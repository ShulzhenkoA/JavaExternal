package ua.javaexternal_shulzhenko.port._lock_condition_v_0_4;

public class Pier implements Runnable{

    private Port port;
    private Ship shipAtPier;
    private PortStorage portStorage = PortStorage.getPortStorage();

    public Pier(Port port, String name) {
        this.port = port;
        new Thread(this, name).start();
    }

    public void setShipAtPier(Ship shipAtPier) {
        this.shipAtPier = shipAtPier;
        synchronized (this){
            notify();
        }
    }

    @Override
    public void run() {
        while (true){
            while(!isEmptyPier()){
                System.out.println(Thread.currentThread().getName() + " accept the ship " + shipAtPier.getName());
                while (!shipAtPier.isEmpty()) {
                    shipAtPier.unload();
                    portStorage.load();
                }
                System.out.println("++++++++++++++++++++++++++ " + shipAtPier.getName() + " unloaded  and sailed away ++++++++++++++++++++++++++");
                System.out.println("Storage is loaded by " + portStorage.getContainers());
                setShipAtPier(null);


                port.shipsCount.decrementAndGet();
                Port.lock.lock();
                Port.occupiedPierCondition.signalAll();
                Port.lock.unlock();
            }
            synchronized (this){
                try {
                    System.out.println(Thread.currentThread().getName() + " is waiting");
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean isEmptyPier(){
        return shipAtPier == null;
    }
}
