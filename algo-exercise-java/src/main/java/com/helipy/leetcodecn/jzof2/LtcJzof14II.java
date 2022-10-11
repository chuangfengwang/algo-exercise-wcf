package com.helipy.leetcodecn.jzof2;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof14II
 * Desc: 剑指 Offer 14- II. 剪绳子 II
 * https://leetcode.cn/problems/jian-sheng-zi-ii-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-08-06 01:00
 */
public class LtcJzof14II {
    class Solution {
        private static final long mod = 1000000007L;

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
            long multi = 1;  // 用 long 记录结果,int 在乘的过程中可能溢出
            while (n >= 5) {
                multi *= 3;
                multi %= mod;
                n -= 3;
            }
            switch (n) {
                case 4 -> multi *= 4;
                case 3 -> multi *= 3;
                case 2 -> multi *= 2;
            }
            multi %= mod;
            return (int) multi;
        }
    }

}
