package com.helipy.leetcodecn.main;

/**
 * Pack:       com.helipy.leetcodecn.main
 * File:       Ltc26
 * Desc: 26. 删除有序数组中的重复项
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
 * User:       chuangfengwang
 * CreateTime: 2022-07-19 15:37
 */
public class Ltc26 {
    class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums.length <= 1) {
                return nums.length;
            }
            int sortedIdx = 0;
            int curIdx = 1;
            while (curIdx < nums.length) {
                if (nums[curIdx] > nums[sortedIdx]) {
                    // 不重复
                    ++sortedIdx;
                    if (curIdx != sortedIdx) {
                        nums[sortedIdx] = nums[curIdx];
                    }
                }
                ++curIdx;
            }
            return sortedIdx + 1;
        }
    }
}
