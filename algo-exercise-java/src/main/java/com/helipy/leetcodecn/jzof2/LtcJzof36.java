package com.helipy.leetcodecn.jzof2;

import com.helipy.leetcodecn.Pair;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof36
 * Desc: 剑指 Offer 36. 二叉搜索树与双向链表
 * https://leetcode.cn/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-07-19 19:04
 */
public class LtcJzof36 {
    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    class Solution {
        public Node treeToDoublyList(Node root) {
            if (root == null) {
                return null;
            }
            Pair<Node, Node> pair = treeToToDoublyListNoCircle(root);
            pair.getKey().left = pair.getValue();
            pair.getValue().right = pair.getKey();
            return pair.getKey();
        }

        // 处理成双向不循环列表：返回的 pair 是结果里的 head 和 tail
        private Pair<Node, Node> treeToToDoublyListNoCircle(Node root) {
            if (root == null) {
                return new Pair<>(null, null);
            }
            Node head = null, tail = null;
            // 处理左子树
            if (root.left != null) {
                Pair<Node, Node> leftPair = treeToToDoublyListNoCircle(root.left);
                head = leftPair.getKey();
                leftPair.getValue().right = root;
                root.left = leftPair.getValue();
            }

            // 处理 root
            if (head == null) {
                head = root;
            }

            // 处理右子树
            if (root.right != null) {
                Pair<Node, Node> rightPair = treeToToDoublyListNoCircle(root.right);
                tail = rightPair.getValue();
                rightPair.getKey().left = root;
                root.right = rightPair.getKey();
            }
            if (tail == null) {
                tail = root;
            }

            return new Pair<>(head, tail);
        }
    }
}
