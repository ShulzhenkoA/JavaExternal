package ua.javaexternal_shulzhenko.port.wait_notify_v_0_1;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Port port = new Port();
        for (int i = 1; i <= 10; i++) {
            if(i==6){
                Thread.sleep(3000);
            }
            new Ship(port, "Ship " + i);
        }
    }
}
