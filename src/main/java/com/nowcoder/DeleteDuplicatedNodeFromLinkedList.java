package com.nowcoder;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/3/23 14:04
 * @Description: TODO
 */

public class DeleteDuplicatedNodeFromLinkedList {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(DeleteDuplicatedNodeFromLinkedList.class);

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        ListNode b = a.next;
        b.next = new ListNode(3);
        b = b.next;
        b.next = new ListNode(3);
        b = b.next;
        b.next = new ListNode(4);
        b = b.next;
        b.next = new ListNode(4);
        b = b.next;
        b.next = new ListNode(5);
        a = deleteDuplication(a);
        while (a != null) {
            System.out.print(a.val + " ");
            a = a.next;
        }
    }

    public static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null)
            return null;


        ListNode next = pHead.next;
        ListNode head = new ListNode(0);
        ListNode headCur = null;
        boolean isSame = false;
        while (next != null) {
            if (pHead.val == next.val) {
                isSame = true;
            } else {
                if (!isSame) {
                    if (head.next == null) {
                        head.next = pHead;
                        headCur = head;
                    }
                    headCur.next = pHead;
                    headCur = pHead;
                }
                isSame = false;
            }
            pHead = next;
            next = pHead.next;
        }
        if (head.next != null) {
            if (!isSame)
                headCur.next = pHead;
            else
                headCur.next = null;
        }
        if (!isSame && head.next == null)
            head.next = pHead;

        return head.next;
    }
}
