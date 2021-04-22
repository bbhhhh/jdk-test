package com.bhh.java.utils.pwdgen;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/4/21 10:02
 * @Description: TODO
 */
public enum PasswordCharacters {
    // Special characters
    Special("!@#$%"),

    /** Lower case characters. */
    LowerCase("abcdefghijklmnopqrstuvwxyz"),

    /** Upper case characters. */
    UpperCase("ABCDEFGHIJKLMNOPQRSTUVWXYZ"),

    /** Digit characters. */
    Digit("0123456789");

    private final String characters;

    PasswordCharacters(final String chars) {
        characters = chars;
    }

    public String getCharacters() {
        return characters;
    }
}
