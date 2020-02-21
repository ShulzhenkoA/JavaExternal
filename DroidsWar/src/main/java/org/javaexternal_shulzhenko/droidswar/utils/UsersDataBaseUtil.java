package org.javaexternal_shulzhenko.droidswar.utils;

import java.io.*;
import java.util.Properties;

public class UsersDataBaseUtil {

    public static final String NICKNAME_RECEIVE_SNIPPET = ".nickname";
    public static final String PASSWORD_RECEIVE_SNIPPET = ".password";
    public static final String ADMIN_STATUS_RECEIVE_SNIPPET =".admin";
    private static final String NICKNAME_SAVE_SNIPPET = ".nickname=";
    private static final String PASSWORD_SAVE_SNIPPET = ".password=";
    private static final String ADMIN_STATUS_SAVE_SNIPPET =".admin=";

    private static final String USERS_DB_PATH = "src/main/resources/UsersDataBase.properties";

    public static void saveUserNickname(String nickname){
        saveToDB(nickname + NICKNAME_SAVE_SNIPPET + nickname);
    }

    public static void saveUserPassword(String nickname, String password){
        saveToDB(nickname + PASSWORD_SAVE_SNIPPET + password);
    }

    public static void saveUserAdminStatus(String nickname, boolean status){
        saveToDB(nickname + ADMIN_STATUS_SAVE_SNIPPET + status);
    }

    public static String receiveUsersDataFromDB(String userName, String data){

        Properties property = new Properties();

        try(FileInputStream fis = new FileInputStream(USERS_DB_PATH)) {

            property.load(fis);
            return property.getProperty(userName + data);

        } catch (IOException e) {
            System.err.println("Reading file error!");
        }
        return null;
    }

    private static void saveToDB(String data){
        try(FileWriter saver = new FileWriter(USERS_DB_PATH, true)){
            saver.write(data + "\n");
        }catch (IOException e){
            System.out.println("Writing file error!");
        }
    }

}
