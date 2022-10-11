package com.helipy.leetcodecn.jzof2;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof38
 * Desc: 剑指 Offer 38. 字符串的排列
 * https://leetcode.cn/problems/zi-fu-chuan-de-pai-lie-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-08-01 19:37
 */
public class LtcJzof38 {
    static
    class Solution {
        public String[] permutation(String s) {
            if (s == null || s.isEmpty()) {
                return new String[0];
            }
            List<String> carryOut = new LinkedList<>();
            ArrayList<Character> str = new ArrayList<>(s.length());
            for (Character ch : s.toCharArray()) {
                str.add(ch);
            }
            permutationCore(str, 0, carryOut);
            carryOut = new ArrayList<>(new HashSet<String>(carryOut));

            String[] out = new String[carryOut.size()];
            int idx = 0;
            for (String one : carryOut) {
                out[idx++] = one;
            }
            return out;
        }

        // 第一个位置轮流作庄, 接上后面字符生成的组合
        private void permutationCore(ArrayList<Character> str, int startIdx, List<String> carryOut) {
            if (startIdx == str.size() - 1) {
                carryOut.add(charListToString(str));
                return;
            }
            // 第一个字符不变,后面字符生成组合
            permutationCore(str, startIdx + 1, carryOut);
            // 第一个字符和后面每一个字符交换,然后后面字符生成组合
            for (int idx = startIdx + 1; idx < str.size(); ++idx) {
                if (str.get(idx) == str.get(startIdx)) {
                    continue;
                }
                swap(str, startIdx, idx);
                permutationCore(str, startIdx + 1, carryOut);
                swap(str, startIdx, idx);  // 换回来
            }
        }

        // 交换 str 中两个字符
        private void swap(ArrayList<Character> str, int left, int right) {
            if (left == right) {
                return;
            }
            Character leftChar = str.get(left);
            str.set(left, str.get(right));
            str.set(right, leftChar);
        }

        // 转为字符串
        private String charListToString(ArrayList<Character> str) {
            StringBuilder sb = new StringBuilder();
            for (Character ch : str) {
                sb.append(ch);
            }
            return sb.toString();
        }

        // 交换字符串中两个位置的字符
        private String swapChar(String lastStr, int left, int right) {
            char leftChar = lastStr.charAt(left);
            char rightChar = lastStr.charAt(right);
            StringBuilder sb = new StringBuilder();
            sb.append(lastStr, 0, left);
            sb.append(rightChar);
            sb.append(lastStr, left + 1, right);
            sb.append(leftChar);
            sb.append(lastStr, right + 1, lastStr.length());
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        Solution solution = new Solution();
        String[] strArr = solution.permutation("abc");
        System.out.println(JSON.toJSONString(strArr));
    }

    private static void test2() {
        Solution solution = new Solution();
        String[] strArr = solution.permutation("abdb");
        System.out.println(JSON.toJSONString(strArr));
    }


}
