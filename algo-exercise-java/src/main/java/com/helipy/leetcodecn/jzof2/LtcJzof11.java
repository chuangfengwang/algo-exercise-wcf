package com.helipy.leetcodecn.jzof2;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof11
 * Desc: 剑指 Offer 11. 旋转数组的最小数字
 * https://leetcode.cn/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-07-09 15:05
 */
public class LtcJzof11 {

    static
    class Solution {

        // 暴力
        public int minArray1(int[] numbers) {
            if (numbers.length <= 0) {
                return Integer.MAX_VALUE;
            }
            int min = Integer.MAX_VALUE;
            for (int idx = 0; idx < numbers.length; ++idx) {
                if (numbers[idx] < min) {
                    min = numbers[idx];
                }
            }
            return min;
        }

        // 二分法
        public int minArray(int[] numbers) {
            if (numbers.length <= 0) {
                return Integer.MAX_VALUE;
            }
            int start = 0, end = numbers.length - 1;
            int mid = (start + end) >> 1;  // 中间位置 start <= mid < end
            while (start < end) {
                if (numbers[mid] > numbers[end]) {
                    // mid 在前半边, 最小值在右边
                    start = mid + 1;
                } else if (numbers[mid] == numbers[end]) {
                    // end 位置可以舍弃, 最小值在哪边不能确定
                    end -= 1;
                } else {
                    // mid 在后半边, 最小值在左边
                    end = mid - 1;
                }
            }
            return end;
        }
    }


    public static void main(String[] args) {
        test1();
//        test2();
    }

    static void test1() {
        Solution solution = new Solution();
        int[] nums = new int[]{3, 4, 5, 1, 2};
        int idx = solution.minArray(nums);
        System.out.println(idx);
//        assert idx == solution.minArray1(nums);
    }

    static void test2() {
        Solution solution = new Solution();
        int[] nums = new int[]{2, 2, 2, 0, 1};
        int idx = solution.minArray(nums);
        System.out.println(idx);
//        assert idx == solution.minArray1(nums);
    }
}
