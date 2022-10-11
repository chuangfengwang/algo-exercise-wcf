package com.helipy.leetcodecn.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Pack:       com.helipy.leetcodecn.main
 * File:       Ltc43
 * Desc: 43. 字符串相乘
 * https://leetcode.cn/problems/multiply-strings/
 * User:       chuangfengwang
 * CreateTime: 2022-08-06 23:22
 */
public class Ltc43 {
    static
    class Solution {
        public String multiply(String num1, String num2) {
            if (Objects.equals(num1, "0") || Objects.equals(num2, "0")) {
                return "0";
            }
            String res = "0";
            for (int idx = num2.length() - 1; idx >= 0; --idx) {
                String tmp = multiplyDigit(num1, num2.charAt(idx));
                StringBuilder sb = new StringBuilder(tmp);
                sb.append("0".repeat(num2.length() - idx - 1));
                res = add(res, sb.toString());
            }
            return res;
        }

        // 数字乘以单个数位
        private String multiplyDigit(String num1, char digit) {
            List<Character> list = new ArrayList<>(num1.length() + 1);  // list[0]表示最低位
            int carry = 0;  // 进位
            for (int idx = num1.length() - 1; idx >= 0; --idx) {
                int tmp = (num1.charAt(idx) - '0') * (digit - '0') + carry;
                carry = tmp / 10;
                char res = (char) ((tmp % 10) + '0');
                list.add(res);
            }
            if (carry > 0) {
                char res = (char) (carry + '0');
                list.add(res);
            }
            StringBuilder sb = new StringBuilder();
            for (int idx = list.size() - 1; idx >= 0; --idx) {
                sb.append(list.get(idx));
            }
            return sb.toString();
        }

        // 字符串表示的数字相加
        private String add(String num1, String num2) {
            List<Character> list = new ArrayList<>(Math.max(num1.length(), num2.length()) + 1);  // list[0]表示最低位
            int carry = 0;  // 进位
            int idx1 = num1.length() - 1, idx2 = num2.length() - 1;
            for (; idx1 >= 0 && idx2 >= 0; --idx1, --idx2) {
                int tmp = (num1.charAt(idx1) - '0') + (num2.charAt(idx2) - '0') + carry;
                carry = tmp / 10;
                char res = (char) ((tmp % 10) + '0');
                list.add(res);
            }
            while (idx1 >= 0) {
                int tmp = (num1.charAt(idx1) - '0') + carry;
                carry = tmp / 10;
                char res = (char) ((tmp % 10) + '0');
                list.add(res);
                --idx1;
            }
            while (idx2 >= 0) {
                int tmp = (num2.charAt(idx2) - '0') + carry;
                carry = tmp / 10;
                char res = (char) ((tmp % 10) + '0');
                list.add(res);
                --idx2;
            }
            if (carry > 0) {
                char res = (char) (carry + '0');
                list.add(res);
            }
            StringBuilder sb = new StringBuilder();
            for (int idx = list.size() - 1; idx >= 0; --idx) {
                sb.append(list.get(idx));
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        Solution solution = new Solution();
        System.out.println(solution.multiply("9", "9"));
    }
}
