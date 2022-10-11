package com.helipy.leetcodecn.jzof2;

import com.helipy.leetcodecn.TreeNode;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof68I
 * Desc:
 * User:       chuangfengwang
 * CreateTime: 2022-07-25 00:20
 */
public class LtcJzof68I {
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
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return null;
            }
            // 调整 p q, 使得 p 较小
            if (p.val > q.val) {
                TreeNode tmp = p;
                p = q;
                q = tmp;
            }
            // 第一个 p<=cur<=q 的节点就是结果
            TreeNode curNode = root;
            while (curNode != null && !(p.val <= curNode.val && curNode.val <= q.val)) {
                if (curNode.val > q.val) {
                    curNode = curNode.left;
                } else if (curNode.val < p.val) {
                    curNode = curNode.right;
                }
            }
            return curNode;
        }
    }
}
