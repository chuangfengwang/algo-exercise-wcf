package com.helipy.leetcodecn.jzof2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof32I
 * Desc: 剑指 Offer 32 - I. 从上到下打印二叉树
 * https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-07-09 18:48
 */
public class LtcJzof32I {

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
        public int[] levelOrder(TreeNode root) {
            if (root==null){
                return new int[0];
            }
            List<Integer> output = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode head = queue.poll();
                output.add(head.val);
                if (head.left != null) {
                    queue.add(head.left);
                }
                if (head.right != null) {
                    queue.add(head.right);
                }
            }
            return output.stream().mapToInt(Integer::valueOf).toArray();
        }
    }
}
