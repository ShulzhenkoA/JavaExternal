package org.javaexternal_shulzhenko.searchTool.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class TextExtractorUtil {

    private static TextExtractorUtil textExtractorUtil = new TextExtractorUtil();

    private TextExtractorUtil() {
    }

    public static TextExtractorUtil getTextExtractorUtil() {
        return textExtractorUtil;
    }

    public static String getText(String url){
        try {
            Document doc = Jsoup.connect(url).get();
            return doc.text();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
