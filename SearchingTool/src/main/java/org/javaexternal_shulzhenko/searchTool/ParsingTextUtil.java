package org.javaexternal_shulzhenko.searchTool;

import java.util.HashMap;
import java.util.Map;

public class ParsingTextUtil {

    public static Map<String, Integer> parseText(String text){
        Map<String, Integer> parsedText = new HashMap<>();
        String[] words = text.split("\\P{L}+");
        for(String tempString: words){
            Integer freq = parsedText.get(tempString);
            parsedText.put(tempString, (freq == null) ? 1 : freq +1);
        }
        return parsedText;
    }
}
