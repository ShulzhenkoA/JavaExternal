package ua.javaexternal_shulzhenko.port._lock_condition_v_0_4;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args){

        Port port = new Port();
        ScheduledThreadPoolExecutor stpe = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(10);
        for (int i = 1; i <= 20; i++) {
            if(i > 10){
                stpe.schedule(new Ship(port, "Ship " + i), 3, TimeUnit.SECONDS);
            }else {
                stpe.execute(new Ship(port, "Ship " + i));
            }
        }
    }
}
