package org.javaexternal_shulzhenko;

import org.javaexternal_shulzhenko.searchTool.controller.SearchingToolController;
import org.javaexternal_shulzhenko.searchTool.console.ConsoleView;
import org.javaexternal_shulzhenko.searchTool.model.WordsFromURLs;

public class SearchWords {

    public static void main(String[] args) {
        ConsoleView consoleView = new ConsoleView();
        WordsFromURLs wordsFromURLs = new WordsFromURLs();
        SearchingToolController searchingToolAggregator = new SearchingToolController(consoleView, wordsFromURLs);
        searchingToolAggregator.showSortedWordsFromUrls();
        searchingToolAggregator.showURLsWithWordsFreq();
    }
}
