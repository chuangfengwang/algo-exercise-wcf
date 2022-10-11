package com.helipy.leetcodecn.jzof2;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof65
 * Desc: 剑指 Offer 65. 不用加减乘除做加法
 * https://leetcode.cn/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-07-25 20:15
 */
public class LtcJzof65 {
    static
    class Solution {

        // 用位运算模拟: 不进位加相当于异或, 是否进位相当于与. 对正负数都适用
        public int add(int a, int b) {
            int c = a ^ b;
            int overflow = (a & b) << 1;
            if (overflow != 0) {
                return add(c, overflow);
            } else {
                return c;
            }
        }

        // 用库函数绕过
        public int add1(int a, int b) {
            return Math.addExact(a, b);
        }
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test1() {
        Solution solution = new Solution();
        int out = solution.add(1, 3);
        System.out.println(out);
    }

    private static void test2() {
        Solution solution = new Solution();
        int out = solution.add(-1, 3);
        System.out.println(out);
    }

    private static void test3() {
        Solution solution = new Solution();
        int out = solution.add(-1, -3);
        System.out.println(out);
    }
}
