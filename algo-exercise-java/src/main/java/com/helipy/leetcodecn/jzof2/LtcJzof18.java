package com.helipy.leetcodecn.jzof2;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof18
 * Desc: 剑指 Offer 18. 删除链表的节点
 * https://leetcode.cn/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-07-17 18:42
 */
public class LtcJzof18 {

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode deleteNode(ListNode head, int val) {
            // 空链表
            if (head == null) {
                return null;
            }

            // 头节点要删除
            if (head.val == val) {
                return head.next;
            }

            // 至少有一个节点
            ListNode lastNode = head;
            ListNode curNode = head.next;
            while (curNode != null) {
                if (curNode.val == val) {
                    // curNode 要删除
                    lastNode.next = curNode.next;
                    return head;
                }
                lastNode = curNode;
                curNode = curNode.next;
            }
            return head;
        }
    }
}
