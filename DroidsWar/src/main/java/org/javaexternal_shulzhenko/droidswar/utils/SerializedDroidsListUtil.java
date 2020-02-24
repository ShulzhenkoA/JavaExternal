package org.javaexternal_shulzhenko.droidswar.utils;

import org.apache.log4j.Logger;
import org.javaexternal_shulzhenko.droidswar.controllers.VerifiedUser;
import org.javaexternal_shulzhenko.droidswar.droids.DroidB01;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class SerializedDroidsListUtil {

    private static final Logger LOGGER = Logger.getLogger(SerializedDroidsListUtil.class);
    private static ArrayList<DroidB01> droidsList;
    private static final String DROIDS_LIST_DB_PATH = "src/main/resources/DroidsList.bin";

    public static ArrayList<DroidB01> retrieveDroidsList(){
        isNotLoadYet();
        return droidsList;
    }

    public static ArrayList<DroidB01> retrieveSortedDroidList(){
        isNotLoadYet();
        ArrayList<DroidB01> sortedList = new ArrayList<>();
        for(DroidB01 droid: droidsList) {
            sortedList.add(droid);
        }
        sortedList.sort(Comparator.comparingInt(DroidB01::getMaxHealth));
        return sortedList;
    }

    public static void addDroidToList(DroidB01 droid) {
        isNotLoadYet();
        droidsList.add(droid);
        serializeDroidsList();
    }

    public static void deleteDroidFromList(int index) {
        droidsList.remove(index - 1);
        serializeDroidsList();
    }

    private static void serializeDroidsList(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(DROIDS_LIST_DB_PATH)))){
            oos.writeObject(droidsList);
            oos.flush();
        } catch (IOException exc) {
            LOGGER.warn(exc);
        }
    }

    private static ArrayList<DroidB01>deserializeDroidsList() {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(DROIDS_LIST_DB_PATH)))){
            return (ArrayList<DroidB01>) ois.readObject();
        }catch (ClassNotFoundException exc) {
            LOGGER.warn(exc);
        }catch (EOFException exc){
            LOGGER.warn(exc);
        } catch (IOException exc){
            LOGGER.warn(exc);
        }
        return null;
    }

    private static void isNotLoadYet(){
        if(droidsList == null){
            droidsList = deserializeDroidsList();
            if(droidsList==null){
                droidsList = new ArrayList<>();
            }
        }
    }
}
