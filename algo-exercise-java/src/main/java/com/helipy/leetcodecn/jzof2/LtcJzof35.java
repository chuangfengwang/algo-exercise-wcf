package com.helipy.leetcodecn.jzof2;

import java.util.HashMap;
import java.util.Map;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof35
 * Desc: 剑指 Offer 35. 复杂链表的复制
 * https://leetcode.cn/problems/fu-za-lian-biao-de-fu-zhi-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-07-08 00:29
 */
public class LtcJzof35 {

    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    class Solution {
        public Node copyRandomList1(Node head) {
            if (head == null) {
                return null;
            }

            // 复制常规链表
            Node newHead = new Node(head.val);
            Node iter = head;
            Node newIter = newHead;
            while (iter.next != null) {
                Node newNext = new Node(iter.next.val);
                newIter.next = newNext;

                iter = iter.next;
                newIter = newNext;
            }

            // 在新链表中找到 random 所在节点(相同位置上的节点)
            iter = head;
            newIter = newHead;
            while (newIter != null && iter != null) {
                Node oldRandom = iter.random;
                if (oldRandom != null) {
                    // 修改新链表节点的 random 为新节点
                    newIter.random = findEqualNode(head, oldRandom, newHead);
                }

                iter = iter.next;
                newIter = newIter.next;
            }

            return newHead;
        }

        // 找到新链表中和 oldNode 等位置的节点
        private Node findEqualNode(Node oldHead, Node oldNode, Node newHead) {
            Node oldCur = oldHead, newCur = newHead;
            while (oldCur != oldNode) {
                oldCur = oldCur.next;
                newCur = newCur.next;
            }
            return newCur;
        }

        // 复制时记录每个旧节点对应的新节点。 因为确定额外指针是通过旧节点的旧random节点确定的。
        public Node copyRandomList2(Node head) {
            if (head == null) {
                return null;
            }

            // key:旧节点，value:新节点
            Map<Node, Node> nodeMap = new HashMap<>();

            // 复制常规链表,顺便建立新旧节点映射
            Node newHead = new Node(head.val);
            nodeMap.put(head, newHead);
            Node iter = head;
            Node newIter = newHead;
            while (iter.next != null) {
                Node newNext = new Node(iter.next.val);
                newIter.next = newNext;
                nodeMap.put(iter.next, newNext);

                iter = iter.next;
                newIter = newNext;
            }

            // 给新节点找新 random 节点,通过map查找
            iter = head;
            newIter = newHead;
            while (iter != null && newIter != null) {
                if (iter.random != null) {
                    newIter.random = nodeMap.get(iter.random);
                }

                iter = iter.next;
                newIter = newIter.next;
            }

            return newHead;
        }

        // 新节点插入旧节点后面, 再次遍历时赋值新 random
        public Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }

            // 复制新节点,插入旧节点之后
            Node curr = head;
            while (curr != null) {
                Node newNode = new Node(curr.val);
                newNode.next = curr.next;
                curr.next = newNode;

                curr = newNode.next;
            }
            // 再次遍历, 通过 next 找到新节点及新 random
            curr = head;
            Node newCurr = curr.next;
            while (curr != null) {
                if (curr.random != null) {
                    newCurr.random = curr.random.next;
                }

                // 下一个节点
                if (newCurr.next != null) {
                    curr = newCurr.next;
                    newCurr = curr.next;
                } else {
                    curr = null;
                }
            }

            // 分解开新旧链表
            Node newHead = head.next;
            curr = head;
            newCurr = newHead;
            while (curr != null) {
                curr.next = curr.next.next;
                curr = curr.next;
                if (newCurr.next != null) {
                    newCurr.next = newCurr.next.next;
                    newCurr = newCurr.next;
                }
            }
            return newHead;
        }
    }
}
