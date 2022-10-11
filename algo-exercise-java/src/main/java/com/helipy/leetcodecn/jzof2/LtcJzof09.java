package com.helipy.leetcodecn.jzof2;


import java.util.Stack;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof09
 * Desc: 剑指 Offer 09. 用两个栈实现队列
 * https://leetcode.cn/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-07-05 23:21
 */
public class LtcJzof09 {

    class CQueue {
        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        public CQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            if (!stack2.isEmpty()) {
                return stack2.pop();
            }
            while (!stack1.isEmpty()) {
                Integer pop = stack1.pop();
                stack2.push(pop);
            }
            if (stack2.isEmpty()) {
                return -1;
            }
            return stack2.pop();
        }
    }

}
