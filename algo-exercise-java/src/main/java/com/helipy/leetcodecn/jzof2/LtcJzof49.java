package com.helipy.leetcodecn.jzof2;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof49
 * Desc: 剑指 Offer 49. 丑数
 * https://leetcode.cn/problems/chou-shu-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-08-02 23:44
 */
public class LtcJzof49 {
    static
    class Solution {
        public int nthUglyNumber(int n) {
            if (n < 1) {
                return 0;
            }
            int[] nums = new int[n];  // 记录已经生成的丑数
            nums[0] = 1;
            int nextIdx = 1;  // 下一个丑数的索引 0-base
            int mul2pre = 0, mul3pre = 0, mul5pre = 0;  // 下一个要乘 2 3 5 的丑数的索引

            while (nextIdx < n) {
                int last = nums[nextIdx - 1];

                int mul2 = nums[mul2pre] * 2;
                while (mul2 <= last) {
                    ++mul2pre;
                    mul2 = nums[mul2pre] * 2;
                }

                int mul3 = nums[mul3pre] * 3;
                while (mul3 <= last) {
                    ++mul3pre;
                    mul3 = nums[mul3pre] * 3;
                }

                int mul5 = nums[mul5pre] * 5;
                while (mul5 <= last) {
                    ++mul5pre;
                    mul5 = nums[mul5pre] * 5;
                }

                int which = minIdx(mul2, mul3, mul5);
                switch (which) {
                    case 1 -> {
                        nums[nextIdx++] = mul2;
                        ++mul2pre;
                    }
                    case 2 -> {
                        nums[nextIdx++] = mul3;
                        ++mul3pre;
                    }
                    case 3 -> {
                        nums[nextIdx++] = mul5;
                        ++mul5pre;
                    }
                }
            }
            return nums[n - 1];
        }

        // 第几个参数值最小
        private int minIdx(int i1, int i2, int i3) {
            if (i1 <= i2 && i1 <= i3) {
                return 1;
            }
            if (i2 <= i1 && i2 <= i3) {
                return 2;
            }
            return 3;
        }
    }

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        Solution solution = new Solution();
        System.out.println(solution.nthUglyNumber(1));  // 1
        System.out.println(solution.nthUglyNumber(10));  // 12
        System.out.println(solution.nthUglyNumber(1690));  // 2123366400
        System.out.println(solution.nthUglyNumber(1689));  // 2109375000
    }
}
