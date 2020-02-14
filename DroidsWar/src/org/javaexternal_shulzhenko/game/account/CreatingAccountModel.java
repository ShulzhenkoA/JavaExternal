package org.javaexternal_shulzhenko.game.account;

import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreatingAccountModel {

    private String nickName;

    public boolean setNickName(String nickName) {

        String pattern = "^(?=.*[a-z])(?=.*[A-Z])[A-Za-z]{3,8}$";

        if(dataValidator(pattern, nickName)){
            this.nickName = nickName;
            dataSaver(".nickname=" + nickName);
            return false;
        }
        return true;
    }

    public boolean setPassword(String password) {

        String pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{4,8}$";

        if(dataValidator(pattern, password)){
            dataSaver(".password=" + password);
            return false;
        }
        return true;
    }

    public void setAdmin(boolean admin) {
        dataSaver(".admin="+admin);
    }

    private void dataSaver(String data){
        try(FileWriter saver = new FileWriter("GameDataBase.properties", true)){
            saver.write(nickName + data);
            saver.append('\n');
        }catch (IOException e){
            System.out.println("Writing file error!");
        }
    }
    private boolean dataValidator(String pattern, String data){
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(data);
        System.out.println(m.matches());
        return m.matches();
    }

}
