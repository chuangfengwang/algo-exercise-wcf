package com.helipy.leetcodecn.jzof2;


import com.helipy.leetcodecn.Pair;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof06
 * Desc: 剑指 Offer 06. 从尾到头打印链表
 * https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-07-06 00:24
 */
public class LtcJzof06 {

    //     Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public int[] reversePrint(ListNode head) {
            if (head == null) {
                return new int[0];
            }

            // 倒转链表
            Pair<ListNode, Integer> pair = reverseList(head);

            ListNode curr = pair.getKey();
            int nodeNum = pair.getValue();
            // 输出数值
            int[] res = new int[nodeNum];
            int resIdx = 0;
            while (curr != null) {
                res[resIdx] = curr.val;

                curr = curr.next;
                ++resIdx;
            }

            // 恢复链表
            reverseList(pair.getKey());

            return res;
        }

        // 倒转链表
        private Pair<ListNode, Integer> reverseList(ListNode head) {
            if (head == null) {
                return new Pair<>(null, 0);
            }

            int nodeNum = 1;
            // 倒转链表
            ListNode curr = head;
            ListNode next = head.next;
            curr.next = null;
            ListNode nextNext;
            while (next != null) {
                nextNext = next.next;
                next.next = curr;

                curr = next;
                next = nextNext;
                ++nodeNum;
            }
            return new Pair<>(curr, nodeNum);
        }
    }
}
