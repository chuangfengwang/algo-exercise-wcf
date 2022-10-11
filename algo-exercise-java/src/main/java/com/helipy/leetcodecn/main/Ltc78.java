package com.helipy.leetcodecn.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Pack:       com.helipy.leetcodecn.main
 * File:       Ltc78
 * Desc: 78. 子集
 * https://leetcode.cn/problems/subsets/
 * User:       chuangfengwang
 * CreateTime: 2022-08-04 12:44
 */
public class Ltc78 {
    class Solution {
        // 假定数组中元素不重复
        public List<List<Integer>> subsets(int[] nums) {
            if (nums == null || nums.length == 0) {
                return new LinkedList<>();
            }
            List<Integer> numsList = new ArrayList<>(nums.length);
            for (int val : nums) {
                numsList.add(val);
            }
            Arrays.sort(nums);
            List<List<Integer>> carryOut = new LinkedList<>();
            LinkedList<Integer> cur = new LinkedList<>();
            carryOut.add(cur);
            composeCore1(numsList, carryOut, cur, 0);
            return carryOut;
        }

        /**
         * 生成子集:
         * 依次考虑每个元素要不要加入当前生成的集合
         * 生成的子集按 nums 的字典序递增. 不含空集
         *
         * @param nums     输入输入
         * @param carryOut 携带结果
         * @param cur      当前考察的元素集合
         * @param idx      本次调用考虑第几个元素:要不要加入考察集合
         */
        private void composeCore1(List<Integer> nums, List<List<Integer>> carryOut, LinkedList<Integer> cur, int idx) {
            if (idx >= nums.size()) {
                return;
            }
            // 加入当前元素,生成一个结果,然后继续递归
            cur.add(nums.get(idx));  // 加入当前元素
            carryOut.add(new ArrayList<>(cur));
            composeCore1(nums, carryOut, cur, idx + 1);
            cur.pollLast();  // 弹出当前元素
            // 不加入当前元素递归
            composeCore1(nums, carryOut, cur, idx + 1);
        }
    }
}
