package com.hackerrank.algorithm;

import java.util.Scanner;

import org.w3c.dom.css.ElementCSSInlineStyle;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/3/19 10:02
 * @Description:
 * Alice is a kindergarten teacher. She wants to give some candies to the children in her class.
 * All the children sit in a line and each of them has a rating score
 * according to his or her performance in the class.
 * Alice wants to give at least 1 candy to each child.
 * If two children sit next to each other, then the one with the higher rating must get more candies.
 * Alice wants to minimize the total number of candies she must buy.
 *Sample Input 0
 *
 * 3
 * 1
 * 2
 * 2
 * Sample Output 0
 *
 * 4
 * Explanation 0
 * * Here 1, 2, 2 is the rating. Note that when two children have equal rating,
 * they are allowed to have different number of candies. Hence optimal
 * distribution will be 1, 2, 1.
 *
 * Sample Input 1
 *
 * 10
 * 2
 * 4
 * 2
 * 6
 * 1
 * 7
 * 8
 * 9
 * 2
 * 1
 * Sample Output 1
 *
 * 19
 * Explanation 1
 *
 * Optimal distribution will be 1,2,1,2,1,2,3,4,2,1
 */

public class Candies {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(Candies.class);

    // Complete the candies function below.
    static long candies(int n, int[] arr) {
        if (1 == n)
            return 1;

        if (2 == n) {
            if (arr[0] == arr[1])
                return 2;
            else
                return 3;
        }
        int[] candy = new int[n];

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (arr[i] <= arr[i + 1]) {
                    candy[i] = 1;
                }
            } else {
                if (arr[i] > arr[i - 1]) {
                    if (candy[i - 1] > 0)
                        candy[i] = candy[i - 1] + 1;
                    else {
                        candy[i - 1] = 1;
                        candy[i] = 2;
                    }

                } else if (arr[i] == arr[i - 1]) {
                    candy[i] = 1;
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) {
                if (arr[i] <= arr[i - 1]) {
                    candy[i] = 1;
                }
            } else {
                if (arr[i] > arr[i + 1]) {
                    if (candy[i + 1] > 0)
                        candy[i] = Math.max(candy[i + 1] + 1, candy[i]);
                    else {
                        candy[i + 1] = 1;
                        candy[i] = 2;
                    }
                } else if (arr[i] == arr[i + 1]) {
                    candy[i] = Math.max(1, candy[i]);
                }
            }
        }


        int minIdx = 0, min = 0, max = 0;

        min = 0;
        for (int can : candy) {
            System.out.print(can + " ");
            min += can;
        }

        return min;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                int arrItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                arr[i] = arrItem;
            }

            long result = candies(n, arr);
            System.out.println(result);
        }
    }

}
