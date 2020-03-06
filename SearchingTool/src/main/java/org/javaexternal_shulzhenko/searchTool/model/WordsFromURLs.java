package org.javaexternal_shulzhenko.searchTool.model;

import org.javaexternal_shulzhenko.searchTool.utils.UrlsReaderUtil;
import org.javaexternal_shulzhenko.searchTool.utils.WordsExtractorUtil;

import java.util.List;
import java.util.Map;

public class WordsFromURLs {

    private WordsExtractorUtil wordsExtractorUtil;
    private List<String> urls;

    public WordsFromURLs() {
        loadData();
    }

    private void loadData() {
        wordsExtractorUtil = WordsExtractorUtil.getWordsExtractorUtil();
        urls = UrlsReaderUtil.getURLs();
    }

    public List<String[]> getAllSortedWordsURLsFreq() {
        return wordsExtractorUtil.getSortedWordsURLsFreq(urls);
    }

    public Map<String, Map<String, Integer>> getUrlsWordsFreq() {
        return wordsExtractorUtil.getURLsSortedWordsFreq(urls);
    }

    public List<String[]> getSearchedWordURLsFreq(String word){
        return wordsExtractorUtil.getSearchedWordURLsFreq(urls, word);
    }
}
