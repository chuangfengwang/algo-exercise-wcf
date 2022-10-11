package com.helipy.leetcodecn.jzof2;

import com.alibaba.fastjson.JSON;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       Jzof20
 * Desc: 剑指 Offer 20. 表示数值的字符串
 * https://leetcode.cn/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-07-30 12:08
 */
public class LtcJzof20 {
    static
    class Solution {
        private Pattern pattern = Pattern.compile("(( *[+-]?\\d+(\\.(\\d+)?)?)|( *[+-]?\\.\\d+))([eE][+-]?\\d+)? *");

        // 正则解法
        public boolean isNumber1(String s) {
            if (s == null) {
                return false;
            }
            Matcher matcher = pattern.matcher(s);
            return matcher.matches();
        }

        public boolean isNumber(String s) {
            if (s == null) {
                return false;
            }

            boolean isPreFlag = false;  // e 之前的数字是否有正负号
            boolean isPreDot = false;  // 是否以 . 开头
            boolean isFloat = false;  // 是不是小数
            for (int idx = 0; idx < s.length(); ++idx) {
                if (!isPreFlag && (s.charAt(idx) == '+' || s.charAt(idx) == '-')) {
                    isPreFlag = true;
                } else if (!isPreDot && (s.charAt(idx) == '.')) {
                    isPreDot = true;
                } else if (s.charAt(idx)>='0' && s.charAt(idx)<='9'){

                }
            }

            return false;
        }

        // 去除首尾的空格
        private String trimSpace(String s) {
            int start = 0, end = s.length() - 1;
            for (int idx = 0; idx < s.length(); ++idx) {
                if (s.charAt(idx) == ' ') {
                    start = idx;
                }
            }
            for (int idx = s.length() - 1; idx >= 0; --idx) {
                if (s.charAt(idx) == ' ') {
                    end = idx;
                } else {
                    break;
                }
            }
            return s.substring(start, end + 1);
        }
    }

    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        String input = "[\"0\", \"+100\", \"5e2\", \"-123\", \"3.1416\", \"-1E-16\", \"0123\"]";
        List<String> list = JSON.parseArray(input, String.class);
        Solution solution = new Solution();
        for (String s : list) {
            System.out.println(s + "\t:" + solution.isNumber(s));
        }
    }

    private static void test2() {
        String input = "[\"12e\", \"1a3.14\", \"1.2.3\", \"+-5\", \"12e+5.4\"]";
        List<String> list = JSON.parseArray(input, String.class);
        Solution solution = new Solution();
        for (String s : list) {
            System.out.println(s + "\t:" + solution.isNumber(s));
        }
    }
}
