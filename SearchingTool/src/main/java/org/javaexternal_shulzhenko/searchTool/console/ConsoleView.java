package org.javaexternal_shulzhenko.searchTool.console;

import org.javaexternal_shulzhenko.searchTool.model.WordsFromURLs;

import java.util.List;
import java.util.Map;

public class ConsoleView {
    public void displayAllSortedWords(WordsFromURLs wordsFromURLs){
        List<String[]> wordsList = wordsFromURLs.getAllSortedWordsURLsFreq();
        for (int i = 0; i < wordsList.size(); i++) {
            System.out.printf("%-18s ------- %-80s = %3s \n", wordsList.get(i)[1], wordsList.get(i)[0], wordsList.get(i)[2]);
        }
    }

    public void displaySingleSearchedWord(WordsFromURLs wordsFromURLs, String searchedWord){
        List<String[]> word = wordsFromURLs.getSearchedWordURLsFreq(searchedWord);
        for (int i = 0; i < word.size(); i++) {
            System.out.printf("%-18s ------- %-80s = %3s \n", word.get(i)[0], word.get(i)[1], word.get(i)[2]);
        }
    }

    public void displayURLsWithWords(WordsFromURLs wordsFromURLs) {
        Map<String, Map<String, Integer>> urlsWords = wordsFromURLs.getUrlsWordsFreq();
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
