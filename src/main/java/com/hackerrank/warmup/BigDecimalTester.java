package com.hackerrank.warmup;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/1/25 20:02
 * @Description:
 * Java's BigDecimal class can handle arbitrary-precision signed decimal numbers. Let's test your knowledge of them!
 *
 * Given an array, , of  real number strings, sort them in descending order — but wait, there's more! Each number must be printed in the exact same format as
 * it was read from stdin, meaning that  is printed as , and  is printed as . If two numbers represent numerically equivalent values (e.g., ), then they must
 * be listed in the same order as they were received as input).
 *
 * Complete the code in the unlocked section of the editor below. You must rearrange array 's elements according to the instructions above.
 *
 * Input Format
 *
 * The first line consists of a single integer, , denoting the number of integer strings.
 * Each line  of the  subsequent lines contains a real number denoting the value of .
 *
 * Constraints
 *
 * Each  has at most  digits.
 * Output Format
 *
 * Locked stub code in the editor will print the contents of array  to stdout. You are only responsible for reordering the array's elements.
 *
 * Sample Input
 *
 * 9
 * -100
 * 50
 * 0
 * 56.6
 * 90
 * 0.12
 * .12
 * 02.34
 * 000.000
 * Sample Output
 *
 * 90
 * 56.6
 * 50
 * 02.34
 * 0.12
 * .12
 * 0
 * 000.000
 * -100
 */

public class BigDecimalTester {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(BigDecimalTester.class);

    public static void main(String[] args) {
        //Input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[n + 2];
        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
        }
        sc.close();

        //Write your code here
        BigDecimal[] bigDecimals = new BigDecimal[n];
        for (int i = 0; i < n; i++) {
            bigDecimals[i] = new BigDecimal(s[i]);
            //System.out.println(bigDecimals[i]);
        }

        BigDecimal temp;
        String ts;

        for (int i = 0; i < n - 1; i++) {//冒泡趟数，n-1趟
            for (int j = 0; j < n - i - 1; j++) {
                if (bigDecimals[j + 1].compareTo(bigDecimals[j]) > 0) {
                    temp = bigDecimals[j];
                    ts = s[j];
                    bigDecimals[j] = bigDecimals[j + 1];
                    s[j] = s[j + 1];
                    bigDecimals[j + 1] = temp;
                    s[j + 1] = ts;

                }
            }
        }
//        for (BigDecimal b : bigDecimals) {
//            System.out.println(b);
//        }
        //Output
        for (int i = 0; i < n; i++) {
            System.out.println(s[i]);
        }
    }
}
