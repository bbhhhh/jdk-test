package com.hackerrank.algorithm;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/3/17 16:40
 * @Description:
 * 5 3 4
 * 1 5 8
 * 6 4 2
 * convert to
 * 8 3 4
 * 1 5 9
 * 6 7 2
 * which sum of every row, column and diagonal must=15 and the matrix must has 9 distinct digit 1-9
 * compute the minimal replace cost
 *This took three replacements at a cost of |5-8|+|8-9|+|4-7|=7
 * 4 8 2
 * 4 5 7
 * 6 1 6
 * to
 * 4 9 2
 * 3 5 7
 * 8 1 6
 * cost =|8-9|+|3-4|+|6-8|=4
 * 4 5 8
 * 2 4 1
 * 1 9 7
 * to
 * 4 3 8
 * 9 5 1
 * 2 7 6
 * cost = |5-3|+|9-2|+|5-4|+|1-2|+|7-9|+|7-6|=14
 */

public class MagicSquare {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(MagicSquare.class);

    // Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[][] s) {
        int[] oriNum = new int[10];
        int[] dupNum = new int[4];
        int k = 0, cost = 0, i = 0, j = 0;

        return cost;
    }


    public static void main(String[] args) throws IOException {

        int[][] s = new int[3][3];

        try (Scanner scanner = new Scanner(System.in)) {
            for (int i = 0; i < 3; i++) {
                String[] sRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 3; j++) {
                    int sItem = Integer.parseInt(sRowItems[j]);
                    s[i][j] = sItem;
                }
            }
        }

        int result = formingMagicSquare(s);

        System.out.println(result);
    }

}
