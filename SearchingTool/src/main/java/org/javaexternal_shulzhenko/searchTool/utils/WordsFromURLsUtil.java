package org.javaexternal_shulzhenko.searchTool.utils;

import java.util.*;

public class WordsFromURLsUtil {

    List<String> urls;
    TextExtractorUtil searcher;

    public WordsFromURLsUtil() {
        setUpThisUtil();
    }

    public List<String []> getSortedWordsWithURLsAndFreq(){
        Map<String, Map<String, Integer>> urlsWithParsedTexts = getURLsWithParsedTexts();
        List<String[]> listOfWords = transformToList(urlsWithParsedTexts);
        sortListByWordsWithURLsAndFreq(listOfWords);
        return listOfWords;
    }

    public Map<String, Map<String, Integer>> getURLsWithParsedTexts(){

        Map<String,String> urlsTexts = getURLsWithUnparsedTexts();
        Map<String, Map<String, Integer>> urlsWithParsedTexts = new HashMap<>();

        for (String singleUrl : urlsTexts.keySet()) {
            String textFromSingleUrl = urlsTexts.get(singleUrl);
            Map<String, Integer> parsedText = ParsingTextUtil.parseText(textFromSingleUrl);
            urlsWithParsedTexts.put(singleUrl, parsedText);
        }
        return urlsWithParsedTexts;
    }

    public Map<String, String> getURLsWithUnparsedTexts(){
        Map<String, String> texts = new HashMap<>();
        for(String singleUrl : urls){
            texts.put(singleUrl, searcher.getText(singleUrl));
        }
        return texts;
    }

    private void setUpThisUtil() {
        urls = UrlsReaderUtil.getURLs();
        searcher = new TextExtractorUtil();
    }

    private List<String[]> transformToList(Map<String, Map<String, Integer>> urlsWithParsedTexts) {
        List<String[]> listOfWords = new LinkedList<>();
        for (String singleUrl: urlsWithParsedTexts.keySet()) {
            Map<String, Integer> singleUrlWords = urlsWithParsedTexts.get(singleUrl);
            for (String singleWord : singleUrlWords.keySet()) {
                String wordFreq = singleUrlWords.get(singleWord).toString();
                String[] toList = new String[]{singleUrl, singleWord, wordFreq};
                listOfWords.add(toList);
            }
        }
        return listOfWords;
    }

    private void sortListByWordsWithURLsAndFreq(List<String[]> listOfWords) {
        Collections.sort(listOfWords, (o1, o2) -> o1[1].compareTo(o2[1]));
    }

}
