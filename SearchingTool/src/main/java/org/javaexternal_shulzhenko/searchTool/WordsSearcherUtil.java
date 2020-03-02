package org.javaexternal_shulzhenko.searchTool;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class WordsSearcherUtil {

    List<String> urls;
    TextExtractorUtil searcher;

    public WordsSearcherUtil(List<String> urls, TextExtractorUtil searcher) {
        this.urls = urls;
        this.searcher = searcher;
    }

    public Map<String, Integer> retrieveSortedWords(){
        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.putAll(retrieveWordsFromTexts());
        return treeMap;
    }

    public Map<String, Integer> retrieveWordsFromTexts(){
        return ParsingTextUtil.parseText(searchTexts());
    }

    public String searchTexts(){

        StringBuilder texts = new StringBuilder();
        for(String singleUrl : urls){
            texts.append(searcher.getText(singleUrl));
        }
        return texts.toString();
    }
}
