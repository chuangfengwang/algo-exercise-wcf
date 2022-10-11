package com.helipy.leetcodecn.jzof2;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof
 * Desc: 剑指 Offer 46. 把数字翻译成字符串
 * https://leetcode.cn/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-07-11 11:50
 */
public class LtcJzof46 {
    static
    class Solution {
        public int translateNum(int num) {
            if (num < 0) {
                return 0;
            }
            String numStr = Integer.valueOf(num).toString();
            if (numStr.length() == 1) {
                return 1;
            }
            int f2 = 1;  // 保存 f(i+2)
            int f1 = 1 + g2(numStr.substring(numStr.length() - 2, numStr.length()));  // 保存 f(i+1)
            int f = f1;
            for (int idx = numStr.length() - 3; idx >= 0; --idx) {
                f = f1 + g2(numStr.substring(idx, idx + 2)) * f2;

                f2 = f1;
                f1 = f;
            }
            return f;
        }

        // 两位数字能不能按整体翻译
        private int g2(String twoDigital) {
            assert twoDigital.length() == 2;
            // 10-25：1
            if (twoDigital.charAt(0) == '1') {
                return 1;
            } else if (twoDigital.charAt(0) == '2' && twoDigital.charAt(1) >= '0' && twoDigital.charAt(1) <= '5') {
                return 1;
            }
            return 0;
        }

        // 直接用数字变换的解法
        public int translateNum1(int num) {
            assert num >= 0;

            if (num < 100) {
                return f100(num);
            }
            int digitNum = digitNum(num);  // num 的位数
            assert digitNum >= 3;

            int single = cutNum(num, digitNum - 1, 1, digitNum);  // 取 1 位数
            int dou = cutNum(num, digitNum - 2, 2, digitNum);  // 取 2 位数
            int giMinus2 = f100(single), giMinus1 = f100(dou);
            int gi = giMinus1;
            for (int idx = digitNum - 3; idx >= 0; --idx) {
                single = cutNum(num, idx, 1, digitNum);  // 取 1 位数
                dou = cutNum(num, idx, 2, digitNum);  // 取 2 位数
                gi = giMinus1 * f100(single) + giMinus2 * (f100(dou) - 1);

                giMinus2 = giMinus1;
                giMinus1 = gi;
            }
            return gi;
        }

        // 从前往后,截取 num 的第 i 位(len=1), 或 i,i+1 位(len=2), 位的索引从 0 开始编号
        int cutNum(int num, int i, int len, int digitNum) {
            assert len == 1 || len == 2;
            assert i + len - 1 < digitNum;
            if (len == 1) {
                int dropShadow = digitNum - (i + 1);
                num /= exp10(dropShadow);
                return num % 10;
            }
            int dropShadow = digitNum - (i + 1) - 1;
            num /= exp10(dropShadow);
            return num % 100;
        }

        // 10 的 n 次方
        int exp10(int n) {
            int res = 1;
            for (int i = 0; i < n; ++i) {
                res *= 10;
            }
            return res;
        }

        // 数字的10进制位数
        public static int digitNum(int num) {
            assert num >= 0;
            for (int idx = 1; idx <= 10; ++idx) {
                if (num < 10) {
                    return idx;
                }
                num /= 10;
            }
            // 不会出现
            return 0;
        }

        // [0,99] 区间内的数字有多少种翻译方法
        public static int f100(int num) {
            assert 0 <= num && num < 100;
            if (num <= 9 || num >= 26) {
                return 1;
            } else {
                return 2;
            }
        }
    }


    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    private static Solution solution = new Solution();

    static void test1() {
        int digitNum = Solution.digitNum(1);
        System.out.println(digitNum);

        int digitNum2 = Solution.digitNum(12133);
        System.out.println(digitNum2);
    }


    static void test2() {
        int num = 3, digitNum = Solution.digitNum(num);
        int res = solution.cutNum(num, 0, 1, digitNum);
        System.out.println(res);  // 3
    }

    static void test3() {
        int num2 = 3123, digitNum2 = Solution.digitNum(num2);
        int res2 = solution.cutNum(num2, 1, 2, digitNum2);
        System.out.println(res2);  // 12
    }

    static void test4() {
        int num = 12258;
        int res = solution.translateNum1(num);
        System.out.println(res);  // 5
    }
}
