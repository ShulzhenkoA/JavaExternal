package com.javaextetnal_shulzhenko.gaming.GuessTheNumber;

import java.util.Locale;
import java.util.ResourceBundle;
/**
 * Class for providing i18n in game
 *
 * @version 0.2 13 Feb 2020
 * @author Adnrii Shulzhenko
 */
public enum ResourceManager {
    INSTANCE;
    private ResourceBundle resourceBundle;
    private final String resourceName = "text";

    ResourceManager() {
        resourceBundle = ResourceBundle.getBundle(resourceName, Locale.getDefault());
    }

    public void changeResource(Locale locale){
        resourceBundle = ResourceBundle.getBundle(resourceName, locale);
    }

    public String getString(String key){
        return resourceBundle.getString(key);
    }
}
