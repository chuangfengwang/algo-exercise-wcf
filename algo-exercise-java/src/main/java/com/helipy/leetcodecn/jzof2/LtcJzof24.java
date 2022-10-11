package com.helipy.leetcodecn.jzof2;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       Ltcjzof24
 * Desc: 剑指 Offer 24. 反转链表
 * https://leetcode.cn/problems/fan-zhuan-lian-biao-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-07-06 01:00
 */
public class LtcJzof24 {
    //     Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return null;
            }

            // 倒转链表
            ListNode curr = head;
            ListNode next = curr.next;

            curr.next = null;
            ListNode nextNext;
            while (next != null) {
                nextNext = next.next;
                next.next = curr;

                curr = next;
                next = nextNext;
            }
            return curr;
        }
    }
}
