package com.bhh.java.utils.pwdgen;

import java.io.IOException;
import java.nio.Buffer;
import java.nio.CharBuffer;
import java.security.SecureRandom;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.passay.CharacterRule;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/4/21 10:09
 * @Description: TODO
 */

public class PasswordGen {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(PasswordGen.class);

    private static final int PASSWORD_MAX_LENGTH = 64;

    private final Random random = new SecureRandom();


    public String generatePassword(final int pwdLength, final Set<PasswordCharacters> charactersSet) {
        if (pwdLength <= 0 || pwdLength > PASSWORD_MAX_LENGTH)
            throw new IllegalArgumentException("password length is invalid, must>0 and <=" + PASSWORD_MAX_LENGTH);

        if (charactersSet == null || charactersSet.size() == 0)
            throw new IllegalArgumentException("password characters set can't be empty");

        final StringBuilder allChars = new StringBuilder();

        final CharBuffer buffer = CharBuffer.allocate(pwdLength);
        for (PasswordCharacters pwdChars : charactersSet) {
            fillRandomCharacters(pwdChars.getCharacters(), 1, buffer);
            allChars.append(pwdChars.getCharacters());
        }
        fillRandomCharacters(allChars, pwdLength - buffer.position(), buffer);
        // cast to Buffer prevents NoSuchMethodError when compiled on JDK9+ and run on JDK8
        ((Buffer) buffer).flip();
        randomize(buffer);
        return buffer.toString();
    }

    /**
     * @Description // Fills the supplied target with count random characters from source.
     * @Author haihuab
     * @Date 2021/4/21 10:46
     * @Param source
     * @Param count
     * @Param target
     * @Return void
     **/

    protected void fillRandomCharacters(final CharSequence source, final int count, final Appendable target) {
        for (int i = 0; i < count; i++) {
            try {
                target.append(source.charAt(random.nextInt(source.length())));
            } catch (IOException e) {
                throw new RuntimeException("Error appending characters.", e);
            }
        }
    }


    /**
     * @Description //Randomizes the contents of the given buffer.
     * @Author haihuab
     * @Date 2021/4/21 10:46
     * @Param buffer
     * @Return void
     **/

    protected void randomize(final CharBuffer buffer) {
        char c;
        int n;
        for (int i = buffer.position(); i < buffer.limit(); i++) {
            n = random.nextInt(buffer.length());
            c = buffer.get(n);
            buffer.put(n, buffer.get(i));
            buffer.put(i, c);
        }
    }


    public static void main(String[] args) {
        PasswordGen gen = new PasswordGen();
        Set<PasswordCharacters> set = new HashSet<>();
        set.add(PasswordCharacters.LowerCase);
        set.add(PasswordCharacters.UpperCase);
        set.add(PasswordCharacters.Digit);
        set.add(PasswordCharacters.Special);

        for (int j = 0; j < 10; j++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 20; i++)
                        logger.info(gen.generatePassword(9, set));
                }
            }).start();
        }

    }
}
