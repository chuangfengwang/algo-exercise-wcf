package com.helipy.common;

/**
 * Pack:       com.helipy.common
 * File:       QuickSort
 * Desc: 快速排序
 * User:       chuangfengwang
 * CreateTime: 2022-07-09 17:00
 */
public class QuickSort {

    public void quickSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        quickSortCore(nums, 0, nums.length - 1);
    }

    private void quickSortCore(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivotIdx = partitionSort(arr, start, end);
        quickSortCore(arr, start, pivotIdx - 1);
        quickSortCore(arr, pivotIdx + 1, end);
    }

    // 返回用于分割的数字的索引. 索引区间: 闭区间 [start,end]
    public int partitionSort(int[] arr, int start, int end) {
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

}
