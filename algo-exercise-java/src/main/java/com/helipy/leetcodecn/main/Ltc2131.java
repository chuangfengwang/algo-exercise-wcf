package com.helipy.leetcodecn.main;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Pack:       com.helipy.leetcodecn.main
 * File:       Ltc2131
 * Desc: 2131. 连接两字母单词得到的最长回文串
 * https://leetcode.cn/problems/longest-palindrome-by-concatenating-two-letter-words/
 * User:       chuangfengwang
 * CreateTime: 2022-08-08 23:29
 */
public class Ltc2131 {
    static
    class Solution {
        public int longestPalindrome(String[] words) {
            if (words == null || words.length == 0) {
                return 0;
            }
            Map<String, Integer> wordCount = new HashMap<>();  // 每个词有多少个
            for (String word : words) {
                if (wordCount.containsKey(word)) {
                    wordCount.put(word, wordCount.get(word) + 1);
                } else {
                    wordCount.put(word, 1);
                }
            }

            boolean hasSingleSameWod = false;
            int pairWord = 0;
            for (String word : wordCount.keySet()) {
                String reverse = new StringBuilder(word).reverse().toString();
                if (!word.equals(reverse) && wordCount.containsKey(word) && wordCount.containsKey(reverse)) {
                    pairWord += Math.min(wordCount.get(word), wordCount.get(reverse));  // 正着加了一遍,反着又加了一遍
                } else if (word.equals(reverse)) {
                    if (wordCount.get(word) % 2 == 0) {
                        pairWord += wordCount.get(word);  // 分成两半, 两半各加了一遍
                    } else {
                        pairWord += (wordCount.get(word) - 1);  // 去掉一个, 分成两半, 两半各加了一遍
                        hasSingleSameWod = true;
                    }
                }
            }

            pairWord /= 2;  // 正反各计算了一次

            // 字符串长度
            int res = pairWord * 4;
            if (hasSingleSameWod) {
                res += 2;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        String input = "[\"dd\",\"aa\",\"bb\",\"dd\",\"aa\",\"dd\",\"bb\",\"dd\",\"aa\",\"cc\",\"bb\",\"cc\",\"dd\",\"cc\"]";
        List<String> wordList = JSON.parseArray(input, String.class);
        String[] words = wordList.toArray(new String[wordList.size()]);
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome(words));
    }
}
