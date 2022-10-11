package com.helipy.leetcodecn.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Pack:       com.helipy.leetcodecn.main
 * File:       Ltc2236
 * Desc: 2236. 判断根结点是否等于子结点之和
 * https://leetcode.cn/problems/root-equals-sum-of-children/
 * User:       chuangfengwang
 * CreateTime: 2022-07-19 15:35
 */
public class Ltc2236 {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public boolean checkTree(TreeNode root) {
            if (root == null) {
                return false;
            }
            return root.left != null && root.right != null && root.left.val + root.right.val == root.val;
        }
    }
}
