package com.helipy.leetcodecn.jzof2;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof05
 * Desc: 剑指 Offer 05. 替换空格
 * https://leetcode.cn/problems/ti-huan-kong-ge-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-07-08 01:59
 */
public class LtcJzof05 {

    class Solution {
        public String replaceSpace(String s) {
            int spaceNum = 0;
            for (char c : s.toCharArray()) {
                if (c == ' ') {
                    ++spaceNum;
                }
            }
            StringBuffer sb = new StringBuffer(s.length() + 2 * spaceNum);
            for (char c : s.toCharArray()) {
                if (c == ' ') {
                    sb.append("%20");
                } else {
                    sb.append(c);
                }
            }
            return sb.toString();
        }
    }
}
