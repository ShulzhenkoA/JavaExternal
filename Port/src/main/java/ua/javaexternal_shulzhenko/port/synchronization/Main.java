package ua.javaexternal_shulzhenko.port.synchronization;

public class Main {

    public static void main(String[] args) {

        Port port = new Port();
        new Ship(port, "A");
        new Ship(port, "B");
        new Ship(port, "C");
        new Ship(port, "D");
        new Ship(port, "E");
        new Ship(port, "F");
        new Ship(port, "G");
        new Ship(port, "H");
        new Ship(port, "I");
        new Ship(port, "J");
        new Ship(port, "K");
        new Ship(port, "L");
    }
}
