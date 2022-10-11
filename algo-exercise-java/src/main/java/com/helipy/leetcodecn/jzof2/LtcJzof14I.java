package com.helipy.leetcodecn.jzof2;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof14I
 * Desc: 剑指 Offer 14- I. 剪绳子
 * https://leetcode.cn/problems/jian-sheng-zi-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-07-26 21:34
 */
public class LtcJzof14I {
    class Solution {

        // 贪婪法
        public int cuttingRope(int n) {
            assert n > 1;
            if (n == 2) {
                return 1;
            }
            if (n == 3) {
                return 2;
            }
            if (n == 4) {
                return 4;
            }
            // n>5
            int multi = 1;
            while (n >= 5) {
                multi *= 3;
                n -= 3;
            }
            switch (n) {
                case 4 -> multi *= 4;
                case 3 -> multi *= 3;
                case 2 -> multi *= 2;
            }
            return multi;
        }

        // 动态规划解法
        public int cuttingRope1(int n) {
            assert n > 1;
            if (n == 2) {
                return 1;
            }
            if (n == 3) {
                return 2;
            }

            int[] maxMulti = new int[n + 1];
            maxMulti[0] = 0;
            maxMulti[1] = 1;
            maxMulti[2] = 2;
            maxMulti[3] = 3;
            for (int idx = 4; idx <= n; ++idx) {
                int max = 0;
                for (int jdx = 1; jdx <= idx / 2; ++jdx) {
                    int curMulti = maxMulti[jdx] * maxMulti[idx - jdx];
                    if (curMulti > max) {
                        max = curMulti;
                    }
                }
                maxMulti[idx] = max;
            }
            return maxMulti[n];
        }
    }
}
