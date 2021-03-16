package com.nowcoder;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/3/4 16:17
 * @Description: TODO
 */

public class LongestContinuousCommonSubString {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(LongestContinuousCommonSubString.class);

    public static void main(String[] args) {
        String s1 = "2LQ74WK8Ld0x7d8FP8l61pD7Wsz1E9xOMp920hM948eGjL9Kb5KJt80";
        String s2 = "U08U29zzuodz16CBZ8xfpmmn5SKD80smJbK83F2T37JRqYfE76vh6hrE451uFQ100ye9hog1Y52LDk0L52SuD948eGjLz0htzd5YF9J1Y6oI7562z4T2";
        logger.info("{}", LCS(s1, s2));
    }

    public static String LCS(String str1, String str2) {
        // write code here
        if (str1 == null || str2 == null)
            return null;

        int[][] matrix = new int[str1.length() + 1][str2.length() + 1];
        int max = 0;
        int maxi = 0;
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                    if (matrix[i][j] > max) {
                        max = matrix[i][j];
                        maxi = i;
                    }
                }
            }
        }
        return str1.substring(maxi - max, maxi);
    }
}
