package org.javaexternal_shulzhenko;

import org.javaexternal_shulzhenko.searchTool.*;

import java.util.*;

public class SearchWords {

    public static void main(String[] args) {
        TextExtractorUtil textExtractorUtil = new TextExtractorUtil();
        ConsoleView consoleView = new ConsoleView();
        SearchingToolAggregator searchingToolAggregator = new SearchingToolAggregator(textExtractorUtil, consoleView);
        searchingToolAggregator.showWordsFromUrls();
    }
}
