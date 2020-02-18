package org.javaexternal_shulzhenko.droidswar.utils;

import org.javaexternal_shulzhenko.droidswar.exceptions.NicknameIsUsedException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateInputDataUtilTest {


    @Test
    void validatingEnteredAppropriateNickname() throws NicknameIsUsedException {
        String nickName = "Nick";
        assertTrue(ValidateInputDataUtil.validateEnteredNickname(nickName));
    }

    @Test
    void validatingEnteredNicknameWithNotLetters() throws NicknameIsUsedException {
        String nickName = "Nif2";
        assertFalse(ValidateInputDataUtil.validateEnteredNickname(nickName));
    }

    @Test
    void validatingEnteredNicknameWithNoCapitalLetter() throws NicknameIsUsedException {
        String nickName = "nif";
        assertFalse(ValidateInputDataUtil.validateEnteredNickname(nickName));
    }

    @Test
    void validatingEnteredExistingNickname() {
        String nickName = "Lolik";
        assertThrows(NicknameIsUsedException.class, () -> ValidateInputDataUtil.validateEnteredNickname(nickName));
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