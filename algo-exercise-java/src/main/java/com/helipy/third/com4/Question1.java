package com.helipy.third.com4;

import java.util.ArrayList;
import java.util.List;

/**
 * Pack:       com.helipy.third.qianshou
 * File:       Question1
 * Desc:
 * User:       chuangfengwang
 * CreateTime: 2022-07-26 11:16
 */
public class Question1 {

    /**
     * 给定一个含有 n 个正整数的数组和一个正整数 target 。
     * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
     * <p>
     * 输入：target = 7, nums = [2,3,1,2,4,3]
     * 输出：2
     * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
     * <p>
     * 输入：target = 4, nums = [1,4,4]
     * 输出：1
     */

    public int findSubList(List<Integer> numList, int target) {
        if (numList == null) {
            return 0;
        }
        if (numList.size() == 0) {
            return 0;
        }

        int minLen = Integer.MAX_VALUE;
        for (int startIdx = 0; startIdx < numList.size() - 1; ++startIdx) {
            for (int endIdx = startIdx; endIdx < numList.size(); ++endIdx) {
                int sum = sumSubList(numList, startIdx, endIdx);
                if (sum == target) {
                    minLen = Math.min(minLen, endIdx - startIdx + 1);
                }
            }
        }
        if (minLen == Integer.MAX_VALUE) {
            return 0;
        } else {
            return minLen;
        }
    }

    private int sumSubList(List<Integer> list, int start, int end) {
        int sum = 0;
        for (int idx = start; idx <= end; ++idx) {
            sum += list.get(idx);
        }
        return sum;
    }


    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        List<Integer> numList = new ArrayList<>();
        for (int idx = 0; idx < nums.length; ++idx) {
            numList.add(nums[idx]);
        }
        int target = 7;
        Question1 question1 = new Question1();
        int len = question1.findSubList(numList, target);
        System.out.println(len);
    }


}
