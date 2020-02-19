package org.javaexternal_shulzhenko.droidswar.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DataBaseConnectingUtil {

    public static final String NICKNAME_RECEIVE_SNIPPET = ".nickname";
    public static final String PASSWORD_RECEIVE_SNIPPET = ".password";
    public static final String ADMIN_STATUS_RECEIVE_SNIPPET =".admin";
    private static final String NICKNAME_SAVE_SNIPPET = ".nickname=";
    private static final String PASSWORD_SAVE_SNIPPET = ".password=";
    private static final String ADMIN_STATUS_SAVE_SNIPPET =".admin=";

    public static void saveUserNickname(String nickname){
        saveDataToDB(nickname + NICKNAME_SAVE_SNIPPET + nickname,
                "src/main/resources/UsersDataBase.properties");
    }

    public static void saveUserPassword(String nickname, String password){
        saveDataToDB(nickname + PASSWORD_SAVE_SNIPPET + password,
                "src/main/resources/UsersDataBase.properties");
    }

    public static void saveUserAdminStatus(String nickname, boolean status){
        saveDataToDB(nickname + ADMIN_STATUS_SAVE_SNIPPET + status,
                "src/main/resources/UsersDataBase.properties");
    }

    public static void saveDroidToDB(String droidModel){
        saveDataToDB(droidModel, "src/main/resources/DroidsList.properties");
    }

    public static void rewriteDroidsToDB(List<String> droids){
        rewriteDataToDB(droids,"src/main/resources/DroidsList.properties");
    }

    public static List<String> receiveDroidsListFromDB(){

        List<String> droidsList;
        try(BufferedReader reader = new BufferedReader( new FileReader("src/main/resources/DroidsList.properties")) ) {

            droidsList = new ArrayList<>();
            String droid;
            while ((droid=reader.readLine())!=null){
                droidsList.add(droid);
            }
            return droidsList;
        } catch (IOException e) {
            System.err.println("Reading file error!");
        }
        return null;
    }

    public static String receiveUsersDataFromDB(String userName, String data){


        Properties property = new Properties();

        try(FileInputStream fis = new FileInputStream("src/main/resources/UsersDataBase.properties")) {

            property.load(fis);
            return property.getProperty(userName + data);

        } catch (IOException e) {
            System.err.println("Reading file error!");
        }
        return null;
    }

    private static void saveDataToDB(String data, String dbname){
        try(FileWriter saver = new FileWriter(dbname, true)){
            saver.write(data);
            saver.append('\n');
        }catch (IOException e){
            System.out.println("Writing file error!");
        }
    }

    private static void rewriteDataToDB(List<String> dataList, String dbname){
        try(FileWriter saver = new FileWriter(dbname, false)){
            for(String data : dataList ){
                saver.write(data);
                saver.append('\n');
            }
        }catch (IOException e){
            System.out.println("Writing file error!");
        }
    }
}
