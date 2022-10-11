package com.helipy.leetcodecn.jzof2;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof52
 * Desc: 剑指 Offer 52. 两个链表的第一个公共节点
 * https://leetcode.cn/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-07-17 20:04
 */
public class LtcJzof52 {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int nodeNumA = nodeNum(headA);
            int nodeNumB = nodeNum(headB);

            if (nodeNumA > nodeNumB) {
                int diff = nodeNumA - nodeNumB;
                // headA 先走 diff 步
                while (diff > 0) {
                    headA = headA.next;
                    --diff;
                }
            } else {
                int diff = nodeNumB - nodeNumA;
                // headB 先走 diff 步
                for (; diff > 0; --diff) {
                    headB = headB.next;
                }
            }
            // 两个指针一起走,边走边判断
            while (headA != null && headB != null && headA != headB) {
                headA = headA.next;
                headB = headB.next;
            }
            if (headA != null && headA == headB) {
                return headA;
            }
            return null;
        }

        // 链表的节点数
        private int nodeNum(ListNode head) {
            int nodeNum = 0;
            while (head != null) {
                ++nodeNum;
                head = head.next;
            }
            return nodeNum;
        }
    }


}
