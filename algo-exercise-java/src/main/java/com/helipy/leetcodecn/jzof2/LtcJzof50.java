package com.helipy.leetcodecn.jzof2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof50
 * Desc: 剑指 Offer 50. 第一个只出现一次的字符
 * https://leetcode.cn/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-07-09 18:40
 */
public class LtcJzof50 {
    class Solution {
        public char firstUniqChar(String s) {
            Map<Character, Integer> charMap = new HashMap<>();
            List<Character> charSeq = new ArrayList<>();
            for (char ch : s.toCharArray()) {
                if (charMap.containsKey(ch)) {
                    charMap.put(ch, charMap.get(ch) + 1);
                } else {
                    // 第一次出现
                    charSeq.add(ch);
                    charMap.put(ch, 1);
                }
            }
            for (Character ch : charSeq) {
                if (charMap.get(ch) == 1) {
                    return ch;
                }
            }
            return ' ';
        }
    }
}
