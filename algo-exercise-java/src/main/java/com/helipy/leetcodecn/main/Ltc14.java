package com.helipy.leetcodecn.main;

/**
 * Pack:       com.helipy.leetcodecn.main
 * File:       Ltc14
 * Desc: 14. 最长公共前缀
 * https://leetcode.cn/problems/longest-common-prefix/
 * User:       chuangfengwang
 * CreateTime: 2022-08-06 22:56
 */
public class Ltc14 {
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }
            if (strs.length == 1) {
                return strs[0];
            }
            String common = commonPrefix(strs[0], strs[1]);
            for (int idx = 2; idx < strs.length; ++idx) {
                common = commonPrefix(common, strs[idx]);
            }
            return common;
        }

        public String commonPrefix(String s1, String s2) {
            if (s1 == null || s2 == null) {
                return "";
            }
            int min = Math.min(s1.length(), s2.length());
            for (int idx = 0; idx < min; ++idx) {
                if (s1.charAt(idx) != s2.charAt(idx)) {
                    return s1.substring(0, idx);
                }
            }
            return s1.substring(0, min);
        }
    }

    public static void main(String[] args) {
        String substring = "".substring(0, 0);
        System.out.println(substring);
    }
}
