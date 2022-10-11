package com.helipy.leetcodecn.jzof2;

import java.util.Stack;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof30
 * Desc: 剑指 Offer 30. 包含min函数的栈
 * https://leetcode.cn/problems/bao-han-minhan-shu-de-zhan-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-07-05 23:51
 */
public class LtcJzof30 {
    class MinStack {
        private Stack<Integer> dataStack;
        private Stack<Integer> minStack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            dataStack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            dataStack.push(x);
            if (minStack.isEmpty() || x < minStack.peek()) {
                minStack.push(x);
            } else {
                minStack.push(minStack.peek());
            }
        }

        public void pop() {
            dataStack.pop();
            minStack.pop();
        }

        public int top() {
            return dataStack.peek();
        }

        public int min() {
            return minStack.peek();
        }
    }
}
