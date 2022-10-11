package com.helipy.leetcodecn.jzof2;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       Ltc
 * Desc: 剑指 Offer 63. 股票的最大利润
 * https://leetcode.cn/problems/gu-piao-de-zui-da-li-run-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-07-10 18:00
 */
public class LtcJzof63 {
    class Solution {


        // 暴力法
        public int maxProfit1(int[] prices) {
            int maxProfit = 0;
            for (int dayIn = 0; dayIn < prices.length - 1; ++dayIn) {
                for (int dayOut = dayIn + 1; dayOut < prices.length; ++dayOut) {
                    int p = prices[dayOut] - prices[dayIn];
                    if (p > maxProfit) {
                        maxProfit = p;
                    }
                }
            }
            return maxProfit;
        }

        // 从前往后, `收益`总与已知的`最低价`比
        public int maxProfit(int[] prices) {
            int minPrice = Integer.MAX_VALUE;  // 保存遍历到当前位置所得的最小价格
            int maxProfit = 0;  // 已知最大收益
            for (int p : prices) {
                if (p < minPrice) {
                    minPrice = p;
                }
                if (p - minPrice > maxProfit) {
                    maxProfit = p - minPrice;
                }
            }
            return maxProfit;
        }

    }
}
