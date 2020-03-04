package org.javaexternal_shulzhenko;

import org.javaexternal_shulzhenko.searchTool.aggregator.SearchingToolAggregator;
import org.javaexternal_shulzhenko.searchTool.console.ConsoleView;

public class SearchWords {

    public static void main(String[] args) {
        ConsoleView consoleView = new ConsoleView();
        SearchingToolAggregator searchingToolAggregator = new SearchingToolAggregator(consoleView);
        searchingToolAggregator.showSortedWordsFromUrls();
    }
}
