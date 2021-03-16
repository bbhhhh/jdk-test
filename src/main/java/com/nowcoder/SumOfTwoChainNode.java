package com.nowcoder;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/3/5 15:39
 * @Description: TODO
 */

public class SumOfTwoChainNode {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(SumOfTwoChainNode.class);

    public static void main(String[] args) {
        ListNode head1 = null, head2 = null;
        head1 = new ListNode(1);
        head1.next = new ListNode(0);
        head2 = new ListNode(1);
        ListNode sum = addInList(head1, head2);
    }

    public static ListNode addInList(ListNode head1, ListNode head2) {
        // write code here
        int sum;
        ListNode n = null, tmp = null;
        int tenBit = 0;
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;
        head1 = reverse(head1);
        head2 = reverse(head2);
        while (head1 != null && head2 != null) {
            sum = head1.val + head2.val + tenBit;
            head1.val = sum % 10;
            tmp = head1;
            head1 = head1.next;
            head2 = head2.next;
            tmp.next = n;
            n = tmp;
            tenBit = sum / 10;
        }
        while (head1 != null) {
            sum = head1.val + tenBit;
            head1.val = sum % 10;
            tmp = head1;
            head1 = head1.next;
            tmp.next = n;
            n = tmp;
            tenBit = sum / 10;
        }
        while (head2 != null) {
            sum = head2.val + tenBit;
            head2.val = sum % 10;
            tmp = head2;
            head2 = head2.next;
            tmp.next = n;
            n = tmp;
            tenBit = sum / 10;
        }
        if (tenBit > 0) {
            tmp = new ListNode(tenBit);
            tmp.next = n;
            n = tmp;
        }

        return n;
    }

    public static ListNode reverse(ListNode head) {
        if (head == null)
            return null;
        ListNode root = head;
        ListNode pre = head;
        ListNode tmp = head.next;
        while (tmp != null) {
            root = tmp;
            tmp = tmp.next;
            root.next = pre;
            if (pre == head)
                pre.next = null;

            pre = root;
        }

        return root;
    }

    static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int v) {
            val = v;
        }
    }

}
