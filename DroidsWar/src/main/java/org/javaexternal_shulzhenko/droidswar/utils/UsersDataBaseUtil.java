package org.javaexternal_shulzhenko.droidswar.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javaexternal_shulzhenko.droidswar.account.Account;

import java.io.*;
import java.util.Properties;

public class UsersDataBaseUtil {

    private static final Logger LOGGER = LogManager.getLogger(UsersDataBaseUtil.class);
    private static final String USERS_DB_PATH = "src/main/resources/UsersDataBase.properties";

    public static Account receiveAccFromProperties(String userName){
        Account account = new Account();
        Properties properties = receivePropertiesFromDB();
        account.setNickname(properties.getProperty(userName +".nickname"));
        if(account.getNickname()==null){
            return null;
        }
        account.setPassword(properties.getProperty(userName + ".password"));
        if(properties.getProperty(userName + ".admin").equals("true")){
            account.setAdmin(true);
        }else{
            account.setAdmin(false);
        }
        return account;
    }

    public static void saveAccToDB(Account account) {

        String nickName = account.getNickname();
        StringBuilder userAccount = new StringBuilder();
        userAccount.append(nickName).append(".nickname=").append(nickName).append("\n").
                append(nickName).append(".password=").append(account.getPassword()).append("\n").
                append(nickName).append(".admin=").append(account.isAdmin()).append("\n");

        saveToDB(userAccount.toString());
    }

    private static Properties receivePropertiesFromDB(){

        Properties property = new Properties();
        try(FileInputStream fis = new FileInputStream(USERS_DB_PATH)) {
            property.load(fis);
            return property;
        } catch (IOException exc) {
            LOGGER.warn(exc);
        }
        return null;
    }

    private static void saveToDB(String data){
        try(FileWriter saver = new FileWriter(USERS_DB_PATH, true)){
            saver.write(data);
        }catch (IOException exc){
            LOGGER.warn(exc);
        }
    }
}
