package com.helipy.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Pack:       com.helipy.common
 * File:       LRUCache
 * Desc: 最近未访问缓存(Least Recently Used)
 * K 类型要正确实现 hashCode() 和 equals() 方法
 * User:       chuangfengwang
 * CreateTime: 2022-08-22 17:14
 */
public class LRUCache<K> {

    // value 用 node 存储
    public static class Node<K> {
        K key;  // 为了逐出时反查
        Object val;
        Node<K> pre;
        Node<K> next;
    }

    // 最近访问的节点放在 head 端
    private final Map<K, Node<K>> data = new HashMap<>();  // 存储数据的 map
    private final Node<K> preHead = new Node<>();  // 头节点前一个节点的指针
    private final Node<K> postTail = new Node<>();  // 尾节点后一个节点的指针

    public LRUCache() {
        preHead.next = postTail;
        postTail.pre = preHead;
    }

    // 把 cur 设为 head 节点
    private void resetHead(Node<K> cur) {
        // cur 成为新的 head
        Node<K> head = preHead.next;  // 先记下 head 指针

        preHead.next = cur;
        cur.pre = preHead;
        cur.next = head;  // head 成为 第二个
        head.pre = cur;
    }

    // 把存在的节点 cur 重新设为 head 节点
    private void resetExistAsHead(Node<K> cur) {
        // 把 cur 从链表中摘除
        Node<K> curNext = cur.next;  // 记下 cur 的下一个
        Node<K> curPre = cur.pre;
        curPre.next = curNext;
        curNext.pre = curPre;

        // cur 成为新的 head
        resetHead(cur);
    }

    // 写入
    public void put(K key, Object val) {
        if (data.containsKey(key)) {
            // 节点存在
            Node<K> cur = data.get(key);
            cur.val = val;
            // 把 cur 放到链表的头
            resetExistAsHead(cur);
        } else {
            // 节点不存在
            Node<K> cur = new Node<>();
            cur.val = val;
            cur.key = key;

            data.put(key, cur);

            // cur 成为新的 head
            resetHead(cur);
        }
    }

    // 读出
    public Object get(K key) {
        if (!data.containsKey(key)) {
            return null;
        }
        Node<K> cur = data.get(key);
        resetExistAsHead(cur);
        return cur.val;
    }

    // 逐出一个 key
    private Node<K> washoutOne() {
        Node<K> lastNode = postTail.pre;
        if (lastNode == preHead) {
            // 删无可删
            return null;
        }
        lastNode.pre.next = lastNode.next;
        lastNode.next.pre = lastNode.pre;

        data.remove(lastNode.key);
        return lastNode;
    }

    // 调试用的工具函数: 从前往后打印节点
    public void printLink() {
        Node<K> cur = preHead.next;
        while (cur != postTail) {
            System.out.print(cur.val + ",");
            cur = cur.next;
        }
    }

    // 调试用的工具函数: 从后往前打印节点
    public void printLinkInverse() {
        Node<K> cur = postTail.pre;
        while (cur != preHead) {
            System.out.print(cur.val + ",");
            cur = cur.pre;
        }
    }

    public void print() {
        System.out.print("从前往后: ");
        printLink();
        System.out.println();

        System.out.print("从后往前: ");
        printLinkInverse();
        System.out.println("\n");
    }

    public static void main(String[] args) {
        LRUCache<Integer> lruMap = new LRUCache<>();

        lruMap.put(1, 1);
        lruMap.put(2, 2);
        lruMap.put(3, 3);
        lruMap.put(4, 4);
        lruMap.print();

        Integer val = (Integer) lruMap.get(2);
        System.out.print("get val: " + val);
        System.out.println("\n");

        lruMap.print();
    }

}
