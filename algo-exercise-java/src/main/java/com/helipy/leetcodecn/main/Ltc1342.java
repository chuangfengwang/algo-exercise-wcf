package com.helipy.leetcodecn.main;

/**
 * Pack:       com.helipy.leetcodecn.main
 * File:       Ltc1342
 * Desc: 1342. 将数字变成 0 的操作次数
 * https://leetcode.cn/problems/number-of-steps-to-reduce-a-number-to-zero/
 * User:       chuangfengwang
 * CreateTime: 2022-07-19 15:02
 */
public class Ltc1342 {
    class Solution {
        public int numberOfSteps(int num) {
            int step = 0;
            while (num > 0) {
                if ((num & 1) == 0) {
                    // 偶数
                    num = num >> 1;
                } else {
                    --num;
                }
                ++step;
            }
            return step;
        }
    }
}
