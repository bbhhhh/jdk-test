package com.hackerrank.warmup;

import java.util.Scanner;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/1/26 11:25
 * @Description:
 * input word and compress length k, remove continous k same chacter from the word in recursive
 * example:
 * abbcd 2
 * output: acd
 * abbccdeeddffdghhgijgk 2
 * output: aijgk
 */

public class WordCompress {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(WordCompress.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int k = scanner.nextInt();
        System.out.println("s=" + s + ",k=" + k);

        System.out.println(compress(s, k));
        scanner.close();
    }

    static String compress(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        if (s.length() < k || k <= 0) {
            return s;
        }
        if (k == 1) {
            return "";
        }

        boolean recursiveFlag = false;
        boolean deteleCharFlag = false;
        for (int i = 0; i < s.length(); i++) {
            String s1 = s.substring(i, i + 1);
            if (sb.length() > 0) {
                if (s1.equals(sb.substring(sb.length() - 1, sb.length()))) {
                    count++;
                } else {
                    if (deteleCharFlag) {
                        sb.delete(sb.length() - count, sb.length());
                        deteleCharFlag = false;
                    }
                    count = 1;
                }
                sb.append(s1);

                if (count >= k) {
                    recursiveFlag = true;
                    deteleCharFlag = true;
                }
            } else {
                sb.append(s1);
            }
        }
        System.out.println("flag=" + recursiveFlag + ",s=" + sb.toString());

        if (recursiveFlag) {
            return compress(sb.toString(), k);
        } else {
            return sb.toString();
        }
    }
}
