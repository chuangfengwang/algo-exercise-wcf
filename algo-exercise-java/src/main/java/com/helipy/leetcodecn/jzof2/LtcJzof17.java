package com.helipy.leetcodecn.jzof2;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof17
 * Desc: 剑指 Offer 17. 打印从1到最大的n位数
 * https://leetcode.cn/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-08-03 01:55
 */
public class LtcJzof17 {
    class Solution {
        public int[] printNumbers(int n) {
            // 求最大的n位十进制数
            int maxNum = 1;
            for (int idx = 0; idx < n; ++idx) {
                maxNum *= 10;
            }
            maxNum -= 1;
            // 生成数组
            int[] num = new int[maxNum];
            for (int val = 1; val <= maxNum; ++val) {
                num[val-1] = val;
            }
            return num;
        }
    }
}
