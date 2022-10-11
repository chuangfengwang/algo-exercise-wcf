package com.helipy.leetcodecn.jzof2;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof10II
 * Desc: 剑指 Offer 10- II. 青蛙跳台阶问题
 * https://leetcode.cn/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-07-10 17:40
 */
public class LtcJzof10II {
    class Solution {
        public int numWays(int n) {
            if (n == 0) {
                return 1;
            }
            if (n == 1) {
                return 1;
            }
            int fnMinus2 = 1;
            int fnMinus1 = 1;
            int fn = 0;
            for (int idx = 2; idx <= n; ++idx) {
                fn = (fnMinus2 + fnMinus1) % 1000000007;
                fnMinus2 = fnMinus1;
                fnMinus1 = fn;
            }
            return fn;
        }
    }
}
