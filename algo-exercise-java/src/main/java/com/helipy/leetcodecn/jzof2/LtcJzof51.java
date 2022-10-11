package com.helipy.leetcodecn.jzof2;

import com.alibaba.fastjson.JSON;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof51
 * Desc: 剑指 Offer 51. 数组中的逆序对
 * https://leetcode.cn/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-08-03 12:39
 */
public class LtcJzof51 {
    static
    class Solution {
        private int pairCount;  // 逆序对计数
        private int[] aux;  // 辅助数组

        // 归并排序(稳定排序),排序中计算逆序对. O(n*log(n)) 时间复杂度
        public int reversePairs(int[] nums) {
            if (nums == null || nums.length < 2) {
                return 0;
            }
            // 初始化
            aux = new int[nums.length];
            pairCount = 0;
            // 执行归并排序
            mergeSort(nums, 0, nums.length - 1);
            return pairCount;
        }

        private void mergeSort(int[] nums, int start, int end) {
            if (start >= end) {
                return;
            }
            int mid = (start + end) / 2;
            mergeSort(nums, start, mid);
            mergeSort(nums, mid + 1, end);
            merge(nums, start, mid, end);
        }

        // 合并 [start,mid] [mid+1,end] 两个区间
        private void merge(int[] nums, int start, int mid, int end) {
            int auxIdx = start;
            int frontIdx = start, postIdx = mid + 1;
            while (frontIdx <= mid && postIdx <= end) {
                if (nums[frontIdx] <= nums[postIdx]) {
                    // 前面的还在前面,没有产生逆序对
                    aux[auxIdx++] = nums[frontIdx];
                    ++frontIdx;
                } else {
                    // 后面的调整到了前面,产生了逆序对
                    aux[auxIdx++] = nums[postIdx];
                    ++postIdx;
                    pairCount += (mid - frontIdx + 1);
                }
            }
            // 依序排放不产生逆序对
            while (frontIdx <= mid) {
                aux[auxIdx++] = nums[frontIdx++];
            }
            while (postIdx <= end) {
                aux[auxIdx++] = nums[postIdx++];
            }
            // 排序好的内容复制回 nums
            if (end - start + 1 >= 0) {
                System.arraycopy(aux, start, nums, start, end - start + 1);
            }
        }

        // 冒泡排序,每次消除一个逆序对. n^2 时间复杂度. 超时
        public int reversePairs1(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            int pairNum = 0;
            int end = nums.length - 1;
            while (end >= 1) {
                boolean flag = false;  // 本轮有没有发生交换
                for (int idx = 0; idx < end; ++idx) {
                    if (nums[idx] > nums[idx + 1]) {
                        swap(nums, idx, idx + 1);
                        ++pairNum;
                        flag = true;
                    }
                }
                if (!flag) {
                    break;
                }
                --end;
            }
            return pairNum;
        }

        private void swap(int[] nums, int left, int right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }
    }

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        int[] nums = new int[]{7, 5, 6, 4};
        Solution solution = new Solution();
        System.out.println(solution.reversePairs(nums));
        System.out.println(JSON.toJSONString(nums));
    }
}
