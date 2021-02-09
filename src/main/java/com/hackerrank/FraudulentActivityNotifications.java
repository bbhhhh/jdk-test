package com.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/2/4 16:28
 * @Description:
 *HackerLand National Bank has a simple policy for warning clients about possible fraudulent account activity. If the amount spent by a client on a
 * particular day is greater than or equal to 2x the client's median spending for a trailing number of days, they send the client a notification about
 * potential fraud. The bank doesn't send the client any notifications until they have at least that trailing number of prior days' transaction data.
 *
 * Given the number of trailing days d and a client's total daily expenditures for a period of n days, find and print the number of times the client will
 * receive a notification over all n days.
 *
 * For example, d=3 and expenditures=[10,20,30,40,50]. On the first three days, they just collect spending data. At day 4, we have trailing expenditures of
 * [10,20,30].
 * The median is 20 and the day's expenditure is 40. Because 40>=20x2, there will be a notice. The next day, our trailing expenditures are [20,30,40] and the
 * expenditures are 50. This is less than 2x30 so no notice will be sent. Over the period, there was one notice sent.
 *
 * Note: The median of a list of numbers can be found by arranging all the numbers from smallest to greatest. If there is an odd number of numbers, the
 * middle one is picked. If there is an even number of numbers, median is then defined to be the average of the two middle values. (Wikipedia)
 *
 * Function Description
 *
 * Complete the function activityNotifications in the editor below. It must return an integer representing the number of client notifications.
 *
 * activityNotifications has the following parameter(s):
 *
 * expenditure: an array of integers representing daily expenditures
 * d: an integer, the lookback days for median spending
 * Input Format
 *
 * The first line contains two space-separated integers n and d, the number of days of transaction data, and the number of trailing days' data used to
 * calculate median spending.
 * The second line contains n space-separated non-negative integers where each integer i denotes expenditure[i].
 *
 * Constraints
 * 1<=n<=2x10^5
 * 1<=d<=n
 * 0<=expenditure[i]<=200
 * Output Format
 *
 * Print an integer denoting the total number of times the client receives a notification over a period of n days.
 *
 * Sample Input 0
 *
 * 9 5
 * 2 3 4 2 3 6 8 4 5
 * Sample Output 0
 *
 * 2
 *
 * Sample Input 1
 *
 * 5 4
 * 1 2 3 4 4
 * Sample Output 1
 *
 * 0
 */

public class FraudulentActivityNotifications {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(FraudulentActivityNotifications.class);

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        int result = 0;
        int k = d / 2;
        int[] valCountArr = new int[201];

        for (int i = 0; i < d; i++) {
            valCountArr[expenditure[i]]++;
        }

        for (int i = d; i < expenditure.length; i++) {
            if (expenditure[i] >= 2 * getMedian(valCountArr, d)) {
                result++;
            }
            valCountArr[expenditure[i - d]]--;
            valCountArr[expenditure[i]]++;
        }


        return result;
    }

    static double getMedian(int[] valCountArr, int len) {
        int count = 0;
        int k = len / 2;
        //System.out.println("k=" + k);
        int t1 = -1, t2 = -1;
        double median = 0;
        for (int i = 0; i < valCountArr.length; i++) {
            count += valCountArr[i];
            if (len % 2 == 0) {
                if (t1 == -1 && count >= k) {
                    t1 = i;
                }
                if (t2 == -1 && count >= (k + 1)) {
                    t2 = i;
                    median = (t1 + t2) / 2.0;
                    break;
                }
            } else {
                if (count > k) {
                    median = i;
                    break;
                }
            }
        }
        //System.out.println("m=" + median);
        return median;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int d = sc.nextInt();
        int[] expenditure = new int[num];
        for (int i = 0; i < num; i++) {
            expenditure[i] = sc.nextInt();
        }
        int result = activityNotifications(expenditure, d);

        System.out.println(result);
        sc.close();
    }
}
