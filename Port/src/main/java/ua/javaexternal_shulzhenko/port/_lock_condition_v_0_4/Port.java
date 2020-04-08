package ua.javaexternal_shulzhenko.port._lock_condition_v_0_4;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.*;

public class Port {

    static ReentrantLock lock = new ReentrantLock();
    static final Condition occupiedPierCondition = lock.newCondition();

    AtomicInteger shipsCount = new AtomicInteger(0);

    private final List<Pier> PORTPIERS = Collections.synchronizedList(Arrays.asList(
            new Pier(this,"First pier"),
            new Pier(this,"Second pier")));

    public synchronized void allowShipEnterToPortPier(Ship ship) throws InterruptedException {
        System.out.println(ship.getName() + " is arriving to Port");
        while(shipsCount.get() == 2){
            System.out.println(ship.getName() + " is waiting for pier releasing.");
            lock.lock();
            occupiedPierCondition.await();
            lock.unlock();
        }
        shipsCount.addAndGet(1);
        occupyPier(ship);
    }

    private void occupyPier(Ship ship)  {
        for (Pier pier : PORTPIERS) {
            if(pier.isEmptyPier()){
                pier.setShipAtPier(ship);
                break;
            }
        }
    }
}
