package org.javaexternal_shulzhenko.searchTool;

import java.util.Map;

public class ConsoleView {
    public void displayWords(String[] keysArray, Map<String, Integer> words){
        System.out.println(words.size() + " distinct words");
        for (int i = 1; i < keysArray.length; i++) {
            System.out.printf("%-20s = %3s \t\t", keysArray[i], words.get(keysArray[i]));
            if (i % 5 == 0){
                System.out.println();
            }
        }
    }
}
