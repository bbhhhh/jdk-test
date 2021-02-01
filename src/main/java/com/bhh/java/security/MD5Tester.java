package com.bhh.java.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/1/29 14:27
 * @Description: TODO
 */

public class MD5Tester {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(MD5Tester.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        byte[] o;
        try {
            //MessageDigest md = MessageDigest.getInstance("MD5");
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(s.getBytes());
            o = md.digest();
            for (int i = 0; i < o.length; i++)
                System.out.printf("%02x", o[i]);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }
}
