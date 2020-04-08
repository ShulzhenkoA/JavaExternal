package ua.javaexternal_shulzhenko.port.executors_v_0_3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Port {

    public static final Semaphore SEMAPHORE = new Semaphore(2, true);
    private final List<Pier> PORTPIERS = Collections.synchronizedList(Arrays.asList(
            new Pier(this,"First pier"),
            new Pier(this,"Second pier")));

    public synchronized void allowShipEnterToPortPier(Ship ship) throws InterruptedException {
        System.out.println(ship.getName() + " is arriving to Port");

        if(SEMAPHORE.availablePermits() == 0){
            System.out.println(ship.getName() + " is waiting for pier releasing.");
        }
        SEMAPHORE.acquire();
        occupyPier(ship);
    }

    private void occupyPier(Ship ship) {
        for (Pier pier : PORTPIERS) {
            if(pier.isEmptyPier()){
                pier.setShipAtPier(ship);
                break;
            }
        }
    }
}
