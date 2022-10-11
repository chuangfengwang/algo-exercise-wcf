package com.helipy.leetcodecn.jzof2;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof40
 * Desc: 面试题40. 最小的k个数
 * https://leetcode.cn/problems/zui-xiao-de-kge-shu-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-07-24 15:39
 */
public class LtcJzof40 {
    static
    class Solution {

        // 快排分治,直到选择的切分数据正好是第 k-1 个(0-based)
        public int[] getLeastNumbers(int[] arr, int k) {
            if (arr == null || k <= 0 || arr.length == 0) {
                return new int[0];
            }
            if (k > arr.length) {
                return arr;
            }
            int start = 0, end = arr.length - 1;
            int partitionIdx = partitionSort(arr, start, end);
            while (partitionIdx != k - 1) {
                if (partitionIdx < k - 1) {
                    start = partitionIdx + 1;
                    partitionIdx = partitionSort(arr, start, end);
                } else if (partitionIdx > k - 1) {
                    end = partitionIdx - 1;
                    partitionIdx = partitionSort(arr, start, end);
                }
            }
            return Arrays.copyOfRange(arr, 0, k);
        }


        // 返回用于分割的数字的索引. 索引区间: 闭区间 [start,end]
        private int partitionSort(int[] arr, int start, int end) {
            assert arr != null && start >= 0 && end < arr.length;
            int pivotIdx = randomIndex(start, end);  // 随机选择一个参考值
            swap(arr, pivotIdx, end);  // 参考值放在末尾
            pivotIdx = end;
            int smallThanPivotIdx = start - 1;  // 用于指示比 pivot 小的索引到哪里了
            for (int idx = start; idx < end; ++idx) {
                if (arr[idx] < arr[pivotIdx]) {
                    ++smallThanPivotIdx;  // 下一个比 pivot 小的位置
                    swap(arr, smallThanPivotIdx, idx);  // 交换当前位置与 smallThanPivotIdx 位置的值
                }
            }
            // pivot 放到它的位置上
            ++smallThanPivotIdx;  // 这就是参考值要放到的位置
            swap(arr, smallThanPivotIdx, pivotIdx);
            return smallThanPivotIdx;
        }

        // 在闭区间 [start,end] 内随机选一个值
        private int randomIndex(int start, int end) {
            assert start <= end;
            return end;  // 这里选择了最后一个
        }

        // 交换 arr 里 left 和 right 位置上的值
        private void swap(int[] arr, int left, int right) {
            if (left == right) {
                return;
            }
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
        }


        // 用最大堆记录结果
        public int[] getLeastNumbers1(int[] arr, int k) {
            if (k <= 0) {
                return new int[]{};
            }
            if (arr == null || arr.length <= k) {
                return arr;
            }
            PriorityQueue<Integer> heap = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);  // 大顶堆
            for (int val : arr) {
                if (heap.size() < k) {
                    heap.add(val);
                } else if (heap.peek() > val) {
                    heap.poll();
                    heap.add(val);
                }
            }
            int[] res = new int[k];
            for (int idx = 0; idx < k; ++idx) {
                Integer val = heap.poll();
                if (val != null) {
                    res[idx] = val;
                }
            }
            return res;
        }
    }


    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        int[] arr = new int[]{3, 2, 1, 0};
        int k = 2;
        Solution solution = new Solution();
        int[] leastNumbers = solution.getLeastNumbers(arr, k);
        System.out.println(JSON.toJSONString(leastNumbers));
    }

}
