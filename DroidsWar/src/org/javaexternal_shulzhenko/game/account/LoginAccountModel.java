package org.javaexternal_shulzhenko.game.account;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoginAccountModel {
    private String nickName;
    private String password;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void verifyUser() {
        FileInputStream fis;
        Properties property = new Properties();

        try {
            fis = new FileInputStream("GameDataBase.properties");
            property.load(fis);

            String nicknameFromDB = property.getProperty(nickName + ".nickname");
            String passwordFromDB = property.getProperty(nickName +".password");

            System.out.println(nicknameFromDB +"\n"+ passwordFromDB);

        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }
    }

    public static void main(String[] args) {
        LoginAccountModel ac = new LoginAccountModel();
        ac.setNickName("Lolik");
        ac.verifyUser();
    }
}
