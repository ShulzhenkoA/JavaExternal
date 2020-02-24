package org.javaexternal_shulzhenko.droidswar.utils;

import org.apache.log4j.Logger;
import org.javaexternal_shulzhenko.droidswar.controllers.VerifiedUser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputDataReaderUtil {

    private static final Logger LOGGER = Logger.getLogger(InputDataReaderUtil.class);

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
