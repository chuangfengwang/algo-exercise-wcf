package com.helipy.leetcodecn.jzof2;


/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof15
 * Desc:
 * User:       chuangfengwang
 * CreateTime: 2022-07-25 19:43
 */
public class LtcJzof15 {
    static
    public class Solution {

        // 数一数
        public int hammingWeight(int n) {
            int count = 0;
            while (n != 0) {
                if ((n & 1) == 1) {
                    ++count;
                }
                n = n >>> 1;  // 无符号右移
            }
            return count;
        }


        // you need to treat n as an unsigned value
        // (n-1)&n 反转最后一个 1
        public int hammingWeight1(int n) {
            int count = 0;
            // 正数, (n-1)&n 反转最后一个 1: 正负数都适用
            while (n != 0) {
                n = (n - 1) & n;
                ++count;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }


    private static void test1() {
        Solution solution = new Solution();
        int out = solution.hammingWeight(11);
        System.out.println(out);
    }

    private static void test2() {
        Solution solution = new Solution();
        int out = solution.hammingWeight(128);
        System.out.println(out);
    }

    private static void test3() {
        Solution solution = new Solution();
        int out = solution.hammingWeight(-3);
        System.out.println(out);
    }
}
