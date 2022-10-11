package com.helipy.leetcodecn.jzof2;

import com.alibaba.fastjson.JSON;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof60
 * Desc: 剑指 Offer 60. n个骰子的点数
 * https://leetcode.cn/problems/nge-tou-zi-de-dian-shu-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-08-03 01:24
 */
public class LtcJzof60 {
    static
    class Solution {
        final int face = 6;  // 面数

        public double[] dicesProbability(int n) {
            int[][] a = new int[n + 1][face * n + 1];  // a[m][s] : m 个头子,和为 s 的排列数
            // 迭代计算组合数
            int m = 1;
            for (int idx = 1; idx <= face; ++idx) {
                a[m][idx] = 1;
            }
            ++m;
            while (m <= n) {
                for (int s = m; s <= face * m; ++s) {
                    int sum = 0;
                    for (int idx = 1; idx <= face; ++idx) {
                        if (s-idx>=1) {
                            sum += a[m - 1][s - idx];
                        }
                    }
                    a[m][s] = sum;
                }
                ++m;
            }
            // 计算概率
            double all = 1.;
            for (int idx = 0; idx < n; ++idx) {
                all *= face;
            }
            double[] out = new double[face * n - n + 1];
            for (int idx = 0; idx < out.length; ++idx) {
                int s = idx + n;
                out[idx] = a[n][s] / all;
            }
            return out;
        }
    }

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        Solution solution = new Solution();
        System.out.println(JSON.toJSONString(solution.dicesProbability(1)));
        System.out.println(JSON.toJSONString(solution.dicesProbability(2)));
        System.out.println(JSON.toJSONString(solution.dicesProbability(10)));
        System.out.println(JSON.toJSONString(solution.dicesProbability(11)));
    }

}
