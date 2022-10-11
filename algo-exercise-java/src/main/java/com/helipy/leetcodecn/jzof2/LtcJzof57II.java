package com.helipy.leetcodecn.jzof2;

import java.util.LinkedList;
import java.util.List;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof57II
 * Desc: 剑指 Offer 57 - II. 和为s的连续正数序列
 * https://leetcode.cn/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-07-26 22:22
 */
public class LtcJzof57II {
    class Solution {
        // 维护一个开始值,结束值,和, 当和大于target时,减去开始值;当和小于target时,增加结束值
        public int[][] findContinuousSequence(int target) {
            List<int[]> list = new LinkedList<>();

            int small = 1, big = 2, sum = small + big;
            while (small <= target / 2 && big <= target / 2 + 1 && small < big) {
                if (sum < target) {
                    ++big;
                    sum += big;
                } else if (sum > target) {
                    sum -= small;
                    ++small;
                } else {
                    list.add(genList(small, big));
                    sum -= small;
                    ++small;
                }
            }
            int[][] arr = new int[list.size()][];
            for (int idx = 0; idx < list.size(); ++idx) {
                arr[idx] = list.get(idx);
            }
            return arr;
        }


        // 暴力遍历 开头和结尾, 超时
        public int[][] findContinuousSequence1(int target) {
            List<int[]> list = new LinkedList<>();
            for (int start = 1; start <= target / 2; ++start) {
                int end = calculateEnd(target, start);
                if (end > 0) {
                    list.add(genList(start, end));
                }
            }
            int[][] arr = new int[list.size()][];
            for (int idx = 0; idx < list.size(); ++idx) {
                arr[idx] = list.get(idx);
            }
            return arr;
        }

        // 计算结束位置
        private int calculateEnd(int target, int start) {
            for (int val = start + 1; val <= target / 2 + 1; ++val) {
                if ((start + val) * (val - start + 1) == 2 * target) {
                    return val;
                }
            }
            return -1;
        }

        // 生成列表
        private int[] genList(int start, int end) {
            int[] arr = new int[end - start + 1];
            int val = start;
            for (int idx = 0; idx < arr.length; ++idx, ++val) {
                arr[idx] = val;
            }
            return arr;
        }
    }
}
