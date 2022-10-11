package com.helipy.leetcodecn.jzof2;


import java.util.HashMap;
import java.util.Map;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof03
 * Desc: 剑指 Offer 03. 数组中重复的数字
 * https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-07-06 22:43
 */
public class LtcJzof03 {
    static
    class Solution {

        // 词典计数解法: 从前到后找到第一个重复的
        public int findRepeatNumber1(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int idx = 0; idx < nums.length; ++idx) {
                if (map.containsKey(nums[idx])) {
                    return nums[idx];
                } else {
                    map.put(nums[idx], 1);
                }
            }
            return -1;
        }

        // 把数值 x 交换到第 x 位上去, 发现重复停止
        // 会修改原数组
        public int findRepeatNumber(int[] nums) {
            for (int idx = 0; idx < nums.length; ) {
                int tmp = nums[idx];
                if (tmp == idx) {
                    // 在正确的位置上
                    ++idx;
                    continue;
                }
                if (tmp == nums[tmp]) {
                    // 正确位置上有个和 tmp 相同的值
                    return tmp;
                }
                // 否则, 交换 tmp 和 nums[tmp] 的值
                nums[idx] = nums[tmp];
                nums[tmp] = tmp;
            }
            return -1;
        }

    }

    public static void main(String[] args) {
//        test1();
//        test2();
        test3();
    }

    static void test1() {
        Solution solution = new Solution();

        int[] nums = new int[]{2, 3, 1, 0, 2, 5, 3};
        int repeatNumber = solution.findRepeatNumber(nums);
        System.out.println(repeatNumber);  // 2
    }

    static void test2() {
        Solution solution = new Solution();

        int[] nums = new int[]{1, 1, 1};
        int repeatNumber = solution.findRepeatNumber(nums);
        System.out.println(repeatNumber);  // 1
    }

    static void test3() {
        Solution solution = new Solution();

        int[] nums = new int[]{3, 1, 2, 3};
        int repeatNumber = solution.findRepeatNumber(nums);
        System.out.println(repeatNumber);  // 3
    }

}
