package com.helipy.leetcodecn.jzof2;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof64
 * Desc: 剑指 Offer 64. 求1+2+…+n
 * https://leetcode.cn/problems/qiu-12n-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-07-24 23:24
 */
public class LtcJzof64 {


    class Solution {
        // 递归,用短路法判断递归出口
        public int sumNums(int n) {
            boolean flag = n > 1 && (n += sumNums(n - 1)) > 0;
            return n;
        }

    }
}
