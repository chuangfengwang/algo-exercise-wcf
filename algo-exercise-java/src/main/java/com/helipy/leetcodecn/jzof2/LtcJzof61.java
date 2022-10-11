package com.helipy.leetcodecn.jzof2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof61
 * Desc: 剑指 Offer 61. 扑克牌中的顺子
 * https://leetcode.cn/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-07-24 15:12
 */
public class LtcJzof61 {
    static
    class Solution {
        public boolean isStraight(int[] nums) {
            List<Integer> numsList = new ArrayList<>(nums.length);
            for (int val : nums) {
                numsList.add(val);
            }
            numsList.sort((o1, o2) -> o1 - o2);
            int zeroNum = 0, spaceNum = 0;
            for (int idx = 0; idx < numsList.size(); ++idx) {
                if (0 == numsList.get(idx)) {
                    ++zeroNum;
                } else if (idx >= 1) {
                    if (Objects.equals(numsList.get(idx), numsList.get(idx - 1))) {
                        return false;
                    }
                    if (numsList.get(idx - 1) != 0) {
                        spaceNum += numsList.get(idx) - numsList.get(idx - 1) - 1;
                    }
                }
            }
            return zeroNum >= spaceNum;
        }
    }


    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
        test4();
    }

    public static void test1() {
        int[] nums = {1, 2, 3, 4, 5};
        Solution solution = new Solution();
        boolean out = solution.isStraight(nums);
        System.out.println(out);
    }

    public static void test2() {
        int[] nums = {0, 0, 8, 5, 4};
        Solution solution = new Solution();
        boolean out = solution.isStraight(nums);
        System.out.println(out);
    }

    public static void test3() {
        int[] nums = {0, 0, 2, 2, 5};
        Solution solution = new Solution();
        boolean out = solution.isStraight(nums);
        System.out.println(out);
    }
    public static void test4() {
        int[] nums = {8,2,9,7,10};
        Solution solution = new Solution();
        boolean out = solution.isStraight(nums);
        System.out.println(out);
    }
}
