package com.nowcoder;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/3/23 15:58
 * @Description: TODO
 */

public class PrintMatrixInClockOrder {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(PrintMatrixInClockOrder.class);

    public static void main(String[] args) {
        int[][] matrix = {{1}, {4}, {7}};
        List<Integer> list = printMatrix(matrix);
        list.forEach(x -> System.out.println(x));
    }

    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return null;

        ArrayList<Integer> list = new ArrayList<>();
        int height = matrix.length;
        int width = matrix[0].length;
        int widStart = 0, widEnd = width - 1;
        int htStart = 0, htEnd = height - 1;
        int i = htStart, j = widStart;
        boolean changed = true;
        while (changed) {
            changed = false;
            // print left to right
            i = htStart;
            for (j = widStart; j <= widEnd; j++) {
                list.add(matrix[i][j]);
                changed = true;
            }
            if (!changed)
                break;
            htStart++;
            // print up to down
            j = widEnd;
            changed = false;
            for (i = htStart; i <= htEnd; i++) {
                list.add(matrix[i][j]);
                changed = true;
            }
            if (!changed)
                break;
            widEnd--;
            // print right to left
            i = htEnd;
            changed = false;
            for (j = widEnd; j >= widStart; j--) {
                list.add(matrix[i][j]);
                changed = true;
            }
            if (!changed)
                break;
            htEnd--;
            // print down to up
            j = widStart;
            changed = false;
            for (i = htEnd; i >= htStart; i--) {
                list.add(matrix[i][j]);
                changed = true;
            }
            if (!changed)
                break;
            widStart++;
        }
        return list;
    }
}
