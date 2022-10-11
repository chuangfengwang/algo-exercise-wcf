package com.helipy.leetcodecn.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Pack:       com.helipy.leetcodecn.main
 * File:       Ltc383
 * Desc: 383. 赎金信
 * https://leetcode.cn/problems/ransom-note/
 * User:       chuangfengwang
 * CreateTime: 2022-07-18 23:44
 */
public class Ltc383 {
    class Solution {

        // 数组计数实现,高时空效率
        public boolean canConstruct(String ransomNote, String magazine) {
            int[] charMap = new int[26];
            for (char ch : magazine.toCharArray()) {
                ++charMap[ch - 'a'];
            }
            for (char ch : ransomNote.toCharArray()) {
                if (charMap[ch - 'a'] > 0) {
                    --charMap[ch - 'a'];
                } else {
                    return false;
                }
            }
            return true;
        }

        // hashmap 实现,可以应对任意字符
        public boolean canConstruct1(String ransomNote, String magazine) {
            Map<Character, Integer> charMap = new HashMap<>();
            for (int idx = 0; idx < magazine.length(); ++idx) {
                char c = magazine.charAt(idx);
                if (charMap.containsKey(c)) {
                    charMap.put(c, charMap.get(c) + 1);
                } else {
                    charMap.put(c, 1);
                }
            }
            for (int idx = 0; idx < ransomNote.length(); ++idx) {
                char ch = ransomNote.charAt(idx);
                if (charMap.containsKey(ch) && charMap.get(ch) > 0) {
                    charMap.put(ch, charMap.get(ch) - 1);
                } else {
                    return false;
                }
            }
            return true;
        }
    }
}
