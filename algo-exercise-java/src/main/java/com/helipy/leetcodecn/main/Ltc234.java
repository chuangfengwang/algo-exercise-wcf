package com.helipy.leetcodecn.main;

import com.helipy.leetcodecn.ListNode;

/**
 * Pack:       com.helipy.leetcodecn.main
 * File:       Ltc234
 * Desc: 234. 回文链表
 * https://leetcode.cn/problems/palindrome-linked-list/
 * User:       chuangfengwang
 * CreateTime: 2022-08-07 00:26
 */
public class Ltc234 {
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
        public boolean isPalindrome(ListNode head) {
            if (head == null) {
                return false;
            }
            // 计算链表数量
            int nodeNum = 0;
            ListNode cur = head;
            while (cur != null) {
                ++nodeNum;
                cur = cur.next;
            }
            // 寻找后半段开始节点
            int aimNode;
            if (nodeNum % 2 == 0) {
                aimNode = nodeNum / 2;
            } else {
                aimNode = (nodeNum + 1) / 2;
            }
            ListNode post = new ListNode(-1, head);
            int count = -1;
            while (count < aimNode) {
                post = post.next;
                ++count;
            }
            // 反转后半部分链表
            post = reverseList(post);
            ListNode pre = head;
            while (pre != null && post != null) {
                if (pre.val != post.val) {
                    return false;
                }
                pre = pre.next;
                post = post.next;
            }
            return true;
        }

        // 反转链表
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode virtual = new ListNode(-1, head);  // 虚节点
            ListNode pre = virtual;
            ListNode cur = head;
            ListNode next = head.next;
            while (next != null) {
                cur.next = (pre == virtual ? null : pre);
                pre = cur;
                cur = next;
                next = next.next;
            }
            cur.next = (pre == virtual ? null : pre);
            return cur;
        }
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test1() {
        String input = "[1,2,3,2,1]";
        ListNode head = ListNode.parseListNodeFromJsonStr(input);
        Solution solution = new Solution();
        // System.out.println(ListNode.convertToJson(solution.reverseList(head)));
        System.out.println(solution.isPalindrome(head));  // true
    }

    private static void test2() {
        String input = "[1,2,2,1]";
        ListNode head = ListNode.parseListNodeFromJsonStr(input);
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(head));  // true
    }

    private static void test3() {
        String input = "[1,2]";
        ListNode head = ListNode.parseListNodeFromJsonStr(input);
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(head));  // false
    }
}
