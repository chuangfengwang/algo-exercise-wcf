package com.helipy.leetcodecn.main;

/**
 * Pack:       com.helipy.leetcodecn.main
 * File:       Ltc1413
 * Desc: 1413. 逐步求和得到正数的最小值
 * https://leetcode.cn/problems/minimum-value-to-get-positive-step-by-step-sum/
 * User:       chuangfengwang
 * CreateTime: 2022-08-09 10:30
 */
public class Ltc1413 {
    class Solution {
        public int minStartValue(int[] nums) {
            int minSum = Integer.MAX_VALUE;
            int sum = 0;
            for (int num : nums) {
                sum += num;
                if (sum < minSum) {
                    minSum = sum;
                }
            }
            return Math.max(1 - minSum, 1);
        }
    }
}
