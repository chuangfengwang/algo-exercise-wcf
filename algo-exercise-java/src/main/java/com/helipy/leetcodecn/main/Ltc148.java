package com.helipy.leetcodecn.main;

import com.helipy.leetcodecn.ListNode;
import com.helipy.leetcodecn.Pair;

import java.util.ArrayList;

/**
 * Pack:       com.helipy.leetcodecn.main
 * File:       Ltc148
 * Desc: 148. 排序链表
 * https://leetcode.cn/problems/sort-list/
 * User:       chuangfengwang
 * CreateTime: 2022-08-08 18:39
 */
public class Ltc148 {
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

        // 合并法: 2个2个, 4个4个, ...
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            // 计算链表长度
            int allLen = 0;
            ListNode cur = head;
            while (cur != null) {
                ++allLen;
                cur = cur.next;
            }

            int subLen = 1;
            ListNode start = head, end, newHead = head, lastEnd;
            while (subLen < allLen) {
                end = nextSubList(start, subLen);
                if (end == null) {
                    return newHead;
                }
                Pair<ListNode, ListNode> pair = merge(start, end, subLen);
                newHead = pair.getKey();
                lastEnd = pair.getValue();
                start = lastEnd.next;
                while (start != null) {
                    end = nextSubList(start, subLen);
                    if (end == null) {
                        break;
                    }
                    pair = merge(start, end, subLen);
                    lastEnd.next = pair.getKey();
                    lastEnd = pair.getValue();
                    start = lastEnd.next;
                }
                // 长度翻倍
                subLen *= 2;
                start = newHead;
            }
            return newHead;
        }

        public ListNode nextSubList(ListNode head, int skipLen) {
            for (int idx = 0; idx < skipLen; ++idx) {
                head = head.next;
                if (head == null) {
                    return null;
                }
            }
            return head;
        }

        // 合并两个链表,每个链表最多 maxLen 个节点. 返回 头节点 和 尾节点
        public Pair<ListNode, ListNode> merge(ListNode left, ListNode right, int maxLen) {
            int leftCount = 0, rightCount = 0;
            // 找 head
            ListNode head, last, cur = right;
            if (left.val <= right.val) {
                head = left;
                left = left.next;
                ++leftCount;
            } else {
                head = right;
                right = right.next;
                ++rightCount;
            }
            // 左右都还有节点,谁小先拼谁
            last = head;
            while (leftCount < maxLen && rightCount < maxLen && left != null && right != null) {
                if (left.val <= right.val) {
                    cur = left;
                    ++leftCount;
                    left = left.next;
                } else {
                    cur = right;
                    ++rightCount;
                    right = right.next;
                }
                last.next = cur;
                last = last.next;
            }
            // 剩余节点拼到末尾
            while (leftCount < maxLen && left != null) {
                cur = left;
                ++leftCount;
                left = left.next;
                last.next = cur;
                last = last.next;
            }
            while (rightCount < maxLen && right != null) {
                cur = right;
                ++rightCount;
                right = right.next;
                last.next = cur;
                last = last.next;
            }
            cur.next = right;
            return new Pair<>(head, cur);
        }

        // 借助数组排序: 时间复杂度 O(n*log(n)), 空间复杂度 O(n)
        public ListNode sortList1(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            // 转为数组
            ArrayList<ListNode> list = new ArrayList<>();
            ListNode cur = head;
            while (cur != null) {
                list.add(cur);
                cur = cur.next;
            }

            // 排序
            list.sort((o1, o2) -> o1.val - o2.val);
            // 重新构建 List
            ListNode newHead = list.get(0);
            ListNode last = newHead;
            ListNode cur2 = null;
            for (int idx = 1; idx < list.size(); ++idx) {
                cur2 = list.get(idx);
                last.next = cur2;
                last = last.next;
            }
            if (cur2 != null) {
                cur2.next = null;
            }

            return newHead;
        }
    }

    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        String input = "[4,2,1,3,0]";
        ListNode head = ListNode.parseListNodeFromJsonStr(input);
        Solution solution = new Solution();
        ListNode newHead = solution.sortList(head);
        System.out.println(ListNode.convertToJson(newHead));
    }

    private static void test2() {
        String input = "[4,3,2,1]";
        ListNode head = ListNode.parseListNodeFromJsonStr(input);
        Solution solution = new Solution();
        ListNode newHead = solution.sortList(head);
        System.out.println(ListNode.convertToJson(newHead));
    }
}
