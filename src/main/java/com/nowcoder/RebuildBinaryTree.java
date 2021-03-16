package com.nowcoder;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/3/3 10:45
 * @Description:
 * 题目描述
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * 示例1
 * 输入
 * [1,2,3,4,5,6,7],[3,2,4,1,6,5,7]
 * 返回值
 * {1,2,5,3,4,6,7}
 *      1
 *    2   5
 *  3  4 6  7
 *
 */

public class RebuildBinaryTree {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(RebuildBinaryTree.class);

    public static void main(String[] args) {
//        int[] pre = {3, 7, 11, 13, 18, 29, 40, 63, 88, 122, 89, 123, 64, 90, 129, 91, 131, 43, 66, 93, 134, 135, 95, 67, 98, 144, 16, 22, 30, 46, 72, 102,
//                146, 148, 33, 48, 73, 105, 149, 151, 107, 153, 25, 36, 52, 79, 109, 157, 112, 160, 80, 55, 85, 117, 163, 165, 37};
//        int[] in = {3, 7, 18, 88, 122, 63, 123, 89, 40, 90, 129, 64, 131, 91, 29, 134, 93, 135, 66, 95, 43, 67, 98, 144, 13, 11, 30, 46, 72, 146, 102, 148,
//                22, 149, 105, 151, 73, 107, 153, 48, 33, 16, 109, 157, 79, 112, 160, 52, 80, 36, 55, 85, 163, 117, 165, 25, 37};
        int[] pre = {1, 2, 3, 4, 6, 5, 7};
        int[] in = {1, 2, 4, 6, 3, 7, 5};
        reConstructBinaryTree(pre, in);
    }


    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = new TreeNode(pre[0]);
        int[] nodePos = null;
        int preStartOfRight = 0;
        nodePos = locateNodeIndexOfPreAndIn(pre, 0, in, 0, in.length - 1);
        if (nodePos != null) {
            root.left = buildSubTree(pre, nodePos[0] + 1, in, 0, nodePos[1] - 1);
            if (root.left == null)
                preStartOfRight = nodePos[0] + 1;
            else
                preStartOfRight = nodePos[0] + 2;
            root.right = buildSubTree(pre, preStartOfRight, in, nodePos[1] + 1, in.length - 1);
        }

        return root;
    }

    public static TreeNode buildSubTree(int[] pre, int preStart, int[] in, int inStart, int inEnd) {
        TreeNode subRoot = null;
        int[] nodePos;

        if (preStart >= pre.length)
            return subRoot;

        nodePos = locateNodeIndexOfPreAndIn(pre, preStart, in, inStart, inEnd);
        int rightPreStart;
        if (nodePos != null) {
            subRoot = new TreeNode(pre[nodePos[0]]);
            subRoot.left = buildSubTree(pre, nodePos[0] + 1, in, inStart, nodePos[1] - 1);
            if (subRoot.left == null)
                rightPreStart = nodePos[0] + 1;
            else
                rightPreStart = nodePos[0] + 2;

            subRoot.right = buildSubTree(pre, rightPreStart, in, nodePos[1] + 1, inEnd);
        }
        return subRoot;
    }

    public static int[] locateNodeIndexOfPreAndIn(int[] preArr, int preSearchStart, int[] inArr, int inStart, int inEnd) {
        int[] pos = null;
        for (int j = preSearchStart; j < preArr.length; j++) {
            for (int i = inStart; i <= inEnd; i++) {
                if (preArr[j] == inArr[i]) {
                    pos = new int[2];
                    pos[0] = j;
                    pos[1] = i;
                    break;
                }
            }
            if (pos != null)
                break;
        }

        return pos;
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}



