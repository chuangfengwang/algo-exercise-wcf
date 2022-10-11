package com.helipy.leetcodecn.jzof2;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof57
 * Desc: 剑指 Offer 57. 和为s的两个数字
 * <p>
 * User:       chuangfengwang
 * CreateTime: 2022-07-17 20:28
 */
public class LtcJzof57 {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            if (nums.length < 2) {
                return new int[]{};
            }
            int start = 0, end = nums.length - 1;
            while (start < end) {
                if (nums[start] + nums[end] > target) {
                    --end;
                    continue;
                } else if (nums[start] + nums[end] < target) {
                    ++start;
                    continue;
                }
                return new int[]{nums[start], nums[end]};
            }
            return new int[]{};
        }
    }
}
