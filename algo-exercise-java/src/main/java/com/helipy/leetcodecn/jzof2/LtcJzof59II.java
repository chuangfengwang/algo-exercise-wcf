package com.helipy.leetcodecn.jzof2;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof59II
 * Desc: 剑指 Offer 59 - II. 队列的最大值
 * https://leetcode.cn/problems/dui-lie-de-zui-da-zhi-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-08-01 18:54
 */
public class LtcJzof59II {
    class MaxQueue {
        static class WithIndex {
            int val;
            int idx;
        }

        private Deque<WithIndex> maxQueue = new LinkedList<>();  // 维护(潜在)最大值
        private Deque<WithIndex> data = new LinkedList<>();  // 维护数据
        private int curIdx = 0;

        public MaxQueue() {
        }

        public int max_value() {
            if (maxQueue.isEmpty()) {
                return -1;
            }
            return maxQueue.peekFirst().val;
        }

        public void push_back(int value) {
            ++curIdx;
            WithIndex withIndex = new WithIndex();
            withIndex.val = value;
            withIndex.idx = curIdx;
            // 原始数据
            data.addLast(withIndex);
            // 维护最大值. 当前值比潜在最大值大,潜在最大值从队尾出队,当前值作为潜在最大值
            while (!maxQueue.isEmpty() && value >= maxQueue.peekLast().val) {
                maxQueue.pollLast();
            }
            maxQueue.addLast(withIndex);
        }

        public int pop_front() {
            if (data.isEmpty()) {
                return -1;
            }
            WithIndex withIndex = data.pollFirst();
            assert !maxQueue.isEmpty();
            if (withIndex.idx == maxQueue.peekFirst().idx) {
                maxQueue.pollFirst();
            }
            return withIndex.val;
        }
    }

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
}
