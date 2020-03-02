package org.javaexternal_shulzhenko.searchTool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class TextExtractorUtil {

    public String getText(String url){
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(UrlConnectorUtil.openURLConnection(url).
                getInputStream(), "UTF-8"))) {
            return reader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
