package com.helipy.leetcodecn.main;

/**
 * Pack:       com.helipy.leetcodecn.main
 * File:       Ltc1672
 * Desc: 1672. 最富有客户的资产总量
 * https://leetcode.cn/problems/richest-customer-wealth/
 * User:       chuangfengwang
 * CreateTime: 2022-07-19 15:13
 */
public class Ltc1672 {
    class Solution {
        public int maximumWealth(int[][] accounts) {
            if (accounts.length == 0) {
                return -1;
            }
            int maxWealth = 0;
            for (int[] account : accounts) {
                int curSum = 0;
                for (int i : account) {
                    curSum += i;
                }
                if (curSum > maxWealth) {
                    maxWealth = curSum;
                }
            }
            return maxWealth;
        }
    }
}
