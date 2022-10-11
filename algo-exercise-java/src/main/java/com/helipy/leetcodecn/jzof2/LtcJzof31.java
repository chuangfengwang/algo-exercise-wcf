package com.helipy.leetcodecn.jzof2;

import java.util.Stack;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof31
 * Desc: 剑指 Offer 31. 栈的压入、弹出序列
 * https://leetcode.cn/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-07-28 19:21
 */
public class LtcJzof31 {
    static
    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            if (pushed == null || popped == null) {
                return false;
            }
            if (pushed.length != popped.length) {
                return false;
            }
            if (pushed.length == 0) {
                return true;
            }
            Stack<Integer> stack = new Stack<>();
            int nextPopIdx = 0;
            int nextPushIdx = 0;
            while (nextPushIdx < pushed.length) {  // 判断每个弹出元素直到末尾
                while (stack.isEmpty() || stack.peek() != popped[nextPopIdx]) {  // 压入元素直到栈顶与弹出元素相等
                    if (nextPushIdx < pushed.length) {
                        // 还有元素可以入栈
                        stack.push(pushed[nextPushIdx]);
                        ++nextPushIdx;
                    } else {
                        // 所有元素都已经入栈
                        break;
                    }
                }
                if (stack.peek() == popped[nextPopIdx]) {
                    // 相等就弹出栈,继续判断下一个元素
                    stack.pop();
                    ++nextPopIdx;
                } else {
                    return false;
                }
            }
            // 如果栈里还有元素,只能与剩余弹出序列一致
            while (!stack.isEmpty()) {
                if (nextPopIdx >= popped.length) {
                    return false;
                }
                if (stack.pop() != popped[nextPopIdx]) {
                    return false;
                }
                ++nextPopIdx;
            }
            return nextPopIdx == popped.length;
        }
    }

    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        int[] pushed = new int[]{1, 2, 3, 4, 5};
        int[] popped = new int[]{4, 5, 3, 2, 1};
        Solution solution = new Solution();
        boolean out = solution.validateStackSequences(pushed, popped);
        System.out.println(out);  // true
    }

    private static void test2() {
        int[] pushed = new int[]{1, 2, 3, 4, 5};
        int[] popped = new int[]{4, 3, 5, 1, 2};
        Solution solution = new Solution();
        boolean out = solution.validateStackSequences(pushed, popped);
        System.out.println(out);  // false
    }
}
