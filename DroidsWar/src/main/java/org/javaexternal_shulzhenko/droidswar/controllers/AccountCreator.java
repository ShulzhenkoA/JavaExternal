package org.javaexternal_shulzhenko.droidswar.controllers;

import org.javaexternal_shulzhenko.droidswar.console.ConsoleView;
import org.javaexternal_shulzhenko.droidswar.exceptions.NicknameIsUsedException;
import org.javaexternal_shulzhenko.droidswar.utils.DataBaseConnectingUtil;
import org.javaexternal_shulzhenko.droidswar.utils.ValidateInputDataUtil;

public class AccountCreator {

    private String nickname;

    ConsoleView consoleView;

    public AccountCreator(ConsoleView consoleView){
        this.consoleView = consoleView;
    }

    public boolean createNickName(String nickname){

        try {
            if((ValidateInputDataUtil.validateEnteredNickname(nickname))){
                this.nickname = nickname;
                DataBaseConnectingUtil.saveUserNickname(nickname);
                return false;
            }
        } catch (NicknameIsUsedException e) {
            consoleView.printInvalidNickname();
        }

        return true;
    }

    public boolean createPassword(String password) {

        if(ValidateInputDataUtil.validateEnteredPassword(password)){
            DataBaseConnectingUtil.saveUserPassword(nickname, password);
                        return false;
        }
        consoleView.printInvalidPassword();
        return true;
    }

    public void createAsAdmin(boolean asAdmin) {
        DataBaseConnectingUtil.saveUserAdminStatus(nickname, asAdmin);
    }
}
