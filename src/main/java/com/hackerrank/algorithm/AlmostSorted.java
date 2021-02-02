package com.hackerrank.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/2/1 14:27
 * @Description:
 * Given an array of integers, determine whether the array can be sorted in ascending order using only one of the following operations one time.
 *
 * Swap two elements.
 * Reverse one sub-segment.
 * Determine whether one, both or neither of the operations will complete the task. Output is as follows.
 *
 * If the array is already sorted, output yes on the first line. You do not need to output anything else.
 *
 * If you can sort this array using one single operation (from the two permitted operations) then output yes on the first line and then:
 *
 * If elements can only be swapped,  and , output swap l r in the second line.  and  are the indices of the elements to be swapped, assuming that the array
 * is indexed from  to .
 * If elements can only be reversed, for the segment , output reverse l r in the second line.  and  are the indices of the first and last elements of the
 * subarray to be reversed, assuming that the array is indexed from  to . Here  represents the subarray that begins at index  and ends at index , both
 * inclusive.
 * If an array can be sorted both ways, by using either swap or reverse, choose swap.
 *
 * If the array cannot be sorted either way, output no on the first line.
 * Example
 *arr = [2,3,5,4]
 * Either swap the 4 and 5, or reverse them to sort the array. As mentioned above, swap is preferred over reverse. Choose swap. On the first line, print yes.
 * On the second line, print swap 3 4.
 *
 * Function Description
 *
 * Complete the almostSorted function in the editor below. It should print the results and return nothing.
 *
 * almostSorted has the following parameter(s):
 *
 * int arr[n]: an array of integers
 * Prints
 *
 * -
 * Input Format
 *
 * The first line contains a single integer n, the size of arr.
 * The next line contains n space-separated integers arr[i] where 1<=i<=n.
 *
 * Constraints
 *2<=n<=100000
 *0<=arr[i]<=1000000
 *
 * All arr[i] are distinct.
 *
 * Output Format
 *
 * If the array is already sorted, output yes on the first line. You do not need to output anything else.
 *
 * If you can sort this array using one single operation (from the two permitted operations) then output yes on the first line and then:
 *
 * a. If elements can be swapped, d[l] and d[r], output swap l r in the second line.  and  are the indices of the elements to be swapped, assuming that the
 * array is
 * indexed from 1 to n.
 *
 * b. Otherwise, when reversing the segment d[l...r], output reverse l r in the second line. l and r are the indices of the first and last elements of the
 * subsequence
 * to be reversed, assuming that the array is indexed from 1 to n.
 *
 * d[l...r] represents the sub-sequence of the array, beginning at index l and ending at index r, both inclusive.
 *
 * If an array can be sorted by either swapping or reversing, choose swap.
 *
 * If you cannot sort the array either way, output no on the first line.
 * Sample Input 1
 *
 * 2
 * 4 2
 * Sample Output 1
 *
 * yes
 * swap 1 2
 * Explanation 1
 *
 * You can either swap(1, 2) or reverse(1, 2). You prefer swap.
 *
 * Sample Input 2
 *
 * 3
 * 3 1 2
 * Sample Output 2
 *
 * no
 * Explanation 2
 *
 * It is impossible to sort by one single operation.
 *
 * Sample Input 3
 *
 * 6
 * 1 5 4 3 2 6
 * Sample Output 3
 *
 * yes
 * reverse 2 5
 * Explanation 3
 *
 * You can reverse the sub-array d[2...5] = "5 4 3 2", then the array becomes sorted.
 *
 * Sample Input 4
 *
 * 3
 * 3 2 1
 * Sample Output 1
 *
 * yes
 * swap 1 3
 * Explanation 1
 *
 * You can either swap(1, 3) .
 */

public class AlmostSorted {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(AlmostSorted.class);

