package com.helipy.leetcodecn.main;

/**
 * Pack:       com.helipy.leetcodecn.main
 * File:       Ltc21
 * Desc: 21. 合并两个有序链表
 * https://leetcode.cn/problems/merge-two-sorted-lists/
 * User:       chuangfengwang
 * CreateTime: 2022-07-19 15:55
 */
public class Ltc21 {

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {

        // 迭代法
        public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
            ListNode preHead = new ListNode();
            ListNode curNode = preHead;
            while (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    curNode.next = list1;
                    curNode = curNode.next;
                    list1 = list1.next;
                } else {
                    curNode.next = list2;
                    curNode = curNode.next;
                    list2 = list2.next;
                }
            }
            // list1 list2 其中一个为 null, curNode 拼上另一个
            if (list1 == null) {
                curNode.next = list2;
            }
            if (list2 == null) {
                curNode.next = list1;
            }
            return preHead.next;
        }

        // 递归法
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null) {
                return list2;
            }
            if (list2 == null) {
                return list1;
            }
            if (list1.val <= list2.val) {
                ListNode head = list1;
                head.next = mergeTwoLists(list1.next, list2);
                return head;
            } else {
                ListNode head = list2;
                head.next = mergeTwoLists(list1, list2.next);
                return head;
            }
        }
    }
}
