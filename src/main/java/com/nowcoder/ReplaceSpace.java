package com.nowcoder;

import java.util.Objects;
import java.util.Scanner;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/2/26 11:11
 * @Description: TODO
 */

public class ReplaceSpace {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ReplaceSpace.class);

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String s = sc.nextLine();

            logger.info("{}", replaceAllSpace(s));
        }
    }

    public static String replaceAllSpace(String s) {
        Objects.requireNonNull(s);
        String s2 = "%20";
        return s.replace(" ", s2);
    }
}
