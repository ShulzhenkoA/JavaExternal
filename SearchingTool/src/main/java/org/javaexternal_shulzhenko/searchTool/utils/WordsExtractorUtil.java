package org.javaexternal_shulzhenko.searchTool.utils;

import java.util.*;

public class WordsExtractorUtil {

    private static WordsExtractorUtil wordsExtractorUtil= new WordsExtractorUtil();

    private WordsExtractorUtil() {
    }

    public static WordsExtractorUtil getWordsExtractorUtil() {
        return wordsExtractorUtil;
    }

    public List<String []> getSortedWordsWithURLsAndFreq(List<String> urls){
        Map<String, Map<String, Integer>> urlsWithParsedTexts = getURLsWithSortedWordsAndFreq(urls);
        List<String[]> listOfWords = transformToList(urlsWithParsedTexts);
        sortListByWordsWithURLsAndFreq(listOfWords);
        return listOfWords;
    }

    public Map<String, Map<String, Integer>> getURLsWithSortedWordsAndFreq(List<String> urls){
        Map<String,String[]> urlsTexts = getURLsWithParsedTexts(urls);
        Map<String, Map<String, Integer>> urlsWordsFreq = new HashMap<>();
        for (String singleUrl : urlsTexts.keySet()) {
            String[] wordsFromUrl = urlsTexts.get(singleUrl);
            Map<String, Integer> wordsWithFreq = countWordFreqAndSort(wordsFromUrl);
            wordsWithFreq.remove("-");
            urlsWordsFreq.put(singleUrl, wordsWithFreq);
        }
        return urlsWordsFreq;
    }

    public Map<String, String[]> getURLsWithParsedTexts(List<String> urls){
        Map<String, String[]> texts = new HashMap<>();

        for(String singleUrl : urls){
            String textFromUrl = TextExtractorUtil.getText(singleUrl);
            String[] parsedText = textFromUrl.split("[^-\\p{L}]+");
            texts.put(singleUrl, parsedText);
        }
        return texts;
    }

    private Map<String, Integer> countWordFreqAndSort(String[] wordsFromUrl) {
        Map<String, Integer> wordsWithFreq = new TreeMap<>();
        for (String word : wordsFromUrl) {
            wordsWithFreq.get(word);
            Integer freq = wordsWithFreq.get(word);
            wordsWithFreq.put(word, (freq == null) ? 1 : freq +1);
        }
        return wordsWithFreq;
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
        Collections.sort(listOfWords, Comparator.comparing(o -> o[1]));
    }
}
