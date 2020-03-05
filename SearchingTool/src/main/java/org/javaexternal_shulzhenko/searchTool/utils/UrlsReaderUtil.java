package org.javaexternal_shulzhenko.searchTool.utils;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class UrlsReaderUtil {

    private static UrlsReaderUtil urlsReaderUtil = new UrlsReaderUtil();
    private static final String URLs_DB = "src/main/resources/URLs_DB.txt";

    private UrlsReaderUtil() {
    }

    public static UrlsReaderUtil getUrlsReaderUtil() {
        return urlsReaderUtil;
    }

    public static List<String> getURLs(){
        try(BufferedReader reader = new BufferedReader(new FileReader(URLs_DB))) {
            String tempUrl;
            List<String> urlsFromDB = new LinkedList<>();
            while ((tempUrl = reader.readLine())!=null){
                urlsFromDB.add(tempUrl);
            }
            return urlsFromDB;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
