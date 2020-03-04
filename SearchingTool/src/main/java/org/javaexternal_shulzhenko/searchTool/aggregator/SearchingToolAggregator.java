package org.javaexternal_shulzhenko.searchTool.aggregator;

import org.javaexternal_shulzhenko.searchTool.console.ConsoleView;
import org.javaexternal_shulzhenko.searchTool.utils.WordsFromURLsUtil;

import java.util.List;

public class SearchingToolAggregator {

    private WordsFromURLsUtil wordsFromURLsUtil;
    private ConsoleView consoleView;
    private List<String[]> searchedSortedWords;

    public SearchingToolAggregator(ConsoleView consoleView) {
        this.consoleView = consoleView;
        setUpThisTool();
    }

    private void setUpThisTool() {
        wordsFromURLsUtil = new WordsFromURLsUtil();
    }

    public void showSortedWordsFromUrls(){
        searchedSortedWords = wordsFromURLsUtil.getSortedWordsWithURLsAndFreq();
        consoleView.displayWords(searchedSortedWords);
    }
}
