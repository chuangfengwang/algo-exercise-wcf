package com.helipy.leetcodecn.jzof2;

import com.alibaba.fastjson.JSON;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof59I
 * Desc: 剑指 Offer 59 - I. 滑动窗口的最大值
 * User:       chuangfengwang
 * CreateTime: 2022-08-01 14:02
 */
public class LtcJzof59I {
    static
    class Solution {

        // 队列里记录当前窗口中最大值的索引.队头是最大值的索引,队头总是比队列里的其他最大值大
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || k <= 0 || k > nums.length) {
                return new int[0];
            }

            Deque<Integer> deque = new LinkedList<>();
            // 处理前 k 个元素
            for (int idx = 0; idx < k; ++idx) {
                while (!deque.isEmpty() && nums[idx] >= nums[deque.peekLast()]) {
                    // 当前值比队尾大, 队尾不再可能是最大值
                    deque.pollLast();
                }
                // (当前元素比队尾小了)当前值作为最新的最大值
                deque.addLast(idx);
            }
            int[] out = new int[nums.length - k + 1];
            int outIdx = 0;
            assert !deque.isEmpty();
            // 上一轮的最大元素
            Integer maxValIdx = deque.peekFirst();
            out[outIdx++] = nums[maxValIdx];

            // 从 k+1(1-base) 个元素开始
            for (int idx = k; idx < nums.length; ++idx) {
                // 处理当前元素

                // 队头元素已经超出窗口, 弹出
                if (idx - deque.peekFirst() >= k) {
                    deque.pollFirst();
                }
                // 当前元素比队尾大,队尾元素不再可能是最大值
                while (!deque.isEmpty() && nums[idx] >= nums[deque.peekLast()]) {
                    deque.pollLast();
                }
                // (当前元素比队尾小了)当前值作为最新的最大值
                deque.addLast(idx);
                // 取最大值放入结果
                assert !deque.isEmpty();
                maxValIdx = deque.peekFirst();
                out[outIdx++] = nums[maxValIdx];
            }
            return out;
        }

        // 暴力循环法
        public int[] maxSlidingWindow1(int[] nums, int k) {
            if (nums == null || k <= 0 || k > nums.length) {
                return new int[0];
            }
            int[] out = new int[nums.length - k + 1];
            int outIdx = 0;
            LinkedList<Integer> queue = new LinkedList<>();
            for (int num : nums) {
                if (queue.size() < k - 1) {
                    queue.add(num);
                } else {
                    // 加入新元素
                    queue.add(num);
                    int maxVal = maxInQueue(queue);
                    out[outIdx++] = maxVal;
                    // 删除队尾,留下空位
                    queue.pollFirst();
                }
            }
            return out;
        }

        // 队列里的最大值
        private int maxInQueue(LinkedList<Integer> queue) {
            int maxVal = Integer.MIN_VALUE;
            for (Integer val : queue) {
                if (val > maxVal) {
                    maxVal = val;
                }
            }
            return maxVal;
        }
    }

    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        Solution solution = new Solution();
        int[] ints = solution.maxSlidingWindow(nums, 3);
        System.out.println(JSON.toJSONString(ints));
    }

    private static void test2() {
        int[] nums = new int[]{1, 3, 1, 2, 0, 5};
        Solution solution = new Solution();
        int[] ints = solution.maxSlidingWindow(nums, 3);
        System.out.println(JSON.toJSONString(ints));
    }
}
