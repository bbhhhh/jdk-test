package com.hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/2/5 13:17
 * @Description:
 *Sherlock considers a string to be valid if all characters of the string appear the same number of times. It is also valid if he can remove just 1 character
 * at 1 index in the string, and the remaining characters will occur the same number of times. Given a string , determine if it is valid. If so, return YES,
 * otherwise return NO.
 *
 * Example
 * s=abc
 * This is a valid string because frequencies are {a:1,b:1,c:1}.
 *
 * s=abcc
 * This is a valid string because we can remove one c and have 1 of each character in the remaining string.
 *
 * s=abccc
 * This string is not valid as we can only remove 1 occurrence of c. That leaves character frequencies of {a:1,b:1,c:2}.
 *
 * Function Description
 *
 * Complete the isValid function in the editor below.
 *
 * isValid has the following parameter(s):
 *
 * string s: a string
 * Returns
 *
 * string: either YES or NO
 * Input Format
 *
 * A single string s.
 *
 * Constraints
 * 1<=|s|<=10^5
 * Each character s[i]<=ascii[a-z]
 * Sample Input 0
 *
 * aabbcd
 * Sample Output 0
 *
 * NO

 * Sample Input 1
 *
 * aabbccddeefghi
 * Sample Output 1
 *
 * NO
 * Sample Input 2
 *
 * abcdefghhgfedecba
 * Sample Output 2
 *
 * YES
 */

public class SherlockAndTheValidString {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(SherlockAndTheValidString.class);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(isValid(sc.next()));

        sc.close();
    }

    // Complete the isValid function below.
    static String isValid(String s) {
        String result = "YES";
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char i = 'a'; i <= 'z'; i++) {
            charCountMap.put(i, 0);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charCountMap.put(c, charCountMap.get(c) + 1);
        }

        Map<Integer, Integer> countOfCountMap = new HashMap<>();

        int countOfChar = 0;
        for (Map.Entry<Character, Integer> ent : charCountMap.entrySet()) {
            countOfChar = ent.getValue();
            if (countOfChar != 0) {
                if (countOfCountMap.containsKey(countOfChar)) {
                    countOfCountMap.put(countOfChar, countOfCountMap.get(countOfChar) + 1);

                } else {
                    countOfCountMap.put(countOfChar, 1);
                }
                if (countOfCountMap.keySet().size() > 2) {
                    result = "NO";
                    return result;
                }
            }
        }

        int countOfKey = 0;
        int countOfVal = 0;
        for (Map.Entry<Integer, Integer> ent : countOfCountMap.entrySet()) {
            if (countOfKey == 0) {
                countOfKey = ent.getKey();
                countOfVal = ent.getValue();
            } else {
                if (countOfKey < ent.getKey()) {
                    if (countOfKey == 1 && countOfVal == 1) {
                        result = "YES";
                        return result;
                    }
                    if (countOfKey + 1 < ent.getKey()) {
                        result = "NO";
                        return result;
                    }
                    if (ent.getValue() != 1) {
                        result = "NO";
                        return result;
                    }
                } else {
                    if (ent.getKey() == 1 && ent.getValue() == 1) {
                        result = "YES";
                        return result;
                    }
                    if (countOfKey - 1 > ent.getKey()) {
                        result = "NO";
                        return result;
                    }
                    if (countOfVal != 1) {
                        result = "NO";
                        return result;
                    }
                }
            }
        }

        return result;
    }
}
