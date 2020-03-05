package org.javaexternal_shulzhenko.searchTool.model;

import org.javaexternal_shulzhenko.searchTool.utils.UrlsReaderUtil;
import org.javaexternal_shulzhenko.searchTool.utils.WordsExtractorUtil;

import java.util.List;
import java.util.Map;

public class WordsFromURLs {

    private List<String> urls;
    private List<String[]> sortedWordWithURLsAndFreq;
    private Map<String, Map<String, Integer>> urlsWithSortedWordsAndFreq;



    public WordsFromURLs() {
        loadData();
    }

    private void loadData() {
        WordsExtractorUtil wordsExtractorUtil = WordsExtractorUtil.getWordsExtractorUtil();
        urls = UrlsReaderUtil.getURLs();
        sortedWordWithURLsAndFreq = wordsExtractorUtil.getSortedWordsWithURLsAndFreq(urls);
        urlsWithSortedWordsAndFreq = wordsExtractorUtil.getURLsWithSortedWordsAndFreq(urls);
    }

    public List<String[]> getSortedWordWithURLsAndFreq() {
        return sortedWordWithURLsAndFreq;
    }

    public Map<String, Map<String, Integer>> getUrlsWithSortedWordsAndFreq() {
        return urlsWithSortedWordsAndFreq;
    }
}
