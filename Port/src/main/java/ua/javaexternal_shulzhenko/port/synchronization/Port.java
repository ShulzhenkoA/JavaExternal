package ua.javaexternal_shulzhenko.port.synchronization;

import java.util.*;

public class Port {

    private List<Pier> piers;
    private PortController portController;
    private Queue<Ship> ships;
    private final int MAX_SHIPS_IN_PORT = 3;
    private Pier emptyPier;


    public Port() {
        ships = new ArrayDeque<>();
        piers = Arrays.asList(new Pier(1), new Pier(2));
        portController = new PortController(this);
    }

    private class Pier implements Runnable{

        private Ship shipAtPier;

        public Pier(int pierNum) {
            new Thread(this, "Pier "+ pierNum).start();
        }

        public void acceptShip(){
            if(!ships.isEmpty()){
                shipAtPier = ships.remove();
                System.out.println(shipAtPier.getName() + " to pier");
            }
            informPier();
        }

        @Override
        public void run(){
            while(true){
                if(shipAtPier()){
                    System.out.println(Thread.currentThread().getName() + " accept acceptedShip " + shipAtPier.getName());
                    while (shipAtPier.getContainersNumber() !=0){
                        shipAtPier.pickupContainer();
                        System.out.println(shipAtPier.getName() + " is unloading");
                    }
                    System.out.println(shipAtPier.getName() + " unloaded_______________");
                    shipAtPier = null;
                    informAboutPierReleasing();
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
        public boolean shipAtPier(){
            return shipAtPier != null;
        }

        public void informPier(){
            synchronized (this){
                notify();
            }
        }
    }

    public synchronized void allowEntranceToPort(Ship ship){
        System.out.println(ship.getName() + " arriving");
        
        while(ships.size() == MAX_SHIPS_IN_PORT) {
            try {
                System.out.println(Thread.currentThread().getName() + " is waiting");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(ship.getName() + " sailed to port");
        ships.add(ship);
        portController.informPortController();
    }

    public synchronized void sendShipToPier(){

        while(!isFreePier()){
            try {
                makePiersWork();
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        emptyPier.acceptShip();
    }

    public void informAboutPierReleasing(){
        synchronized (this){
            notifyAll();
        }
    }

    public void makePiersWork(){
        for (Pier pier : piers){
            if(pier.shipAtPier()){
                pier.informPier();
            }
        }
    }

    public boolean isEmptyPort(){
        return ships.isEmpty();
    }

    public boolean isShipsAtPiers(){
        for (Pier pier: piers) {
            if(pier.shipAtPier()){
                return true;
            }
        }
        return false;
    }

    private boolean isFreePier() {
        for(Pier pier: piers){
            if (!pier.shipAtPier()){
                emptyPier = pier;
                return true;
            }
        }
        return false;
    }
}
