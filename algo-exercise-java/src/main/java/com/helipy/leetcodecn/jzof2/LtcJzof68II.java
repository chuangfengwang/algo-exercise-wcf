package com.helipy.leetcodecn.jzof2;

import com.helipy.leetcodecn.TreeNode;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof68II
 * Desc:
 * User:       chuangfengwang
 * CreateTime: 2022-07-25 00:27
 */
public class LtcJzof68II {
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
        // 先找到路径,路径上的最后一个公共节点就是结果
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || p == null || q == null) {
                return null;
            }
            LinkedList<TreeNode> pPath = new LinkedList<>();
            LinkedList<TreeNode> qPath = new LinkedList<>();
            boolean pFound = findPath(root, p, pPath);
            boolean qFound = findPath(root, q, qPath);
            if (!pFound || !qFound) {
                return null;
            }
            // 找最后一个公共节点
            TreeNode lastNode = null;
            Iterator<TreeNode> pCurIt = pPath.iterator();
            Iterator<TreeNode> qCurIt = qPath.iterator();
            while (pCurIt.hasNext() && qCurIt.hasNext()) {
                TreeNode pCur = pCurIt.next();
                TreeNode qCur = qCurIt.next();
                if (pCur != qCur) {
                    return lastNode;
                } else {
                    lastNode = pCur;
                }
            }
            return lastNode;
        }

        private boolean findPath(TreeNode root, TreeNode aim, LinkedList<TreeNode> path) {
            if (root == null || aim == null) {
                return false;
            }
            path.add(root);
            // 当前节点就是要找的
            if (root == aim) {
                return true;
            }
            // 找左子树
            boolean leftFound = false;
            if (root.left != null) {
                leftFound = findPath(root.left, aim, path);
            }
            if (leftFound) {
                return true;
            }
            // 找右子树
            boolean rightFound = false;
            if (root.right != null) {
                rightFound = findPath(root.right, aim, path);
            }
            if (rightFound) {
                return true;
            }
            // 都没有找到,当前子树不存在目标节点
            path.pollLast();
            return false;
        }

    }
}
