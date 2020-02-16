package org.javaexternal_shulzhenko.game.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputDataReaderUtil {
    public static String readInputData() {
        String data = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            data = br.readLine();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
        return data;
    }
}
