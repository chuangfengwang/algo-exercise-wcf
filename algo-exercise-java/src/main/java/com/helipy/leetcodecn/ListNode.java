package com.helipy.leetcodecn;

import com.alibaba.fastjson.JSON;

import java.util.LinkedList;
import java.util.List;

/**
 * Pack:       com.helipy.leetcodecn.main
 * File:       ListNode
 * Desc:
 * User:       chuangfengwang
 * CreateTime: 2022-08-06 23:59
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }

    ///////////////////////////////////////////////////////////////////////////

    // 从 json 构造链表
    public static ListNode parseListNodeFromJsonStr(String jsonString) {
        List<Integer> valList = JSON.parseArray(jsonString, Integer.class);
        return parseListNodeFromList(valList);
    }

    // 从 valList 构造链表
    public static ListNode parseListNodeFromList(List<Integer> valList) {
        if (valList == null || valList.isEmpty()) {
            return null;
        }
        ListNode head = new ListNode(valList.get(0));
        ListNode cur = head;
        for (int idx = 1; idx < valList.size(); ++idx) {
            ListNode node = new ListNode(valList.get(idx));
            cur.next = node;
            cur = node;
        }
        return head;
    }

    // 转换为值的链表
    public static List<Integer> convertToList(ListNode head) {
        if (head == null) {
            return new LinkedList<>();
        }
        ListNode cur = head;
        List<Integer> valList = new LinkedList<>();
        while (cur != null) {
            valList.add(cur.val);
            cur = cur.next;
        }
        return valList;
    }

    // 转换为 json
    public static String convertToJson(ListNode head) {
        List<Integer> valList = convertToList(head);
        return JSON.toJSONString(valList);
    }
}
