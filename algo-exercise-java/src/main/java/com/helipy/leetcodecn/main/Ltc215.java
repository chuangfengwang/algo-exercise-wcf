package com.helipy.leetcodecn.main;

import java.util.PriorityQueue;

/**
 * Pack:       com.helipy.leetcodecn.main
 * File:       Ltc215
 * Desc: 215. 数组中的第K个最大元素
 * https://leetcode.cn/problems/kth-largest-element-in-an-array/
 * User:       chuangfengwang
 * CreateTime: 2022-07-19 16:11
 */
public class Ltc215 {
    class Solution {
        // 最小堆方法
        public int findKthLargest(int[] nums, int k) {
            if (nums.length < k) {
                return -1;
            }
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k);
            for (int num : nums) {
                if (priorityQueue.size() < k) {
                    priorityQueue.add(num);
                } else {
                    Integer curMin = priorityQueue.peek();
                    if (curMin != null && curMin < num) {
                        priorityQueue.remove();
                        priorityQueue.add(num);
                    }
                }
            }
            Integer maxK = priorityQueue.peek();
            if (maxK == null) {
                return -1;
            }
            return maxK;
        }
    }
}
