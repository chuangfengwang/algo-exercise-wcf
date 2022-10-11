package com.helipy.leetcodecn.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Pack:       com.helipy.leetcodecn.main
 * File:       Ltc90
 * Desc: 90. 子集 II
 * https://leetcode.cn/problems/subsets-ii/
 * User:       chuangfengwang
 * CreateTime: 2022-08-04 12:51
 */
public class Ltc90 {
    class Solution {
        // 假定数组中元素会重复
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            if (nums == null || nums.length == 0) {
                return new LinkedList<>();
            }
            List<Integer> numList = new ArrayList<>(nums.length);
            for (int val : nums) {
                numList.add(val);
            }
            numList.sort(null);
            List<List<Integer>> carryOut = new LinkedList<>();
            LinkedList<Integer> cur = new LinkedList<>();
            carryOut.add(cur);
            composeCore2(numList, carryOut, cur, 0, false);
            return carryOut;
        }

        /**
         * 生成子集:
         * 依次考虑每个元素要不要加入当前生成的集合.
         * 如果当前元素和上一个相同,且上一个没有加入当前集合,则跳过当前元素
         * 生成的子集按 nums 的字典序递增. 不含空集
         *
         * @param nums     输入输入
         * @param carryOut 携带结果
         * @param cur      当前考察的元素集合
         * @param idx      本次调用考虑第几个元素:要不要加入考察集合
         */
        private void composeCore2(List<Integer> nums, List<List<Integer>> carryOut,
                                  LinkedList<Integer> cur, int idx, boolean lastUsed) {
            if (idx >= nums.size()) {
                return;
            }
            // 不加入当前元素递归
            composeCore2(nums, carryOut, cur, idx + 1, false);

            // 如果当前元素和上一个相同,且上一个没有加入当前集合,则跳过当前元素
            if (!lastUsed && idx > 0 && Objects.equals(nums.get(idx), nums.get(idx - 1))) {
                return;
            }
            // 加入当前元素,生成一个结果,然后继续递归
            cur.add(nums.get(idx));  // 加入当前元素
            carryOut.add(new ArrayList<>(cur));
            composeCore2(nums, carryOut, cur, idx + 1, true);
            cur.pollLast();  // 弹出当前元素
        }
    }
}
