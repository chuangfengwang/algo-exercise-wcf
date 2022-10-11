package com.helipy.leetcodecn.main;

import com.helipy.leetcodecn.ListNode;
import com.helipy.leetcodecn.LtcUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Pack:       com.helipy.leetcodecn.main
 * File:       Ltc328
 * Desc: 328. 奇偶链表
 * https://leetcode.cn/problems/odd-even-linked-list/
 * User:       chuangfengwang
 * CreateTime: 2022-08-08 18:14
 */
public class Ltc328 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    static
    class Solution {
        public ListNode oddEvenList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            // 分奇偶
            ListNode leftHead = head, left = leftHead;
            ListNode rightHead = head.next, right = rightHead;

            int idx = 3;  // 第一个节点编号为 1
            ListNode cur = rightHead.next;
            while (cur != null) {
                if ((idx & 1) == 0) {
                    // 偶数
                    right.next = cur;
                    right = right.next;
                } else {
                    // 奇数
                    left.next = cur;
                    left = left.next;
                }
                // 处理下一个节点
                ++idx;
                cur = cur.next;
            }
            // 两个链表拼接
            left.next = rightHead;
            right.next = null;
            return leftHead;
        }
    }

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        String input = "[1,2,3,4,5]";
        ListNode head = ListNode.parseListNodeFromJsonStr(input);
        Solution solution = new Solution();
        ListNode newHead = solution.oddEvenList(head);
        System.out.println(ListNode.convertToJson(newHead));
    }
}
