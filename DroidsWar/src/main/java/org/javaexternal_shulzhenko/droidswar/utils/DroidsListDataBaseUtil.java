package org.javaexternal_shulzhenko.droidswar.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javaexternal_shulzhenko.droidswar.droids.DroidB01;
import org.javaexternal_shulzhenko.droidswar.factories.DroidFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DroidsListDataBaseUtil {

    private static final Logger LOGGER = LogManager.getLogger(DroidsListDataBaseUtil.class);
    private static final String DROIDS_DB_PATH = "src/main/resources/DroidsList.csv";

    public static void saveDroidToDB(String droidModel){
        try(FileWriter saver = new FileWriter(DROIDS_DB_PATH, true)){
            saver.write(droidModel+ "\n");
        }catch (IOException exc){
            LOGGER.warn(exc);
        }
    }

    public static ArrayList<DroidB01> receiveDroidsListFromDB(){

        ArrayList<DroidB01> droidsList = new ArrayList<>();
        String droidModel;
        try(BufferedReader reader = new BufferedReader( new FileReader(DROIDS_DB_PATH)) ) {
            while ((droidModel = reader.readLine())!=null){
                droidsList.add(DroidFactory.getDroidFactory().createDroid(droidModel));
            }
            return droidsList;
        } catch (IOException exc) {
            LOGGER.warn(exc);
        }
        return null;
    }

    public static void rewriteDroidsListToDB(ArrayList<DroidB01> droids){
        try(FileWriter saver = new FileWriter(DROIDS_DB_PATH, false)){
            for(DroidB01 droidB01 : droids){
                saver.write(droidB01.getModel() + "\n");
            }
        }catch (IOException exc){
            LOGGER.warn(exc);
        }
    }
}
