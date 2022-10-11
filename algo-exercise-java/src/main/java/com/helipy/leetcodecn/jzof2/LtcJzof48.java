package com.helipy.leetcodecn.jzof2;

import java.util.HashMap;
import java.util.Map;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof48
 * Desc: 剑指 Offer 48. 最长不含重复字符的子字符串
 * https://leetcode.cn/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-07-17 18:07
 */
public class LtcJzof48 {

    static
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int maxLen = 0;
            if (s == null || s.equals("")) {
                return maxLen;
            }

            Map<Character, Integer> curCharMap = new HashMap<>();
            int start = 0;
            int end = 0;
            int curLen = 0;
            while (end < s.length()) {
                // 字符之前碰到过
                if (curCharMap.containsKey(s.charAt(end)) && curCharMap.get(s.charAt(end)) >= start) {
                    // 新的字串开始
                    start = curCharMap.get(s.charAt(end)) + 1;
                    curLen = end - start + 1;
                } else {
                    ++curLen;
                }
                maxLen = Math.max(maxLen, curLen);
                curCharMap.put(s.charAt(end), end);
                ++end;
            }
            return maxLen;
        }
    }


}