    /**
     * @Description //归并排序算法
     * 归并排序（Merge）是将两个（或两个以上）有序表合并成一个新的有序表，即把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列。
     *
     * 归并排序是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。 将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为2-路归并。
     *
     * 归并排序算法稳定，数组需要O(n)的额外空间，链表需要O(log(n))的额外空间，时间复杂度为O(nlog(n))，算法不是自适应的，不需要对数据的随机读取。
     *
     * 工作原理：
     *
     * 1、申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列
     *
     * 2、设定两个指针，最初位置分别为两个已经排序序列的起始位置
     *
     * 3、比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置
     *
     * 4、重复步骤3直到某一指针达到序列尾
     *
     * 5、将另一序列剩下的所有元素直接复制到合并序列尾
     * @Author haihuab
     * @Date 2021/2/2 10:40
     * @Param data
     * @Param left
     * @Param right
     * @Return void
     **/

    public static void sort(int[] data, int left, int right) {
        if (left >= right)
            return;
        // 找出中间索引
        int center = (left + right) / 2;
        // 对左边数组进行递归
        sort(data, left, center);
        // 对右边数组进行递归
        sort(data, center + 1, right);
        // 合并
        merge(data, left, center, right);
        //print(data);
    }

    /**
     * 将两个数组进行归并，归并前面2个数组已有序，归并后依然有序
     *
     * @param data
     *            数组对象
     * @param left
     *            左数组的第一个元素的索引
     * @param center
     *            左数组的最后一个元素的索引，center+1是右数组第一个元素的索引
     * @param right
     *            右数组最后一个元素的索引
     */
    public static void merge(int[] data, int left, int center, int right) {
        // 临时数组
        int[] tmpArr = new int[data.length];
        // 右数组第一个元素索引
        int mid = center + 1;
        // third 记录临时数组的索引
        int third = left;
        // 缓存左数组第一个元素的索引
        int tmp = left;
        while (left <= center && mid <= right) {
            // 从两个数组中取出最小的放入临时数组
            if (data[left] <= data[mid]) {
                tmpArr[third++] = data[left++];
            } else {
                tmpArr[third++] = data[mid++];
            }
        }
        // 剩余部分依次放入临时数组（实际上两个while只会执行其中一个）
        while (mid <= right) {
            tmpArr[third++] = data[mid++];
        }
        while (left <= center) {
            tmpArr[third++] = data[left++];
        }
        // 将临时数组中的内容拷贝回原数组中
        // （原left-right范围的内容被复制回原数组）
        while (tmp <= right) {
            data[tmp] = tmpArr[tmp++];
        }
    }


    // Complete the almostSorted function below.
    static void almostSorted(int[] arr) {
        int[] arrCopy = Arrays.copyOf(arr, arr.length);
        sort(arr, 0, arr.length - 1);

        // sort the array first
//        for (int i = 0; i < arr.length - 1; i++) {
//            swapFlag = false;
//            for (int j = 0; j < arr.length - i - 1; j++) {
//                if (arr[j] > arr[j + 1]) {
//                    temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
//                    swapFlag = true;
//                    arrIsSorted = false;
//                }
//            }
//            if (!swapFlag) {
//                break;
//            }
//        }


        // compute whether can sort the array by reverse the sub array only once.
        // or whether can sort the array by swap 2 elements only once.

        int reverseStart = -1;
        int reverseEnd = -1;
        int diffCount = 0;
        for (int i = 0; i < arrCopy.length; i++) {
            if (arr[i] != arrCopy[i]) {
                if (reverseStart == -1) {
                    reverseStart = i;
                }
                reverseEnd = i;
                diffCount++;
            }
        }
        if (diffCount == 0) {
            System.out.println("yes");
            return;
        }

        if (diffCount == 2) {
            System.out.println("yes");
            System.out.println("swap " + (reverseStart + 1) + " " + (reverseEnd + 1));
            return;
        }
        for (int i = reverseStart, j = reverseEnd; i <= j; i++, j--) {
            if (arr[i] != arrCopy[j]) {
                System.out.println("no");
                return;
            }
        }

        System.out.println("yes");
        System.out.println("reverse " + (reverseStart + 1) + " " + (reverseEnd + 1));

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            arr[i] = arrItem;
        }

        almostSorted(arr);

        scanner.close();
    }
}
