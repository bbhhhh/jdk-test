package com.nowcoder;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/3/12 14:58
 * @Description:
 * 数独是一个我们都非常熟悉的经典游戏，运用计算机我们可以很快地解开数独难题，现在有一些简单的数独题目，请编写一个程序求解。
 * 如有多解，输出一个解
 *
 * 输入描述:
 * 输入9行，每行为空格隔开的9个数字，为0的地方就是需要填充的。
 *
 * 输出描述:
 * 输出九行，每行九个空格隔开的数字，为解出的答案。
 */

public class ShuDu {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ShuDu.class);

    private static final int LEN = 4;
    private static int[] num = new int[LEN];

    public static void main(String[] args) {
        int[][] rowArr = new int[LEN][LEN];
        int[][] colArr = new int[LEN][LEN];
        int k = 0;
        try (Scanner sc = new Scanner(System.in)) {
            for (int i = 0; i < rowArr.length; i++) {
                for (int j = 0; j < rowArr[i].length; j++) {
                    rowArr[i][j] = sc.nextInt();
                    if (rowArr[i][j] > 0 && k < LEN) {
                        if (!contains(num, rowArr[i][j]))
                            num[k++] = rowArr[i][j];
                    }
                }
            }

            for (int i = 0; i < colArr.length; i++) {
                for (int j = 0; j < colArr[i].length; j++)
                    colArr[i][j] = rowArr[j][i];
            }

            computeShudu(rowArr, colArr);
            for (int i = 0; i < rowArr.length; i++) {
                for (int j = 0; j < rowArr[i].length; j++) {
                    System.out.print(rowArr[i][j] + " ");
                }
                System.out.println();
            }

        }
    }

    public static boolean contains(int[] array, int n) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == n)
                return true;
        }
        return false;
    }

    public static boolean computeShudu(int[][] rowArr, int[][] colArr) {
        int[][] result;
        //result = Arrays.copyOf(rowArr, rowArr.length);
        //boolean hasZero = false;
        for (int i = 0; i < rowArr.length; i++) {
            for (int j = 0; j < rowArr[i].length; j++) {
                if (rowArr[i][j] == 0) {
                    //          hasZero = true;
                    for (int k = 0; k < num.length; k++) {
                        if (!contains(rowArr[i], num[k]) && !contains(colArr[j], num[k])) {
                            rowArr[i][j] = num[k];
                            colArr[j][i] = num[k];
                            if (computeShudu(rowArr, colArr))
                                return true;
                        }
                    }
                    return false;
                }
            }
        }

        return true;
    }
}
