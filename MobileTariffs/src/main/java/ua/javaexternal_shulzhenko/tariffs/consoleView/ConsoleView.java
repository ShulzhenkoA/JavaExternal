package ua.javaexternal_shulzhenko.tariffs.consoleView;

public class ConsoleView {

    public void printMassage(String message) {
        System.out.println(message);
    }

    public void printMassage(ConsoleMessages message) {
        System.out.println(message.getMessage());
    }
}
