package com.helipy.leetcodecn.jzof2;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof56I
 * Desc: 剑指 Offer 56 - I. 数组中数字出现的次数
 * https://leetcode.cn/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-07-26 13:14
 */
public class LtcJzof56I {
    class Solution {
        // 用异或得到的数字, 其中一个1位把数据分成两组, 这样每组里就只有一个不重复的数字了
        public int[] singleNumbers(int[] nums) {
            if (nums == null) {
                return null;
            }
            if (nums.length < 2) {
                return null;
            }
            // 求所有数字的异或
            int xor = 0;
            for (int num : nums) {
                xor ^= num;
            }
            // 找到结果中的一个1位
            int flag = 1;
            while ((xor & flag) == 0) {
                flag = flag << 1;
            }
            // 按 flag 标识的 1 进行分组
            int num1 = 0, num2 = 0;
            for (int num : nums) {
                if ((num & flag) == 0) {
                    num1 ^= num;
                } else {
                    num2 ^= num;
                }
            }
            return new int[]{num1, num2};
        }
    }


}
