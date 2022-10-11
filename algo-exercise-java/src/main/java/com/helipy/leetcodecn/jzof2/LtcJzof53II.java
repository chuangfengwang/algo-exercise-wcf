package com.helipy.leetcodecn.jzof2;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof53II
 * Desc: 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * https://leetcode.cn/problems/que-shi-de-shu-zi-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-07-09 01:28
 */
public class LtcJzof53II {

    static
    class Solution {

        // 逐个查找
        public int missingNumber(int[] nums) {
            for (int idx = 0; idx < nums.length; ++idx) {
                if (nums[idx] != idx) {
                    return idx;
                }
            }
            return nums.length;
        }
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
    }

    static void test1() {
        Solution solution = new Solution();
        int[] nums = new int[]{0, 1, 3};
        int missingNumber = solution.missingNumber(nums);
        System.out.println(missingNumber);  // 2
    }

    static void test2() {
        Solution solution = new Solution();
        int[] nums = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 9};
        int missingNumber = solution.missingNumber(nums);
        System.out.println(missingNumber);  // 8
    }

    static void test3() {
        Solution solution = new Solution();
        int[] nums = new int[]{0, 1};
        int missingNumber = solution.missingNumber(nums);
        System.out.println(missingNumber);  // 2
    }

    static void test4() {
        Solution solution = new Solution();
        int[] nums = new int[]{0};
        int missingNumber = solution.missingNumber(nums);
        System.out.println(missingNumber);  // 1
    }

    static void test5() {
        Solution solution = new Solution();
        int[] nums = new int[]{};
        int missingNumber = solution.missingNumber(nums);
        System.out.println(missingNumber);  // 0
    }
}
