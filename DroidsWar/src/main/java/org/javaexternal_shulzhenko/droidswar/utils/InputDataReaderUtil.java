package org.javaexternal_shulzhenko.droidswar.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputDataReaderUtil {

    private static final Logger LOGGER = LogManager.getLogger(InputDataReaderUtil.class);

    public static String readInputData() {
        String data = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            data = br.readLine();
        } catch (IOException exc) {
            LOGGER.warn(exc);
        }
        return data;
    }
}
