package com.helipy.leetcodecn.jzof2;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof44
 * Desc: 剑指 Offer 44. 数字序列中某一位的数字
 * https://leetcode.cn/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-08-05 23:26
 */
public class LtcJzof44 {
    static
    class Solution {
        // 18446744073709551616 : 2^64, 20位
        private final int maxDigit = 20;

        public int findNthDigit(int n) {
            if (n < 10) {
                return n;
            }
            for (int digit = 1; digit < maxDigit; ++digit) {
                long allLen = numberCount(digit) * digit;  // 用 long, 不然会溢出
                if (n - allLen >= 0) {
                    // 跳过这个位数的数字
                    n -= allLen;
                } else {
                    // 在这个位数的数字区间内
                    int nth = n / digit;  // 第几个数字. 0-base
                    int ndi = n % digit;  // 从高到低第几位. 0-base
                    int num = (int) intPow(10, digit - 1) + nth;  // 只对 digit>1 成立
                    return numberNthDigit(num, digit, ndi);
                }
            }
            return -1;
        }

        // 数字 num 从高到低第 ndi 位(0-base). digit 是 num 的位数
        private int numberNthDigit(int num, int digit, int ndi) {
            num /= intPow(10, digit - 1 - ndi);
            return num % 10;
        }

        // n 位数有多少个
        private long numberCount(int n) {
            if (n == 1) {
                return 10L;
            }
            return intPow(10, n) - intPow(10, n - 1);
        }

        // 计算 m 的 n 次方: m^n
        private long intPow(int m, int n) {
            if (n < 0) {
                throw new RuntimeException("intPow() is not acceptable for negative n:" + n);
            }
            long res = 1;
            for (int idx = 0; idx < n; ++idx) {
                res *= m;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        Solution solution = new Solution();
//        System.out.println(solution.findNthDigit(3));  // 3
//        System.out.println(solution.findNthDigit(10));  // 1
//        System.out.println(solution.findNthDigit(11));  // 0
//        System.out.println(solution.findNthDigit(341234343));  // 1
        System.out.println(solution.findNthDigit(1000000000));  // 1
    }
}
