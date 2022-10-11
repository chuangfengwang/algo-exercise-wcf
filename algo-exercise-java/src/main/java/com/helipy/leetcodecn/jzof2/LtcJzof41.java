package com.helipy.leetcodecn.jzof2;

import java.util.PriorityQueue;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof41
 * Desc: 剑指 Offer 41. 数据流中的中位数
 * https://leetcode.cn/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-07-24 19:34
 */
public class LtcJzof41 {
    static
    class MedianFinder {

        // 添加的数据分两部分存储在两个堆里,前半部分最大堆,后半部分最小堆
        private PriorityQueue<Integer> prevMaxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        private PriorityQueue<Integer> postMinHeap = new PriorityQueue<>();

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
        }

        public void addNum(int num) {
            if (prevMaxHeap.isEmpty()) {
                prevMaxHeap.add(num);
                return;
            }
            Integer prevMax = prevMaxHeap.peek();
            if (num <= prevMax) {
                // 比左边最大的小(或相等),放左边
                prevMaxHeap.add(num);
                reBalance();
            } else {
                // 比左边最大的大,放右边
                postMinHeap.add(num);
                reBalance();
            }
        }

        public double findMedian() {
            if (prevMaxHeap.isEmpty()) {
                return Double.MIN_NORMAL;
            }
            if (prevMaxHeap.size() > postMinHeap.size()) {
                return prevMaxHeap.peek();
            }
            return (prevMaxHeap.peek() + postMinHeap.peek()) / 2.0;
        }

        // 平衡两个堆的数量
        private void reBalance() {
            // 数量相等, 或做半边多一个, 是平衡的
            if (prevMaxHeap.size() == postMinHeap.size() || prevMaxHeap.size() - postMinHeap.size() == 1) {
                return;
            }
            // 左边多
            if (prevMaxHeap.size() - postMinHeap.size() > 1) {
                // 左边取最大的, 放到右边
                Integer val = prevMaxHeap.poll();
                postMinHeap.add(val);
                return;
            }
            // 右边多
            if (prevMaxHeap.size() - postMinHeap.size() < 0) {
                // 右边取最小的, 放到左边
                Integer val = postMinHeap.poll();
                prevMaxHeap.add(val);
            }
        }
    }

    /**
     * Your MedianFinder object will be instantiated and called as such:
     * MedianFinder obj = new MedianFinder();
     * obj.addNum(num);
     * double param_2 = obj.findMedian();
     */

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());  // 2.0
    }
}
