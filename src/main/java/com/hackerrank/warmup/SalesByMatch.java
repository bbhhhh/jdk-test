package com.hackerrank.warmup;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/1/24 19:50
 * @Description:
 * There is a large pile of socks that must be paired by color. Given an array of integers representing the color of each sock, determine how many pairs of
 * socks with matching colors there are.
 *
 * Example
 *
 *
 * There is one pair of color  and one of color . There are three odd socks left, one of each color. The number of pairs is .
 *
 * Function Description
 *
 * Complete the sockMerchant function in the editor below.
 *
 * sockMerchant has the following parameter(s):
 *
 * int n: the number of socks in the pile
 * int ar[n]: the colors of each sock
 * Returns
 *
 * int: the number of pairs
 * Input Format
 *
 * The first line contains an integer , the number of socks represented in .
 * The second line contains  space-separated integers, , the colors of the socks in the pile.
 *
 * Constraints
 *
 *  where
 * Sample Input
 *
 * STDIN                       Function
 * -----                       --------
 * 9                           n = 9
 * 10 20 20 10 10 30 50 10 20  ar = [10, 20, 20, 10, 10, 30, 50, 10, 20]
 * Sample Output
 *
 * 3
 */

public class SalesByMatch {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(SalesByMatch.class);

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        int pairs = 0;
        Map<Integer, Integer> arMap = new HashMap<>();
        for (int i = 0; i < ar.length; i++) {
            if (arMap.containsKey(ar[i])) {
                arMap.put(ar[i], arMap.get(ar[i]) + 1);
            } else {
                arMap.put(ar[i], 1);
            }
        }
        final int[] pa = new int[1];
//        for (Map.Entry<Integer, Integer> ent : arMap.entrySet()) {
//            pairs += ent.getValue() / 2;
//
//        }
        arMap.forEach((k, v) -> {
            pa[0] += v / 2;
        });
        pairs = pa[0];
        return pairs;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
