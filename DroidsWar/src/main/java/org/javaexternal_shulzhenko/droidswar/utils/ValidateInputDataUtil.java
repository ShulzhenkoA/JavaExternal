package org.javaexternal_shulzhenko.droidswar.utils;

import org.javaexternal_shulzhenko.droidswar.exceptions.NicknameIsUsedException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateInputDataUtil {

    private static final String NICKNAME_REGEX = "^(?=.*[a-z])(?=.*[A-Z])[A-Za-z]{3,8}$";
    private static final String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{4,8}$";

    public static boolean validateEnteredNickname(String nickname) throws NicknameIsUsedException {

        if(UsersDataBaseUtil.receiveUsersDataFromDB(nickname, UsersDataBaseUtil.NICKNAME_RECEIVE_SNIPPET) != null){
            throw new NicknameIsUsedException();
        }
        return validateInputData(nickname, NICKNAME_REGEX);
    }

    public static boolean validateEnteredPassword(String password){
        return validateInputData(password, PASSWORD_REGEX);
    }

    private static boolean validateInputData(String data, String pattern){
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(data);
        return m.matches();
    }
}
