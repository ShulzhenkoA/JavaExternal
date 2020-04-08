package ua.javaexternal_shulzhenko.port.wait_notify_v_0_1;

import java.util.*;

public class Port {


    private List<Pier> portPiers;
    private Pier freePier;

    public Port() {
        portPiers = Arrays.asList(new Pier(this,"First pier"), new Pier(this,"Second pier"));
    }

    public synchronized void allowShipEnterToPortPier(Ship ship){
        System.out.println(Thread.currentThread().getName() + " is arriving to Port");
        while(!isFreePier()){
            try {
                System.out.println(Thread.currentThread().getName() + " is waiting in port because there are no free piers");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        freePier.setShipAtPier(ship);
    }

    private boolean isFreePier() {
        for (Pier pier : portPiers) {
            if(pier.isEmptyPier()){
                freePier = pier;
                return true;
            }
        }
        return false;
    }
}
