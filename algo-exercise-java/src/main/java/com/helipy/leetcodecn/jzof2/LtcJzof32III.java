package com.helipy.leetcodecn.jzof2;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof32III
 * Desc: 剑指 Offer 32 - III. 从上到下打印二叉树 III
 * https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-07-09 23:31
 */
public class LtcJzof32III {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            LinkedList<List<Integer>> output = new LinkedList<>();
            if (root == null) {
                return output;
            }

            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();
            stack1.push(root);
            boolean leftToRight = true;  // 当前层的方向
            List<Integer> curLayerOutput = new LinkedList<>();
            while (!stack1.isEmpty()) {
                TreeNode node = stack1.pop();
                curLayerOutput.add(node.val);
                if (leftToRight) {
                    if (node.left != null) {
                        stack2.push(node.left);
                    }
                    if (node.right != null) {
                        stack2.push(node.right);
                    }
                } else {
                    if (node.right != null) {
                        stack2.push(node.right);
                    }
                    if (node.left != null) {
                        stack2.push(node.left);
                    }
                }

                if (stack1.isEmpty()) {
                    output.add(curLayerOutput);
                    curLayerOutput = new LinkedList<>();

                    // 交换两个栈
                    Stack<TreeNode> tmp = stack1;
                    stack1 = stack2;
                    stack2 = tmp;
                    // 改变方向
                    leftToRight = !leftToRight;
                }
            }
            return output;
        }
    }
}
