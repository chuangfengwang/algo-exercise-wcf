package com.helipy.common;

/**
 * Pack:       com.helipy.common
 * File:       BinarySearch
 * Desc: 二分查找
 * User:       chuangfengwang
 * CreateTime: 2022-07-09 17:00
 */
public class BinarySearch {

    // 迭代写法
    public static int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length - 1, mid;
        while (start <= end) {
            // mid = (end + start) >> 1;
            mid = start + ((end - start) >> 1);  // 带符号右移, 优先级低于 + -
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    // 递归写法
    public static int searchRecursion(int[] nums, int target) {
        return searchRecursionCore(nums, target, 0, nums.length - 1);
    }

    private static int searchRecursionCore(int[] nums, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + ((end - start) >> 1);  // 带符号右移, 优先级低于 + -
        if (target == nums[mid]) {
            return mid;
        }
        if (target > nums[mid]) {
            return searchRecursionCore(nums, target, mid + 1, end);
        } else {
            return searchRecursionCore(nums, target, start, mid - 1);
        }
    }

}
