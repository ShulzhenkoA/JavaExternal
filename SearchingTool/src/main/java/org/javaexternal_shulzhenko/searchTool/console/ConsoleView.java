package org.javaexternal_shulzhenko.searchTool.console;

import org.javaexternal_shulzhenko.searchTool.model.WordsFromURLs;

import java.util.List;
import java.util.Map;

public class ConsoleView {
    public void displaySortedWords(WordsFromURLs wordsFromURLs){
        List<String[]> wordsList = wordsFromURLs.getSortedWordWithURLsAndFreq();
        for (int i = 1; i < wordsList.size(); i++) {
            System.out.printf("%-18s ------- %-80s = %3s \n", wordsList.get(i)[1], wordsList.get(i)[0], wordsList.get(i)[2]);
        }
    }

    public void displayURLsWithWords(WordsFromURLs wordsFromURLs) {
        Map<String, Map<String, Integer>> urlsWords = wordsFromURLs.getUrlsWithSortedWordsAndFreq();
        for (String singleUrl: urlsWords.keySet()) {
            System.out.println(singleUrl);
            Map<String, Integer> wordsFreq = urlsWords.get(singleUrl);
            int count = 0;
            for (String word: wordsFreq.keySet()) {
                int freq = wordsFreq.get(word);
                System.out.printf("%-20s = %3s ", word, freq);
                count++;
                if(count % 4 == 0){
                    System.out.println();
                }
            }
            System.out.println();
        }
    }
}
