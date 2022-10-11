package com.helipy.leetcodecn.jzof2;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof58
 * Desc: 剑指 Offer 58 - II. 左旋转字符串
 * https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-07-08 02:05
 */
public class LtcJzof58 {

    class Solution {
        public String reverseLeftWords(String s, int n) {
            if (n > s.length()) {
                n %= s.length();
            }
            return s.substring(n) + s.substring(0, n);
        }
    }
}
