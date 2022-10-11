package com.helipy.third.com2;

/**
 * Pack:       com.helipy.third.kuaishou
 * File:       Question1
 * Desc: 链表表示的数字相加
 * User:       chuangfengwang
 * CreateTime: 2022-09-01 20:45
 */
public class Question1 {

    static class Node {
        int val;
        Node next;
    }


    public Node add(Node leftRoot, Node rightRoot) {
        if (leftRoot == null && rightRoot == null) {
            throw new RuntimeException("invalid input");
        }
        if (leftRoot == null) {
            return rightRoot;
        }
        if (rightRoot == null) {
            return leftRoot;
        }

        Node resRoot = new Node();
        Node lastResNode = null;
        Node resCur = resRoot;

        int carry = 0;
        Node leftCur = leftRoot;
        Node rightCur = rightRoot;
        while (leftCur != null && rightCur != null) {

            int sum = leftCur.val + rightCur.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            resCur.val = sum;

            // 准备下一个相加
            leftCur = leftCur.next;
            rightCur = rightCur.next;
            lastResNode = resCur;
            Node nextNode = new Node();
            resCur.next = nextNode;
            resCur = resCur.next;
        }

        // 左边还有节点
        while (leftCur != null) {
            int sum = leftCur.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            resCur.val = sum;

            // 准备下一个相加
            leftCur = leftCur.next;
            lastResNode = resCur;
            Node nextNode = new Node();
            resCur.next = nextNode;
            resCur = resCur.next;
        }

        // 右边还有节点
        while (rightCur != null) {
            int sum = rightCur.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            resCur.val = sum;

            // 准备下一个相加
            rightCur = rightCur.next;
            lastResNode = resCur;
            Node nextNode = new Node();
            resCur.next = nextNode;
            resCur = resCur.next;
        }

        if (carry > 0) {
            resCur.val = carry;
        } else {
            // 删除最后一个节点
            lastResNode.next = null;
        }

        return resRoot;
    }

    public static void main(String[] args) {

    }

}
