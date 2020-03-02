package org.javaexternal_shulzhenko.searchTool;

import java.util.Map;

public class SearchingToolAggregator {
    private TextExtractorUtil textExtractorUtil;
    private WordsSearcherUtil wordsSearcher;
    private ConsoleView consoleView;
    private Map<String, Integer> searchedWords;
    private String[] keysArray;

    public SearchingToolAggregator(TextExtractorUtil textExtractorUtil,  ConsoleView consoleView) {
        this.textExtractorUtil = textExtractorUtil;
        this.consoleView = consoleView;
    }

    public void showWordsFromUrls(){
        wordsSearcher = new WordsSearcherUtil(UrlsReaderUtil.getURLs() ,textExtractorUtil);
        searchedWords = wordsSearcher.retrieveSortedWords();
        keysArray = extractKeysSet(searchedWords);
        consoleView.displayWords(keysArray, searchedWords);
    }

    private String[] extractKeysSet(Map<String, Integer> words){
        return words.keySet().toArray(new String[searchedWords.size()]);
    }

}
