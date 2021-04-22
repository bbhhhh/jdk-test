package com.bhh.java.thirdpartytools;

import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/4/20 15:57
 * @Description: TODO
 */

public class PassayTester {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(PassayTester.class);

    public static void main(String[] args) {
        CharacterRule digits = new CharacterRule(EnglishCharacterData.Digit);
        //CharacterRule spec = new CharacterRule(EnglishCharacterData.Special);
        CharacterRule spec = new CharacterRule(new MySpec());
        CharacterRule alpha = new CharacterRule(EnglishCharacterData.Alphabetical);
        CharacterRule up = new CharacterRule(EnglishCharacterData.UpperCase);
        CharacterRule low = new CharacterRule(EnglishCharacterData.LowerCase);


        PasswordGenerator passwordGenerator = new PasswordGenerator();
        for (int i = 0; i < 20; i++) {
            logger.info(passwordGenerator.generatePassword(9, digits, spec, up, low));
        }

    }
}
