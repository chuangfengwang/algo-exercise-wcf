package com.helipy.leetcodecn.jzof2;

import com.helipy.leetcodecn.TreeNode;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof
 * Desc: 剑指 Offer 28. 对称的二叉树
 * https://leetcode.cn/problems/dui-cheng-de-er-cha-shu-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-07-10 17:15
 */
public class LtcJzof28 {
    class Solution {

        // 递归比对
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            return isSymmetric(root.left, root.right);
        }

        private boolean isSymmetric(TreeNode root1, TreeNode root2) {
            if (root1 == null && root2 == null) {
                return true;
            }
            if (root1 == null || root2 == null) {
                return false;
            }
            if (root1.val != root2.val) {
                return false;
            }
            return isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
        }
    }
}
