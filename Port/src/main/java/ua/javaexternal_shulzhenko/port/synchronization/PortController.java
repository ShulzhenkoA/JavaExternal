package ua.javaexternal_shulzhenko.port.synchronization;

public class PortController implements Runnable {

    private Port port;

    public PortController(Port port) {
        this.port = port;
        new Thread(this, "Port Controller").start();
    }

    @Override
    public void run() {
        while (true){
            if(port.isEmptyPort()){
                try {
                    synchronized (this){
                        System.out.println("in port wait");
                        if(port.isShipsAtPiers()){
                            port.makePiersWork();
                            wait(100);
                        }else{
                            wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            port.sendShipToPier();
        }
    }

    public void informPortController(){
        synchronized (this){
            notify();
        }
    }
}
