package com.nowcoder;

import java.util.LinkedList;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/3/2 9:38
 * @Description: TODO
 */

public class ReverseKGroup {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ReverseKGroup.class);

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        ListNode tmp = head;

        ListNode reverse = reverseKGroup(head, 2);
        while (reverse != null) {
            logger.info("{}", reverse.val);
            reverse = reverse.next;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1)
            return head;

        ListNode root = new ListNode(-1);
        ListNode tmp = root;
        int count = 0;
        ListNode[] nodeList = new ListNode[k];
        while (head != null) {
            nodeList[count] = head;
            head = head.next;
            count++;
            if (k == count) {
                for (int j = nodeList.length - 1; j >= 0; j--) {
                    tmp.next = nodeList[j];
                    tmp = tmp.next;
                }
                tmp.next = null;
                count = 0;
            }
        }
        for (int j = 0; j < count; j++) {
            tmp.next = nodeList[j];
            tmp = tmp.next;
        }

        return root.next;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int v) {
        this.val = v;
    }
}