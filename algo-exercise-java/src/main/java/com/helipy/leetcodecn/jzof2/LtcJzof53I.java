package com.helipy.leetcodecn.jzof2;

import java.util.Arrays;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof53
 * Desc: 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * https://leetcode.cn/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-07-08 11:48
 */
public class LtcJzof53I {

    class Solution {

        // 找到一个相等的,再依次向左右判断是否还相等
        public int search(int[] nums, int target) {
            int idx = Arrays.binarySearch(nums, target);
            if (idx < 0) {
                return 0;
            }
            int start = idx - 1, end = idx + 1;
            while (start >= 0) {
                if (nums[start] == target) {
                    --start;
                } else {
                    break;
                }
            }
            while (end < nums.length) {
                if (nums[end] == target) {
                    ++end;
                } else {
                    break;
                }
            }
            return end - start - 1;
        }
    }
}
