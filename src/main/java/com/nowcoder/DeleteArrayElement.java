package com.nowcoder;

import java.util.Scanner;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/3/12 9:58
 * @Description:
 * 有一个数组a[N]顺序存放0~N-1，要求每隔两个数删掉一个数，到末尾时循环至开头继续进行，
 * 求最后一个被删掉的数的原始下标位置。
 * 以8个数(N=8)为例:｛0，1，2，3，4，5，6，7｝，
 * 0->1->2(删除)->3->4->5(删除)->6->7->0(删除),
 * >1->3-4(删)->6->7-1(删)->3-6-7(删)3-6>3(删)
 * >6(删)
 * 如此循环直到最后一个数被删除。
 *
 * 输入描述:
 * 每组数据为一行一个整数n(小于等于999)，为数组成员数,如果大于999，则对a[999]进行计算。
 *
 * 输出描述:
 * 一行输出最后一个被删掉的数的原始下标位置。
 *
 * 输入例子1:
 * 8
 *
 * 输出例子1:
 * 0
 */

public class DeleteArrayElement {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(DeleteArrayElement.class);

    public static void main(String[] args) {

        int arrayLen;
        try (Scanner sc = new Scanner(System.in)) {

            while (sc.hasNext()) {
                arrayLen = sc.nextInt();
                if (arrayLen > 1000)
                    arrayLen = 999;
                if (arrayLen < 0)
                    arrayLen = 0;

                ListNode tmp = new ListNode(-1);
                ListNode root = tmp;
                for (int i = 0; i < arrayLen; i++) {
                    ListNode n = new ListNode(i);
                    tmp.next = n;
                    tmp = n;
                }
                tmp.next = root.next;

                System.out.println(indexOfElementLastDeleted(root));
            }
        }
    }

    static class ListNode {
        int idx;
        ListNode next;

        public ListNode(int n) {
            idx = n;
        }
    }

    public static int indexOfElementLastDeleted(ListNode root) {
        if (root == null || root.next == null)
            return 0;

        ListNode pre;

        do {
            pre = root.next.next;
            root = pre.next;

            pre.next = root.next;
        } while (pre.next != pre);


        return pre.idx;
    }
}
