package com.helipy.leetcodecn.main;

import com.helipy.leetcodecn.ListNode;

/**
 * Pack:       com.helipy.leetcodecn.main
 * File:       Ltc19
 * Desc: 19. 删除链表的倒数第 N 个结点
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 * User:       chuangfengwang
 * CreateTime: 2022-08-07 00:09
 */
public class Ltc19 {
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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (head == null) {
                return null;
            }
            // 计算链表数量
            int nodeNum = 0;
            ListNode cur = head;
            while (cur != null) {
                ++nodeNum;
                cur = cur.next;
            }
            // 倒数的太多了,不用删
            if (n > nodeNum) {
                return head;
            }
            // 找到倒数第 n 个: 正数第 nodeNum-n 个(0-base)
            ListNode pre = new ListNode();
            pre.next = head;
            int count = -1;
            while (count < nodeNum - n - 1) {  // 前一个是 nodeNum-n-1 个
                pre = pre.next;
                ++count;
            }
            cur = pre.next;  // 要删除的节点
            pre.next = cur.next;
            if (cur == head) {
                return head.next;
            }
            return head;
        }
    }

    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        String input = "[1,2,3,4,5]";
        int n = 2;
        ListNode head = ListNode.parseListNodeFromJsonStr(input);
        Solution solution = new Solution();
        ListNode res = solution.removeNthFromEnd(head, n);
        System.out.println(ListNode.convertToJson(res));
    }

    private static void test2() {
        String input = "[1,2,3,4,5]";
        int n = 5;
        ListNode head = ListNode.parseListNodeFromJsonStr(input);
        Solution solution = new Solution();
        ListNode res = solution.removeNthFromEnd(head, n);
        System.out.println(ListNode.convertToJson(res));
    }
}
