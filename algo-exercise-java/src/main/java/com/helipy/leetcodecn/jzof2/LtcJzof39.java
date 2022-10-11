package com.helipy.leetcodecn.jzof2;

import java.util.Arrays;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof39
 * Desc: 剑指 Offer 39. 数组中出现次数超过一半的数字
 * https://leetcode.cn/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-07-26 14:14
 */
public class LtcJzof39 {
    class Solution {

        // 快速排序法做分割, 直到分割数值的位置达到 中位 停止
        public int majorityElement(int[] nums) {
            if (nums == null) {
                return Integer.MIN_VALUE;
            }
            int aimIdx = nums.length / 2;
            int start = 0, end = nums.length - 1;
            int partitionIdx = partitionSort(nums, start, end);
            while (partitionIdx != aimIdx) {
                if (partitionIdx < aimIdx) {
                    // 在后半部分
                    start = partitionIdx + 1;
                    partitionIdx = partitionSort(nums, start, end);
                } else {
                    // 在前半部分
                    end = partitionIdx - 1;
                    partitionIdx = partitionSort(nums, start, end);
                }
            }
            return nums[partitionIdx];
        }

        // 快排分割
        private int partitionSort(int[] nums, int start, int end) {
            int pivotIdx = end;  // 分割元素的索引
            int lastLessThanIdx = start - 1;
            int curIdx = start;
            for (; curIdx < end; ++curIdx) {
                if (nums[curIdx] > nums[pivotIdx]) {
                    ++lastLessThanIdx;
                    swap(nums, curIdx, lastLessThanIdx);
                }
            }
            // 参考值就位
            ++lastLessThanIdx;
            swap(nums, pivotIdx, lastLessThanIdx);
            return lastLessThanIdx;
        }

        private void swap(int[] nums, int leftIdx, int rightIdx) {
            if (leftIdx == rightIdx) {
                return;
            }
            int tmp = nums[leftIdx];
            nums[leftIdx] = nums[rightIdx];
            nums[rightIdx] = tmp;
        }

        // 排序取中
        public int majorityElement1(int[] nums) {
            if (nums == null) {
                return Integer.MIN_VALUE;
            }
            Arrays.sort(nums);
            return nums[nums.length / 2];
        }
    }
}
