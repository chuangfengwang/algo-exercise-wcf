package com.helipy.leetcodecn.jzof2;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof10I
 * Desc: 剑指 Offer 10- I. 斐波那契数列
 * https://leetcode.cn/problems/fei-bo-na-qi-shu-lie-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-07-10 17:28
 */
public class LtcJzof10I {
    class Solution {
        // 迭代法
        public int fib1(int n) {
            if (n == 0) {
                return 0;
            }
            if (n == 1) {
                return 1;
            }
            int fnMinus2 = 0;
            int fnMinus1 = 1;
            int fn = 0;
            for (int idx = 2; idx <= n; ++idx) {
                fn = (fnMinus2 + fnMinus1) % 1000000007;
                fnMinus2 = fnMinus1;
                fnMinus1 = fn;
            }
            return fn;
        }

        // 递归法: 超时
        public int fib2(int n) {
            if (n == 0) {
                return 0;
            }
            if (n == 1) {
                return 1;
            }
            return (fib(n - 1) + fib(n - 2)) % 1000000007;
        }

        // 动态规划
        public int fib(int n) {
            int[] tmp = new int[Math.max(n + 1, 2)];
            tmp[0] = 0;
            tmp[1] = 1;
            for (int idx = 2; idx <= n; ++idx) {
                tmp[idx] = (tmp[idx - 1] + tmp[idx - 2]) % 1000000007;
            }
            return tmp[n];
        }
    }
}
