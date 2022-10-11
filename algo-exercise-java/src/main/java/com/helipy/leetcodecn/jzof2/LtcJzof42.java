package com.helipy.leetcodecn.jzof2;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof42
 * Desc: 剑指 Offer 42. 连续子数组的最大和
 * https://leetcode.cn/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-07-10 18:32
 */
public class LtcJzof42 {
    static
    class Solution {
        public int maxSubArray(int[] nums) {
            if (nums.length == 0) {
                return Integer.MIN_VALUE;
            }
            int[] f = new int[nums.length];  // f[i] 记录 [x,i] (x=0,1,...,i-1)的最大和
            f[0] = nums[0];
            int maxSum = f[0];
            for (int idx = 1; idx < nums.length; ++idx) {
                f[idx] = Math.max(f[idx - 1] + nums[idx], nums[idx]);
                if (f[idx] > maxSum) {
                    maxSum = f[idx];
                }
            }
            return maxSum;
        }
    }


    public static void main(String[] args) {
        test1();
    }

    static void test1() {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        Solution solution = new Solution();
        int max = solution.maxSubArray(nums);
        System.out.println(max);  // 6
    }
}
