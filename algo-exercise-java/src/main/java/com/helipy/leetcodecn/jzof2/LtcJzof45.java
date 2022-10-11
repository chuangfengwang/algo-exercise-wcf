package com.helipy.leetcodecn.jzof2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof45
 * Desc: 剑指 Offer 45. 把数组排成最小的数
 * https://leetcode.cn/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-07-24 14:57
 */
public class LtcJzof45 {
    class Solution {
        public String minNumber(int[] nums) {
            if (nums == null || nums.length <= 0) {
                return "";
            }
            List<String> numsList = new ArrayList<String>(nums.length);
            for (int val : nums) {
                numsList.add(String.valueOf(val));
            }
            numsList.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    String s1 = o1 + o2;
                    String s2 = o2 + o1;
                    return s1.compareTo(s2);
                }
            });
            StringBuilder sb = new StringBuilder();
            for (String val : numsList) {
                sb.append(val);
            }
            return sb.toString();
        }
    }
}
