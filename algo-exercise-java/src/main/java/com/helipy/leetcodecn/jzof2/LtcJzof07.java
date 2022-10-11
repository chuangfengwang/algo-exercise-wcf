package com.helipy.leetcodecn.jzof2;

import com.helipy.leetcodecn.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof07
 * Desc: 剑指 Offer 07. 重建二叉树
 * https://leetcode.cn/problems/zhong-jian-er-cha-shu-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-07-25 16:48
 */
public class LtcJzof07 {
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
        // 用 map 记录中序节点的位置
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
                return null;
            }
            Map<Integer, Integer> inOrderIdxMap = new HashMap<>();
            for (int idx = 0; idx < inorder.length; ++idx) {
                inOrderIdxMap.put(inorder[idx], idx);
            }
            return buildTreeCore1(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inOrderIdxMap);
        }

        private TreeNode buildTreeCore1(int[] preorder, int preStart, int preEnd,
                                       int[] inorder, int inStart, int inEnd,
                                       Map<Integer, Integer> inOrderIdxMap) {
            // 没有节点了
            if (preStart > preEnd || inStart > inEnd ||
                    preStart == -1 || preEnd == -1 ||
                    preStart >= preorder.length || preEnd >= preorder.length) {
                return null;
            }
            // 只有一个节点了
            if (preStart == preEnd) {
                if (inStart == inEnd && preorder[preStart] == inorder[inStart]) {
                    return new TreeNode(preorder[preStart]);
                } else {
                    throw new RuntimeException("invalid input");
                }
            }
            // 有多于一个节点
            TreeNode root = new TreeNode(preorder[preStart]);
            TreeNode leftNode = null;
            TreeNode rightNode = null;
            // 在 inorder 中找 root
            int inRootIdx = inOrderIdxMap.get(root.val);
            if (inRootIdx < 0) {
                throw new RuntimeException("invalid input");
            }
            // 找前序序列的前半段
            int leftLen = inRootIdx - inStart;
            leftNode = buildTreeCore1(preorder, preStart + 1, preStart + leftLen, inorder, inStart, inRootIdx - 1, inOrderIdxMap);
            rightNode = buildTreeCore1(preorder, preStart + leftLen + 1, preEnd, inorder, inRootIdx + 1, inEnd, inOrderIdxMap);
            root.left = leftNode;
            root.right = rightNode;
            return root;
        }

        // 顺序查找中序序列,以确定根的位置
        public TreeNode buildTree1(int[] preorder, int[] inorder) {
            if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
                return null;
            }
            return buildTreeCore(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        }

        private TreeNode buildTreeCore(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
            // 没有节点了
            if (preStart > preEnd || inStart > inEnd ||
                    preStart == -1 || preEnd == -1 ||
                    preStart >= preorder.length || preEnd >= preorder.length) {
                return null;
            }
            // 只有一个节点了
            if (preStart == preEnd) {
                if (inStart == inEnd && preorder[preStart] == inorder[inStart]) {
                    return new TreeNode(preorder[preStart]);
                } else {
                    throw new RuntimeException("invalid input");
                }
            }
            // 有多于一个节点
            TreeNode root = new TreeNode(preorder[preStart]);
            TreeNode leftNode = null;
            TreeNode rightNode = null;
            // 在 inorder 中找 root
            int inRootIdx = findIdx(inorder, inStart, inEnd, root.val);
            if (inRootIdx < 0) {
                throw new RuntimeException("invalid input");
            }
            // 找前序序列的前半段
            int leftLen = inRootIdx - inStart;
            leftNode = buildTreeCore(preorder, preStart + 1, preStart + leftLen, inorder, inStart, inRootIdx - 1);
            rightNode = buildTreeCore(preorder, preStart + leftLen + 1, preEnd, inorder, inRootIdx + 1, inEnd);
            root.left = leftNode;
            root.right = rightNode;
            return root;
        }

        private int findIdx(int[] order, int inStart, int inEnd, int aimVal) {
            for (int idx = inStart; idx <= inEnd; ++idx) {
                if (order[idx] == aimVal) {
                    return idx;
                }
            }
            return -1;
        }
    }


    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
        test4();
    }

    private static void test1() {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        Solution solution = new Solution();
        TreeNode root = solution.buildTree(preorder, inorder);
        TreeNode.printAsFullBinaryTree(root);
    }

    private static void test2() {
        int[] preorder = new int[]{1, 2};
        int[] inorder = new int[]{2, 1};
        Solution solution = new Solution();
        TreeNode root = solution.buildTree(preorder, inorder);
        TreeNode.printAsFullBinaryTree(root);
    }

    private static void test3() {
        int[] preorder = new int[]{1, 2};
        int[] inorder = new int[]{1, 2};
        Solution solution = new Solution();
        TreeNode root = solution.buildTree(preorder, inorder);
        TreeNode.printAsFullBinaryTree(root);
    }

    private static void test4() {
        int[] preorder = new int[]{1, 2, 3};
        int[] inorder = new int[]{3, 2, 1};
        Solution solution = new Solution();
        TreeNode root = solution.buildTree(preorder, inorder);
        TreeNode.printAsFullBinaryTree(root);
    }
}
