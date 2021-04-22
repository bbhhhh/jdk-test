package com.bhh.java.thirdpartytools;

import org.passay.CharacterData;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/4/20 16:12
 * @Description: TODO
 */

public class MySpec implements CharacterData {
    /** Error code. */
    private final String errorCode = "CustomSpecialCharacterData";

    /** Characters. */
    private final String characters = "!@#$%";


    @Override
    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public String getCharacters() {
        return characters;
    }
}
