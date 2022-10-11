package com.helipy.leetcodecn.jzof2;

import com.helipy.leetcodecn.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof55I
 * Desc: 剑指 Offer 55 - I. 二叉树的深度
 * https://leetcode.cn/problems/er-cha-shu-de-shen-du-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-07-24 22:02
 */
public class LtcJzof55I {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {

        // 迭代方式求解:层次遍历
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int depth = 0;
            while (!queue.isEmpty()) {
                // 访问一层
                int layerNodeNum = queue.size();
                ++depth;
                while (layerNodeNum > 0) {
                    TreeNode node = queue.poll();
                    if (node != null && node.left != null) {
                        queue.add(node.left);
                    }
                    if (node != null && node.right != null) {
                        queue.add(node.right);
                    }
                    --layerNodeNum;
                }
            }
            return depth;
        }

        // 递归方式求解
        public int maxDepth1(TreeNode root) {
            if (root == null) {
                return 0;
            }
            if (root.left == null && root.right == null) {
                return 1;
            }
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }
}
