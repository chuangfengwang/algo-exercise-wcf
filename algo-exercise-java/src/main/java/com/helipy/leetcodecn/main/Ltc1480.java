package com.helipy.leetcodecn.main;

/**
 * Pack:       com.helipy.leetcodecn.main
 * File:       Ltc1480
 * Desc: 1480. 一维数组的动态和
 * https://leetcode.cn/problems/running-sum-of-1d-array/
 * User:       chuangfengwang
 * CreateTime: 2022-07-18 23:41
 */
public class Ltc1480 {
    class Solution {
        public int[] runningSum(int[] nums) {
            for (int idx = 1; idx < nums.length; ++idx) {
                nums[idx] += nums[idx - 1];
            }
            return nums;
        }
    }
}
