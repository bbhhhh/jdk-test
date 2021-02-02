package com.hackerrank.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/1/31 19:39
 * @Description:
 *                     1------------------>null
 *             /              \
 *           2---------------->3--------->null
 *        /    \           /      \
 *       4------>5------->6------->7---->null
 *     /\       /\       /\      /\
 *    8->9--->10->11-->12->13->14->15->null
 * Input:
 * first input line is the number of total nodes(leafs)
 * second input line is space separated digital value of each nodes(leafs),
 * the value order is from up to down, from left to right.
 * Output:
 * first you need to construct the btree from the input number and value.
 * second you need to assign the next value for each nodes(leafs).
 * for example of above tree, next of 1 is null, next of 2 is 3, next of 3 is null
 * next of 4 is 5, next of 5 is 6, next of 6 is 7, next of 7 is null, etc.
 * last you need to print out the value and next value for each nodes(leafs).
 *
 */

public class PerfectBTree {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(PerfectBTree.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNum = scanner.nextInt();
        int nodeNum = 0;
        while (nodeNum < inputNum) {
            nodeNum += nodeNum + 1;
        }
        if (nodeNum != inputNum) {
            System.err.println("input node number is wrong");
            System.exit(1);
        }
        int[] nodeVal = new int[nodeNum];
        for (int i = 0; i < nodeNum; i++) {
            nodeVal[i] = scanner.nextInt();
        }

        Node root = new Node();
        List<Node> toAssignNodeList = new ArrayList<>();
        toAssignNodeList.add(root);
        constructBTree(nodeVal, 0, toAssignNodeList);
        root = getCompletedNode(root);
        visitBTree(root);
    }

    public static void visitBTree(Node root) {
        if (root != null) {
            System.out.println("node val=" + root.val + ", next node val=" + (root.next == null ? "null" : root.next.val));
            visitBTree(root.left);
            visitBTree(root.right);
        }
    }

    public static void constructBTree(int[] nodeVal, int start, List<Node> toAssignNodeList) {
        boolean isLeafList = start + toAssignNodeList.size() == nodeVal.length;
        List<Node> nextAssignNodeList = null;
        if (!isLeafList) {
            nextAssignNodeList = new ArrayList<>();
        }
        for (int i = 0; i < toAssignNodeList.size(); i++) {
            toAssignNodeList.get(i).val = nodeVal[start + i];
            if (!isLeafList) {
                for (int j = 0; j < 2; j++) {
                    Node child = new Node();
                    if (j % 2 == 0) {
                        toAssignNodeList.get(i).left = child;
                    } else {
                        toAssignNodeList.get(i).right = child;
                    }
                    nextAssignNodeList.add(child);
                }
            }
        }

        if (!isLeafList) {
            constructBTree(nodeVal, start + toAssignNodeList.size(), nextAssignNodeList);
        }
    }

    public static Node getCompletedNode(Node root) {
        root.next = null;
        assignNext(root, root.left, root.right);
        return root;
    }

    public static void assignNext(Node parent, Node left, Node right) {
        if (left == null)
            return;

        left.next = right;
        if (parent.next == null) {
            right.next = null;
        } else {
            right.next = parent.next.left;
        }

        assignNext(left, left.left, left.right);
        assignNext(right, right.left, right.right);
    }

}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;
}
