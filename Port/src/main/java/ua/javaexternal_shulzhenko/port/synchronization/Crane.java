package ua.javaexternal_shulzhenko.port.synchronization;

public class Crane {
    boolean flag = false;

    synchronized void getFromShip(){
        while (!flag){
            try{
                wait();
            }catch (InterruptedException exc){
                System.err.println(exc);
            }
        }

        System.out.println("Container was unloaded from the");
        flag = false;
        notify();
    }

    synchronized void putOntoStorage(){
        while (flag){
            try{
                wait();
            }catch (InterruptedException exc){
                System.err.println(exc);
            }
        }
        System.out.println("Container was loaded onto the");
        flag = true;
        notify();
    }
}
