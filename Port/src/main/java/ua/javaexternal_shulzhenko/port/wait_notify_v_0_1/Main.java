package ua.javaexternal_shulzhenko.port.wait_notify_v_0_1;

public class Main {

    public static void main(String[] args) throws InterruptedException {


        Port port = new Port();
        new Ship(port, "Ship 1");
        Thread.sleep(90);
        new Ship(port, "Ship 2");
        Thread.sleep(90);
        new Ship(port, "Ship 3");
        Thread.sleep(90);
        new Ship(port, "Ship 4");
        new Ship(port, "Ship 5");
        Thread.sleep(90);
        new Ship(port, "Ship 6");
        Thread.sleep(4000);
        new Ship(port, "Ship 7");
        Thread.sleep(90);
        new Ship(port, "Ship 8");
        Thread.sleep(90);
        new Ship(port, "Ship 9");
        Thread.sleep(90);
        new Ship(port, "Ship 10");
    }
}
