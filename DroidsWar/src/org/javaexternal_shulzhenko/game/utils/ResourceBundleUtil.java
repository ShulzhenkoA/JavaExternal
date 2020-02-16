package org.javaexternal_shulzhenko.game.utils;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Class for providing i18n in game
 *
 * @version 0.4 13 Feb 2020
 * @author Adnrii Shulzhenko
 */
public enum ResourceBundleUtil {
    INSTANCE;
    private ResourceBundle resourceBundle;
    private final String resourceName = "org/javaexternal_shulzhenko/language";

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
