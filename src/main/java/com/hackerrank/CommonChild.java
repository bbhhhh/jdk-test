package com.hackerrank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/2/5 15:13
 * @Description:
 * A string is said to be a child of a another string if it can be formed by deleting 0 or more characters from the other string. Given two strings of equal
 * length, what's the longest string that can be constructed such that it is a child of both?
 *
 * For example, ABCD and ABDC have two children with maximum length 3, ABC and ABD. They can be formed by eliminating either the D or C from both strings.
 * Note that we will not consider ABCD as a common child because we can't rearrange characters and ABCD != ABDC.
 *
 * Function Description
 *
 * Complete the commonChild function in the editor below. It should return the longest string which is a common child of the input strings.
 *
 * commonChild has the following parameter(s):
 *
 * s1, s2: two equal length strings
 * Input Format
 *
 * There is one line with two space-separated strings, s1 and s2.
 *
 * Constraints
 * 1<=|s1|,|s2|<=5000
 * All characters are upper case in the range ascii[A-Z].
 * Output Format
 *
 * Print the length of the longest string s, such that s is a child of both s1 and s2.
 *
 * Sample Input
 *
 * HARRY
 * SALLY
 * Sample Output
 *
 *  2
 * Explanation
 *
 * The longest string that can be formed by deleting zero or more characters from HARRY and SALLY is AY, whose length is 2.
 *
 * Sample Input 1
 *
 * AA
 * BB
 * Sample Output 1
 *
 * 0
 * Explanation 1
 *
 * AA and BB have no characters in common and hence the output is 0.
 *
 * Sample Input 2
 *
 * SHINCHAN
 * NOHARAAA
 * Sample Output 2
 *
 * 3
 * Explanation 2
 *
 * The longest string that can be formed between SHINCHAN and NOHARAAA while maintaining the order is NHA.
 *
 * Sample Input 3
 *
 * ABCDEF
 * FBDAMN
 * Sample Output 3
 *
 * 2
 * Explanation 3
 * BD is the longest child of the given strings.
 *
 * Solution: https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
 * s1: MZJAWXU
 * s2: XMJYAUZ
 *   # M Z J A W X U
 * # 0 0 0 0 0 0 0 0
 * X 0 0 0 0 0 0 1 1
 * M 0 1 1 1 1 1 1 1
 * J 0 1 1 2 2 2 2 2
 * Y 0 1 1 2 2 2 2 2
 * A 0 1 1 2 3 3 3 3
 * U v 1 1 2 3 3 3 4
 * Z 0 1 2 2 3 3 3 4
 * = MJAU
 *
 * s1:ABHDEFFG
 * s2:ABDFHHHG
 *   # A B H D E F F G
 * # 0 0 0 0 0 0 0 0 0
 * A 0 1 1 1 1 1 1 1 1
 * B 0 1 2 2 2 2 2 2 2
 * D 0 1 2 2 3 3 3 3 3
 * F 0 1 2 2 3 3 4 4 4
 * H 0 1 2 3 3 3 4 4 4
 * H 0 1 2 3 3 3 4 4 4
 * H 0 1 2 3 3 3 4 4 4
 * G 0 1 2 3 3 3 4 4 5
 * =ABDFG
 *
 * s1: ADAGA
 * s2: ABCAE
 *   # A D A G A
 * # 0 0 0 0 0 0
 * A 0 1 1 1 1 1
 * B 0 1 1 1 1 1
 * C 0 1 1 1 1 1
 * A 0 1 1 2 2 2
 * E 0 1 1 2 2 2
 **/


public class CommonChild {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(CommonChild.class);

    // Complete the commonChild function below.
    static int commonChild(String s1, String s2) {
        int len = s1.length();
        if (s1.equals(s2))
            return len;

        //len = 0;
        int[][] matrix = new int[len + 1][len + 1];
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= len; j++) {
                if (s2.charAt(i - 1) == s1.charAt(j - 1)) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                } else {
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int preLen = 0;
        int prePath = 0;
        for (int i = 1; i < len + 1; i++) {
            for (int j = 1; j < len + 1; j++) {
                //System.out.print(matrix[i][j] + " ");
                if (matrix[i][j] > preLen) {
                    sb.append(s2.charAt(i - 1));
                    preLen = matrix[i][j];
                    prePath = i * j;
                } else if (matrix[i][j] == preLen && preLen != 0) {
                    if (i * j < prePath) {
                        sb.deleteCharAt(sb.length() - 1);
                        sb.append(s2.charAt(i - 1));
                        preLen = matrix[i][j];
                        prePath = i * j;
                    }
                }
            }
            //System.out.println();
        }

        //System.out.println(sb.toString());

        return matrix[len][len];

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.next();
        String s2 = sc.next();

        System.out.println(commonChild(s1, s2));

        sc.close();
    }
}
