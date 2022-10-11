package com.helipy.leetcodecn.jzof2;

import com.helipy.leetcodecn.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof54
 * Desc: 剑指 Offer 54. 二叉搜索树的第k大节点
 * https://leetcode.cn/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-07-23 12:49
 */
public class LtcJzof54 {

//    // Definition for a binary tree node.
//    public class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//
//        TreeNode(int x) {
//            val = x;
//        }
//    }

    static
    class Solution {
        private int k;
        private TreeNode targetNode;

        // 用全局变量记录遍历结果
        public int kthLargest(TreeNode root, int k) {
            if (root == null) {
                return Integer.MIN_VALUE;
            }
            this.k = k;
            this.targetNode = null;
            kthLargestCore(root);
            if (targetNode != null) {
                return targetNode.val;
            }
            return Integer.MIN_VALUE;
        }

        private void kthLargestCore(TreeNode root) {
            if (root == null) {
                return;
            }
            // 按右子树, 根, 左子树的顺序遍历
            kthLargestCore(root.right);
            --k;  // 相当于访问节点
            if (k == 0) {
                targetNode = root;
                return;
            }
            kthLargestCore(root.left);
        }

        // 先算节点数,再计算节点编号,碰到对的编号停止
        public int kthLargest1(TreeNode root, int k) {
            if (root == null) {
                return Integer.MIN_VALUE;
            }
            // 各子树的节点数量计算
            Map<TreeNode, Integer> nodeNumMap = new HashMap<>();
            int nodeNum = calculateNodeNum(root, nodeNumMap);
            if (k <= 0 && k > nodeNum) {
                return Integer.MIN_VALUE;
            }
            // 计算各节点的编号
            int targetIdx = nodeNum - k;
            Map<TreeNode, Integer> nodeIdxMap = new HashMap<>();
            TreeNode targetNode = indexNode(root, 0, targetIdx, nodeNumMap, nodeIdxMap);
            if (targetNode != null) {
                return targetNode.val;
            } else {
                return Integer.MIN_VALUE;
            }
        }

        // 为节点按中序遍历编号. 从 0 开始编号
        private TreeNode indexNode(TreeNode root, int start, int targetIdx,
                                   Map<TreeNode, Integer> nodeNumMap, Map<TreeNode, Integer> nodeIdxMap) {
            if (root == null) {
                return null;
            }
            TreeNode targetNode = null;
            // 根的编号是左子树的节点数量
            if (root.left != null) {
                int rootIdx = start + nodeNumMap.get(root.left);
                nodeIdxMap.put(root, rootIdx);
                if (targetIdx == rootIdx) {
                    return root;
                }
                // 对左子树编号
                targetNode = indexNode(root.left, start, targetIdx, nodeNumMap, nodeIdxMap);
                if (targetNode != null) {
                    return targetNode;
                }
            } else {
                nodeIdxMap.put(root, start);
                if (targetIdx == start) {
                    return root;
                }
            }
            // 右子树编号从根的编号 +1 开始
            int rightStart = nodeIdxMap.get(root) + 1;
            if (root.right != null) {
                targetNode = indexNode(root.right, rightStart, targetIdx, nodeNumMap, nodeIdxMap);
            }
            return targetNode;
        }

        // 计算各节点子树的节点数量
        private int calculateNodeNum(TreeNode root, Map<TreeNode, Integer> nodeNumMap) {
            if (root == null) {
                return 0;
            }
            if (root.left == null && root.right == null) {
                nodeNumMap.put(root, 1);
                return 1;
            }
            int nodeNum = calculateNodeNum(root.left, nodeNumMap) + calculateNodeNum(root.right, nodeNumMap) + 1;
            nodeNumMap.put(root, nodeNum);
            return nodeNum;
        }
    }

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        String input = "[45,30,46,10,36,null,49,8,24,34,42,48,null,4,9,14,25,31,35,41,43,47,null,0,6,null,null,11,20,null,28,null,33,null,null,37,null,null,44,null,null,null,1,5,7,null,12,19,21,26,29,32,null,null,38,null,null,null,3,null,null,null,null,null,13,18,null,null,22,null,27,null,null,null,null,null,39,2,null,null,null,15,null,null,23,null,null,null,40,null,null,null,16,null,null,null,null,null,17]";
        int k = 32;
        TreeNode root = TreeNode.parseTreeFromLeetCodeJsonStr(input);
        Solution solution = new Solution();
        int output = solution.kthLargest1(root, k);
        System.out.println(output);
    }
}
