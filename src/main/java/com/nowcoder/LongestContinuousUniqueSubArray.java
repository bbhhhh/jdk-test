package com.nowcoder;

import java.util.HashMap;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/3/8 10:26
 * @Description: TODO
 */

public class LongestContinuousUniqueSubArray {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(LongestContinuousUniqueSubArray.class);

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 1, 3};
        logger.info("{}", maxLength(arr));
    }

    public static int maxLength(int[] arr) {
        int maxLen = 0;
        if (arr == null)
            return maxLen;
        if (arr.length <= 1)
            return arr.length;

        int len = 0, delStart = 0, i = 0;
        int[] lastPos = new int[100001];
        for (i = 0; i < arr.length; i++) {
            if (lastPos[arr[i]] == 0) {
                lastPos[arr[i]] = i + 1;
            } else {
                if (lastPos[arr[i]] > delStart) {
                    len = i - delStart;
                    if (len > maxLen)
                        maxLen = len;

                    delStart = lastPos[arr[i]];
                }
                lastPos[arr[i]] = i + 1;
            }
        }
        len = i - delStart;
        if (len > maxLen)
            maxLen = len;

        if (maxLen == 1)
            maxLen = 0;

        return maxLen;
    }

}
