package com.helipy.leetcodecn.jzof2;

import com.helipy.leetcodecn.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof27
 * Desc: 剑指 Offer 27. 二叉树的镜像
 * https://leetcode.cn/problems/er-cha-shu-de-jing-xiang-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-07-10 16:39
 */
public class LtcJzof27 {

    class Solution {
        // 交换左右子树,再深度交换. 递归法
        public TreeNode mirrorTree1(TreeNode root) {
            if (root == null) {
                return null;
            }
            // 交换左右子树
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;

            // 递归处理左右子树
            if (root.left != null) {
                mirrorTree(root.left);
            }
            if (root.right != null) {
                mirrorTree(root.right);
            }
            return root;
        }

        // 交换左右子树,再深度交换. 循环交换
        public TreeNode mirrorTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }

                // 交换左右子树
                TreeNode tmp = node.left;
                node.left = node.right;
                node.right = tmp;
            }
            return root;
        }
    }

}
