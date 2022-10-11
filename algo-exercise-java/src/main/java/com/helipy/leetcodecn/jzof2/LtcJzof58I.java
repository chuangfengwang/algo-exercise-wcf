package com.helipy.leetcodecn.jzof2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof58I
 * Desc: 剑指 Offer 58 - I. 翻转单词顺序
 * https://leetcode.cn/problems/fan-zhuan-dan-ci-shun-xu-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-07-17 20:35
 */
public class LtcJzof58I {
    static
    class Solution {
        public String reverseWords(String s) {
            s = s.trim();
            List<String> list = Arrays.asList(s.split("[ ]+"));
            Collections.reverse(list);
            return String.join(" ", list);
        }

        public String reverseWords1(String s) {
            if (s == null) {
                return null;
            }
            if (s.equals("") || s.strip().equals("")) {
                return "";
            }
            String[] pieces = s.split(" ");
            StringBuilder sb = new StringBuilder();
            sb.append(reverseString(pieces[0]));
            for (int idx = 1; idx < pieces.length; ++idx) {
                String word = pieces[idx];
                if (Objects.equals(word, "")) {
                    continue;
                }
                sb.append(" ");
                sb.append(reverseString(word));
            }
            return sb.reverse().toString().strip();
        }

        private String reverseString(String s) {
            return new StringBuilder(s).reverse().toString();
        }

        public static void main(String[] args) {
            test2();
        }

        public static void test1() {
            Solution solution = new Solution();
            String s = solution.reverseWords("  hello  world!  ");
            System.out.println(s); //
        }

        public static void test2() {
            Solution solution = new Solution();
            String s = solution.reverseWords("  ");
            System.out.println(s); //
        }

    }
}
