package com.helipy.leetcodecn.jzof2;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof67
 * Desc: 剑指 Offer 67. 把字符串转换成整数
 * https://leetcode.cn/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-07-30 18:32
 */
public class LtcJzof67 {
    static
    class Solution {
        public int strToInt(String str) {
            if (str == null) {
                return 0;
            }
            boolean preSpaceIgn = true;  // 是否可以忽略前导空格
            boolean isNeg = false;  // 是不是负数
            boolean hasFlag = false;  // 是不是有符号位
            long num = 0;
            boolean hasNum = false;
            boolean overflow = false;
            for (int idx = 0; idx < str.length(); ++idx) {
                // 前导空格
                if (preSpaceIgn && str.charAt(idx) == ' ') {
                    continue;
                }
                // 符号
                if (!hasNum && !hasFlag && str.charAt(idx) == '+') {
                    hasFlag = true;
                    preSpaceIgn = false;
                    continue;
                }
                if (!hasNum && !hasFlag && str.charAt(idx) == '-') {
                    isNeg = true;
                    hasFlag = true;
                    preSpaceIgn = false;
                    continue;
                }
                // 数字
                if (str.charAt(idx) >= '0' && str.charAt(idx) <= '9') {
                    preSpaceIgn = false;
                    hasNum = true;
                    int digit = str.charAt(idx) - '0';
                    num *= 10;
                    num += digit;
                    if (!isNeg && num > Integer.MAX_VALUE) {
                        overflow = true;
                        break;
                    } else if (isNeg && num > Integer.MAX_VALUE + 1L) {
                        overflow = true;
                        break;
                    }
                    continue;
                }
                if (!hasNum) {
                    return 0;
                }
                break;
            }

            if (overflow && isNeg) {
                // 负数溢出
                return Integer.MIN_VALUE;
            }
            if (overflow) {
                // 正数溢出
                return Integer.MAX_VALUE;
            }
            // 没有溢出
            if (isNeg) {
                return (int) -num;
            } else {
                return (int) num;
            }
        }
    }

    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        Solution solution = new Solution();
        System.out.println(solution.strToInt("42"));
        System.out.println(solution.strToInt("-42"));
        System.out.println(solution.strToInt("   42"));
        System.out.println(solution.strToInt("   -42"));
        System.out.println(solution.strToInt("4193 with words"));
        System.out.println(solution.strToInt("  4193 with words"));
        System.out.println(solution.strToInt("  -4193 with words"));
        System.out.println(solution.strToInt("2147483647"));
        System.out.println(solution.strToInt("  -2147483647"));
        System.out.println(solution.strToInt("-2147483648"));
        System.out.println(solution.strToInt("0-1"));
        System.out.println(solution.strToInt("-0-1"));
        System.out.println(solution.strToInt("00-1"));
    }

    private static void test2() {
        Solution solution = new Solution();
        System.out.println(solution.strToInt("words and 987"));
        System.out.println(solution.strToInt("-91283472332"));
        System.out.println(solution.strToInt("2147483648"));
        System.out.println(solution.strToInt("-2147483649"));
    }
}
