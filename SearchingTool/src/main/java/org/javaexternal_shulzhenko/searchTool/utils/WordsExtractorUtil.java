package org.javaexternal_shulzhenko.searchTool.utils;

import java.util.*;

public class WordsExtractorUtil {

    private static WordsExtractorUtil wordsExtractorUtil= new WordsExtractorUtil();

    private WordsExtractorUtil() {
    }

    public static WordsExtractorUtil getWordsExtractorUtil() {
        return wordsExtractorUtil;
    }

    public List<String []> getSortedWordsURLsFreq(List<String> urls){
        Map<String, Map<String, Integer>> urlsWithParsedTexts = getURLsSortedWordsFreq(urls);
        List<String[]> listOfWords = transformToList(urlsWithParsedTexts);
        sortWordsWithURLsAndFreq(listOfWords);
        return listOfWords;
    }

    public List<String[]> getSearchedWordURLsFreq(List<String> urls, String searchedWord){
        Map<String, Map<String, Integer>> urlsWordsFreq = getURLsSortedWordsFreq(urls);
        List<String[]> searchedWordURLsFreq = new LinkedList<>();
        for (String singleUrl : urlsWordsFreq.keySet()) {
            Map<String , Integer> wordsFreq = urlsWordsFreq.get(singleUrl);
            String firstChar = String.valueOf(searchedWord.charAt(0));
            String[] twoCaseWord = new String[]{firstChar.toUpperCase() + searchedWord.substring(1),
                    firstChar.toLowerCase() + searchedWord.substring(1)};
            for(String word: twoCaseWord){
                Integer freq = wordsFreq.get(word);
                String freqInStr = (freq == null) ? String.valueOf(0) : freq.toString();
                searchedWordURLsFreq.add(new String[]{word, singleUrl, freqInStr});
            }
        }
        return searchedWordURLsFreq;
    }

    public Map<String, Map<String, Integer>> getURLsSortedWordsFreq(List<String> urls){
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

    private void sortWordsWithURLsAndFreq(List<String[]> listOfWords) {
        Collections.sort(listOfWords, Comparator.comparing(o -> o[1]));
    }
}
