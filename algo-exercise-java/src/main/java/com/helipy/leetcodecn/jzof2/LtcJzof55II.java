package com.helipy.leetcodecn.jzof2;

import com.helipy.leetcodecn.Pair;
import com.helipy.leetcodecn.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof55II
 * Desc: 剑指 Offer 55 - II. 平衡二叉树
 * https://leetcode.cn/problems/ping-heng-er-cha-shu-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-07-24 22:43
 */
public class LtcJzof55II {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    static
    class Solution {

        // 先根遍历,边遍历边计算
        public boolean isBalanced(TreeNode root) {
            Pair<Boolean, Integer> pair = isBalancedPreOder(root);
            return pair.getKey();
        }

        // 返回的pair为: 是否平衡, 树的深度
        private Pair<Boolean, Integer> isBalancedPreOder(TreeNode root) {
            if (root == null) {
                return new Pair<>(true, 0);
            }
            Pair<Boolean, Integer> leftPair = isBalancedPreOder(root.left);
            if (!leftPair.getKey()) {
                return new Pair<>(false, -1);
            }
            Pair<Boolean, Integer> rightPair = isBalancedPreOder(root.right);
            if (!rightPair.getKey()) {
                return new Pair<>(false, -1);
            }
            return new Pair<>(Math.abs(leftPair.getValue() - rightPair.getValue()) <= 1,
                    Math.max(leftPair.getValue(), rightPair.getValue()) + 1);
        }

        // 先计算所有节点的深度,再递归判断平衡
        public boolean isBalanced1(TreeNode root) {
            Map<TreeNode, Integer> depthMap = new HashMap<>();
            calculateNodeDeep(root, depthMap);
            return isBalancedCore(root, depthMap);
        }

        private boolean isBalancedCore(TreeNode root, Map<TreeNode, Integer> depthMap) {
            // 这里认为空树是平衡的
            if (root == null) {
                return true;
            }
            // 判断左子树是否平衡
            boolean isLeftBalanced = isBalancedCore(root.left, depthMap);
            if (!isLeftBalanced) {
                return false;
            }

            // 判断右子树是否平衡
            boolean isRightBalanced = isBalancedCore(root.right, depthMap);
            if (!isRightBalanced) {
                return false;
            }

            // 判断左右子树高度差
            Integer leftDepth = depthMap.getOrDefault(root.left, 0);
            Integer rightDepth = depthMap.getOrDefault(root.right, 0);
            return Math.abs(leftDepth - rightDepth) <= 1;
        }

        // 计算子树的高度
        private void calculateNodeDeep(TreeNode root, Map<TreeNode, Integer> depthMap) {
            if (root == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                depthMap.put(root, 1);
                return;
            }
            int leftDepth = 0;
            if (root.left != null) {
                calculateNodeDeep(root.left, depthMap);
                leftDepth = depthMap.get(root.left);
            }
            int rightDepth = 0;
            if (root.right != null) {
                calculateNodeDeep(root.right, depthMap);
                rightDepth = depthMap.get(root.right);
            }
            int curDepth = Math.max(leftDepth, rightDepth) + 1;
            depthMap.put(root, curDepth);
        }
    }

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        String input = "[3,9,20,null,null,15,7]";
        TreeNode root = TreeNode.parseTreeFromLeetCodeJsonStr(input);
        Solution solution = new Solution();
        boolean isBalanced = solution.isBalanced(root);
        System.out.println(isBalanced);
    }
}
