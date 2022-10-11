package com.helipy.leetcodecn.jzof2;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof25
 * Desc: 剑指 Offer 25. 合并两个排序的链表
 * https://leetcode.cn/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-07-17 19:04
 */
public class LtcJzof25 {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        // 会修改原链表的解法-递归解法
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            // 至少其中一个为空
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            // l1 l2 都不为空
            if (l1.val <= l2.val) {
                ListNode head = l1;
                head.next = mergeTwoLists(l1.next, l2);
                return head;
            } else {
                ListNode head = l2;
                head.next = mergeTwoLists(l1, l2.next);
                return head;
            }
        }
    }
}
