package org.javaexternal_shulzhenko.searchTool.console;

import java.util.List;

public class ConsoleView {
    public void displayWords(List<String[]> words){
        for (int i = 1; i < words.size(); i++) {
            System.out.printf("%-18s ------- %-80s = %3s \n", words.get(i)[1], words.get(i)[0],words.get(i)[2]);
        }
    }
}
