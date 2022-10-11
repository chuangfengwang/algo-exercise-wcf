package com.helipy.leetcodecn.jzof2;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof16
 * Desc: 剑指 Offer 16. 数值的整数次方
 * https://leetcode.cn/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-07-25 18:14
 */
public class LtcJzof16 {
    static
    class Solution {
        public double myPow(double x, int n) {
            long absn = n;  // n=2^-31时, -n 溢出
            return n >= 0 ? myPowCore(x, absn) : 1.0 / myPowCore(x, -absn);
        }

        private double myPowCore(double x, long n) {
            if (n == 0) {
                return 1.;
            }
            // 多两次判读可适当减少递归深度(没有的话逻辑也对)
            if (n == 1) {
                return x;
            }
            if (n == 2) {
                return x * x;
            }
            double res = myPowCore(x, n >> 1);
            return (n & 1L) > 0 ? res * res * x : res * res;
        }

        public double myPow1(double x, int n) {
            long absn = n;  // n=2^-31时, -n 溢出
            absn = absn >= 0 ? absn : -absn;
            double res = powUnsignedInt(x, absn);
            // n 非负
            if (n >= 0) {
                return res;
            }
            // n 为负
            if ((res > 0 ? res : -res) <= Double.MIN_NORMAL) {
                throw new RuntimeException("invalid input");
            }
            if (Double.isInfinite(res)) {
                return 0.;
            }
            return 1.0 / res;
        }

        private double powUnsignedInt(double x, long n) {
            if (n == 0) {
                return 1;
            }
            if (n == 1) {
                return x;
            }
            if (n == 2) {
                return x * x;
            }
            long half = n >> 1L;
            long single = n & 1L;
            double res = 1;
            if (half > 0) {
                res = powUnsignedInt(x, half);
            }
            if ((res > 0 ? res : -res) >= Double.MAX_VALUE / 2) {
                return Double.POSITIVE_INFINITY;
            }
            res *= res;
            if (single > 0) {
                res *= x;
            }
            return res;
        }
    }

    public static void main(String[] args) {
//        test1();
//        test2();
        test3();
    }

    private static void test1() {
        Solution solution = new Solution();
        double res = solution.myPow(-3, -2147483647);
        System.out.println(res);
    }

    private static void test2() {
        Solution solution = new Solution();
        double res = solution.myPow(3, -2);
        System.out.println(res);
    }

    private static void test3() {
        Solution solution = new Solution();
        double res = solution.myPow(2., -2147483648);
        System.out.println(res);
    }
}
