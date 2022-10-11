package com.helipy.leetcodecn.main;

/**
 * Pack:       com.helipy.leetcodecn.main
 * File:       Ltc724
 * Desc: 724. 寻找数组的中心下标
 * https://leetcode.cn/problems/find-pivot-index/
 * User:       chuangfengwang
 * CreateTime: 2022-07-27 23:18
 */
public class Ltc724 {
    class Solution {
        public int pivotIndex(int[] nums) {
            if (nums == null) {
                return -1;
            }
            // 计算所有元素的和
            int allSum = 0;
            for (int idx = 0; idx < nums.length; ++idx) {
                allSum += nums[idx];
            }
            //
            int leftSum = 0;
            for (int idx = 0; idx < nums.length; ++idx) {
                if (((allSum - nums[idx]) & 1) == 0 && leftSum == (allSum - nums[idx]) / 2) {
                    return idx;
                }
                leftSum += nums[idx];
            }
            return -1;
        }
    }
}
