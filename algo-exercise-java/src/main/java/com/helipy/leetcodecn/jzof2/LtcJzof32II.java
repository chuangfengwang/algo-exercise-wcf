package com.helipy.leetcodecn.jzof2;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof32II
 * Desc: 剑指 Offer 32 - II. 从上到下打印二叉树 II
 * https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-07-09 23:30
 */
public class LtcJzof32II {
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
        // 用一个队列,记录每层节点数来判断换行
        public List<List<Integer>> levelOrder(TreeNode root) {
            LinkedList<List<Integer>> output = new LinkedList<>();
            if (root == null) {
                return output;
            }

            // 层次遍历
            Queue<TreeNode> queue = new LinkedList<>();
            int curLayerNodeNum = 1;  // 当前层节点数
            int nextLayerNodeNum = 0;  // 下一层节点数
            queue.add(root);
            LinkedList<Integer> curLayerOutput = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                curLayerOutput.add(node.val);
                --curLayerNodeNum;
                // 添加子节点
                if (node.left != null) {
                    queue.add(node.left);
                    ++nextLayerNodeNum;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    ++nextLayerNodeNum;
                }

                // 层数判断
                if (curLayerNodeNum == 0) {
                    output.add(curLayerOutput);
                    curLayerOutput = new LinkedList<>();
                    // 新的一行
                    curLayerNodeNum = nextLayerNodeNum;
                    nextLayerNodeNum = 0;
                }
            }
            return output;
        }
    }
}
