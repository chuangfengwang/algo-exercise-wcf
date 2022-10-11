package com.helipy.leetcodecn.main;

/**
 * Pack:       com.helipy.leetcodecn.main
 * File:       Ltc876
 * Desc:
 * User:       chuangfengwang
 * CreateTime: 2022-07-19 14:46
 */
public class Ltc876 {
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
        public ListNode middleNode(ListNode head) {
            if (head == null) {
                return null;
            }
            // 节点数量
            int nodeNum = 0;
            ListNode curNode = head;
            while (curNode != null) {
                ++nodeNum;
                curNode = curNode.next;
            }
            // 找到中间节点,向后走这么多步
            int midIdx = nodeNum / 2;
            curNode = head;
            for (int idx = 0; idx < midIdx; ++idx) {
                curNode = curNode.next;
            }
            return curNode;
        }
    }
}
