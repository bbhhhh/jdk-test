package com.nowcoder;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/3/5 10:26
 * @Description: TODO
 */

public class HalfSearch {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(HalfSearch.class);

    public static void main(String[] args) {
        int[] arr = {1, 2};
        logger.info("{}", search(arr, 2));

    }

    public static int search(int[] nums, int target) {
        // write code here
        int pos = -1;
        if (nums == null || nums.length == 0)
            return pos;


        int mid = nums.length / 2;
        if (target <= nums[mid]) {
            pos = halfSearch(nums, 0, mid, target);
        } else {
            pos = halfSearch(nums, mid + 1, nums.length - 1, target);
        }
        return pos;
    }

    public static int halfSearch(int[] nums, int start, int end, int target) {
        int pos = -1;
        if (start >= nums.length || start > end)
            return pos;

        if (target == nums[start])
            return start;

        if (start == end)
            return pos;

        int mid = (end - start) / 2;
        if (target <= nums[start + mid]) {
            pos = halfSearch(nums, start, start + mid, target);
        } else {
            pos = halfSearch(nums, start + mid + 1, end, target);
        }

        return pos;
    }
}
