package org.javaexternal_shulzhenko.searchTool.utils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UrlConnectorUtil {
    public static URLConnection openURLConnection(String url){
        try {
            URL website = new URL(url);
            URLConnection connection = website.openConnection();
            return connection;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
