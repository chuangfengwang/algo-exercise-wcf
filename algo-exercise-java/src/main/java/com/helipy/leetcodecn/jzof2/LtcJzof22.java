package com.helipy.leetcodecn.jzof2;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof22
 * Desc: 剑指 Offer 22. 链表中倒数第k个节点
 * https://leetcode.cn/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-07-17 18:52
 */
public class LtcJzof22 {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode getKthFromEnd(ListNode head, int k) {
            // 快的指针先走 k-1 步
            ListNode prevNode = head;
            for (int prevStep = 0; prevStep < k - 1; ++prevStep) {
                if (prevNode != null) {
                    prevNode = prevNode.next;
                } else {
                    return null;
                }
            }
            ListNode curNode = head;
            // 两个指针一起走,直到快指针到达尾部
            while (prevNode.next != null) {
                prevNode = prevNode.next;
                curNode = curNode.next;
            }
            return curNode;
        }

        // 链表的节点数
        private int nodeNum(ListNode head) {
            int nodeNum = 0;
            ListNode curNode = head;
            while (curNode != null) {
                ++nodeNum;
                curNode = curNode.next;
            }
            return nodeNum;
        }
    }
}
