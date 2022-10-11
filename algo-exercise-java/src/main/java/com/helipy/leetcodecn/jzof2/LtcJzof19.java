package com.helipy.leetcodecn.jzof2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof19
 * Desc: 剑指 Offer 19. 正则表达式匹配
 * https://leetcode.cn/problems/zheng-ze-biao-da-shi-pi-pei-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-08-02 17:23
 */
public class LtcJzof19 {
    static
    class Solution {

        public boolean isMatch(String s, String p) {
            if (s == null || p == null) {
                return false;
            }
            if (p.equals("")) {
                return s.equals("");
            }
            if (s.equals("")) {
                return emptyPattern(p, 0);
            }
            // p s 都非空
            return isMatchCore(s, 0, p, 0);
        }

        // p 从 pIdx 开始是否可以匹配空字符串
        private boolean emptyPattern(String p, int pIdx) {
            // p 的 pIdx+1,+3,+5,... 位置上必须是 * 且以 * 结尾
            if ((p.length() - pIdx) % 2 == 1) {
                return false;
            }
            for (int idx = pIdx + 1; idx < p.length(); idx += 2) {
                if (p.charAt(idx) != '*') {
                    return false;
                }
            }
            return true;
        }

        private boolean isMatchCore(String s, int sIdx, String p, int pIdx) {
            if (pIdx >= p.length()) {
                // 模式已经消费完成,字符串也要刚好消费完成
                return sIdx >= s.length();
            }
            if (sIdx >= s.length()) {
                // 字符串消费完成,剩余模式要能匹配空字符串
                return emptyPattern(p, pIdx);
            }
            // p的开头分 x*  .  c 三种情况处理
            if (pIdx + 1 < p.length() && p.charAt(pIdx + 1) == '*') {
                boolean res = false;
                if (s.charAt(sIdx) == p.charAt(pIdx) || p.charAt(pIdx) == '.') {
                    res = isMatchCore(s, sIdx + 1, p, pIdx) ||  // 消费字符,不消费模式:多次
                            isMatchCore(s, sIdx + 1, p, pIdx + 2);  // 消费字符,也消费模式:一次
                }
                return res || isMatchCore(s, sIdx, p, pIdx + 2);  // 不消费字符,消费模式:0次
            }
            if (p.charAt(pIdx) == '.') {
                return isMatchCore(s, sIdx + 1, p, pIdx + 1);
            }
            if (p.charAt(pIdx) == s.charAt(sIdx)) {
                return isMatchCore(s, sIdx + 1, p, pIdx + 1);
            }
            return false;
        }


        // 直接用正则表达式实现,作为参照
        public boolean isMatch1(String s, String p) {
            Pattern pattern = Pattern.compile(p);
            Matcher matcher = pattern.matcher(s);
            return matcher.matches();
        }
    }

    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        for (int val : new int[]{1, 2, 3, 4}) {
//            list.add(val);
//        }
//        System.out.println(list);
        test1();
    }

    private static void test1() {
        Solution solution = new Solution();
        boolean out = solution.isMatch("aab", "c*a*b");
        System.out.println(out);
        assert out == true;
    }
}
