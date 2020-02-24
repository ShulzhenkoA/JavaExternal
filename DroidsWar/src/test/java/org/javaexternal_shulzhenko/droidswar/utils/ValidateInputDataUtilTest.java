package org.javaexternal_shulzhenko.droidswar.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateInputDataUtilTest {


    @Test
    void validatingEnteredAppropriateNickname() {
        String nickName = "Nick";
        assertTrue(ValidateInputDataUtil.validateEnteredNickname(nickName));
    }

    @Test
    void validatingEnteredNicknameWithNotLetters(){
        String nickName = "Nif2";
        assertFalse(ValidateInputDataUtil.validateEnteredNickname(nickName));
    }

    @Test
    void validatingEnteredNicknameWithNoCapitalLetter() {
        String nickName = "nif";
        assertFalse(ValidateInputDataUtil.validateEnteredNickname(nickName));
    }

   @Test
    void validatingEnteredExistingNickname() {
        String nickName = "Lolik";
        assertFalse(ValidateInputDataUtil.validateEnteredNickname(nickName));
        //assertThrows(NicknameIsUsedException.class, () -> ValidateInputDataUtil.validateEnteredNickname(nickName));
    }

    @Test
    void validatingEnteredAppropriatePassword() {
        String password = "Pass3";
        assertTrue(ValidateInputDataUtil.validateEnteredPassword(password));
    }

    @Test
    void validatingEnteredInappropriatePassword() {
        String password = "12345";
        assertFalse(ValidateInputDataUtil.validateEnteredPassword(password));
    }
}