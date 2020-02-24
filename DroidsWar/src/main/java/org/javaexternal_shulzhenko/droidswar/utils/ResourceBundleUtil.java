package org.javaexternal_shulzhenko.droidswar.utils;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceBundleUtil {
    INSTANCE;
    private ResourceBundle resourceBundle;
    private final String resourceName = "language";

    ResourceBundleUtil() {
        resourceBundle = ResourceBundle.getBundle(resourceName, Locale.ENGLISH);
    }

    public void changeResource(Locale locale){
        resourceBundle = ResourceBundle.getBundle(resourceName, locale);
    }

    public String getString(String key){
        return resourceBundle.getString(key);
    }
}
