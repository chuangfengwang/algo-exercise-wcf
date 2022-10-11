package com.helipy.leetcodecn.jzof2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof62
 * Desc: 剑指 Offer 62. 圆圈中最后剩下的数字
 * https://leetcode.cn/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-07-27 15:54
 */
public class LtcJzof62 {
    static
    class Solution {
        // 迭代解法 f(n+1,m) = (f(n,m)+m)%(n+1)
        public int lastRemaining(int n, int m) {
            int res = 0;  // 最后一轮删除的索引(在最后一轮中的索引)
            for (int idx = 2; idx <= n; ++idx) {  // idx 表示倒数第几轮,从 1 开始
                res = (res + m) % idx;
            }
            return res;
        }


        // 递归解法: f(n,m) = (f(n-1,m) + m%n)%n
        public int lastRemaining3(int n, int m) {
            if (n < 1) {
                return -1;
            }
            return lastRemainingCore(n, m);
        }

        private int lastRemainingCore(int n, int m) {
            if (n == 1) {
                return 0;
            }
            return (lastRemainingCore(n - 1, m) + m) % n;
        }


        // ArrayList 模拟法: 第一个删除的索引 idx 为 m-1, 下一个为 (idx+m-1)%(剩余长度)
        public int lastRemaining2(int n, int m) {
            ArrayList<Integer> list = new ArrayList<>();
            list.ensureCapacity(n);
            for (int idx = 0; idx < n; ++idx) {
                list.add(idx);
            }
            int removeIdx = (m - 1) % list.size();
            while (list.size() > 1) {
                list.remove(removeIdx);
                removeIdx = (removeIdx + m - 1) % list.size();
            }
            return list.get(0);
        }

        ///////////////////////////////////////////////////////////////////////
        // 双向链表模拟法

        public static class Node {
            Integer val;
            Node prev;
            Node next;
        }

        public static class Circle {
            Node cur;
            int nodeNum = 0;

            public Circle(int n) {
                assert n > 0;
                Node head = new Node();
                head.val = 0;

                Node lastNode = head;
                Node curNode = head;
                for (int val = 1; val < n; ++val) {
                    curNode = new Node();
                    curNode.val = val;
                    lastNode.next = curNode;
                    curNode.prev = lastNode;

                    lastNode = curNode;
                }
                curNode.next = head;
                head.prev = curNode;

                cur = head;
                nodeNum = n;
            }

            // 删除第 m 个(0-base)
            public int remove(int m) {
                m %= nodeNum;
                while (m > 0) {
                    cur = cur.next;
                    --m;
                }
                if (nodeNum == 1) {
                    int val = cur.val;
                    cur = null;
                    // System.out.print(val + ",");
                    return val;
                }
                Node last = cur.prev;
                Node next = cur.next;
                last.next = next;
                next.prev = last;
                --nodeNum;

                int val = cur.val;
                cur = cur.next;
                // System.out.print(val + ",");
                return val;
            }
        }

        // 用双向链表模拟过程: 会超时
        public int lastRemaining1(int n, int m) {
            Circle circle = new Circle(n);
            while (circle.nodeNum > 1) {
                circle.remove(m - 1);
            }
            int val = circle.cur.val;
            return val;
        }
    }

    public static void main(String[] args) {
//        test1();
//        test2();
        test3();
    }

    private static void test1() {
        Solution solution = new Solution();
        int out = solution.lastRemaining(5, 3);
        System.out.println(out);  // 2
    }

    private static void test2() {
        Solution solution = new Solution();
        int out = solution.lastRemaining(10, 17);
        System.out.println(out);  // 2
    }

    private static void test3() {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 5; ++i) {
            list.add(i);
        }

//        Iterator<Integer> iterator = list.iterator();
//        // 认为 iterator 是两个元素的间隙位置
//        iterator.next();  // remove 之前, 需要至少一次 next() 调用
//        iterator.remove();  // remove 之后, next 自动是下一个. remove 删除的是间隙之前的元素
//        System.out.println(iterator.next());

        ListIterator<Integer> iterator = list.listIterator();
        // 认为 iterator 是两个元素的间隙位置
        iterator.next();  // remove 之前, 需要至少一次 next() 调用
        iterator.remove();  // remove 之后, next 自动是下一个. remove 删除的是间隙之前的元素
        System.out.println(iterator.next());
        System.out.println(iterator.previous());
        iterator.remove();
        System.out.println(list);
    }

}
