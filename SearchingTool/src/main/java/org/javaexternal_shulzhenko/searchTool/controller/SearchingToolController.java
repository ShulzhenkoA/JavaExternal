package org.javaexternal_shulzhenko.searchTool.controller;

import org.javaexternal_shulzhenko.searchTool.console.ConsoleView;
import org.javaexternal_shulzhenko.searchTool.model.WordsFromURLs;

public class SearchingToolController {

    private WordsFromURLs wordsFromURLs;
    private ConsoleView consoleView;

    public SearchingToolController(ConsoleView consoleView, WordsFromURLs wordsFromURLs) {
        this.consoleView = consoleView;
        this.wordsFromURLs = wordsFromURLs;
    }

    public void showSortedWordsFromUrls(){
        consoleView.displayAllSortedWords(wordsFromURLs);
    }

    public void showURLsWithWordsFreq(){
        consoleView.displayURLsWithWords(wordsFromURLs);
    }

    public void showWordFreqInURLs(String word){
        consoleView.displaySingleSearchedWord(wordsFromURLs, word);
    }
}
