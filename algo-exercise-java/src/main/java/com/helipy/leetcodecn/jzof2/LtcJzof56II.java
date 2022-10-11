package com.helipy.leetcodecn.jzof2;

import java.util.HashMap;
import java.util.Map;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof56II
 * Desc: 剑指 Offer 56 - II. 数组中数字出现的次数 II
 * https://leetcode.cn/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-07-26 13:45
 */
public class LtcJzof56II {
    static
    class Solution {

        // 按位求和,能被 3 整除的位是 0, 不能被 3 整除的位是 1
        public int singleNumber(int[] nums) {
            int[] bitSum = new int[32];  // 默认初始化为 0
            // 按位求和
            for (int val : nums) {
                for (int bitNum = 0; bitNum < 32; ++bitNum) {
                    int flag = 1 << bitNum;
                    if ((val & flag) != 0) {
                        ++bitSum[31 - bitNum];  // bitSum[31] 是最低位的和, bitSum[0] 是最高位的和
                    }
                }
            }
            // 判断哪些位的和不能被 3 整除
            int single = 0;
            for (int bitNum = 0; bitNum < 32; ++bitNum) {
                single = single << 1;
                if (bitSum[bitNum] % 3 != 0) {
                    single = single | 1;
                }
            }
            return single;
        }

        // map 计数求解
        public int singleNumber1(int[] nums) {
            if (nums == null) {
                return Integer.MIN_VALUE;
            }
            Map<Integer, Integer> numCountMap = new HashMap<>();
            for (int num : nums) {
                numCountMap.put(num, numCountMap.getOrDefault(num, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : numCountMap.entrySet()) {
                if (entry.getValue() != 3) {
                    return entry.getKey();
                }
            }
            return Integer.MIN_VALUE;
        }
    }

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        int[] num = new int[]{3, 4, 3, 3};
        Solution solution = new Solution();
        int out = solution.singleNumber(num);
        System.out.println(out);
    }
}
