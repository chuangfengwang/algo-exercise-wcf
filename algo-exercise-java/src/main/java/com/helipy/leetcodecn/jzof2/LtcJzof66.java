package com.helipy.leetcodecn.jzof2;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof66
 * Desc: 剑指 Offer 66. 构建乘积数组
 * https://leetcode.cn/problems/gou-jian-cheng-ji-shu-zu-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-07-26 14:44
 */
public class LtcJzof66 {
    class Solution {

        // 用数组提前 multiA[i] 记录 a[0]-a[i] 的乘积
        public int[] constructArr(int[] a) {
            if (a == null || a.length == 0) {
                return new int[0];
            }
            if (a.length == 1) {
                return new int[]{1};
            }
            // multiA[i] 记录 a[0]-a[i] 的乘积
            int[] multiA = new int[a.length];
            multiA[0] = a[0];
            for (int idx = 1; idx < a.length; ++idx) {
                multiA[idx] = multiA[idx - 1] * a[idx];
            }

            int multiARe = 1;  // 存储从后往前乘 a[i] 的结果
            int[] b = new int[a.length];
            for (int idx = a.length - 1; idx > 0; --idx) {
                b[idx] = multiA[idx - 1] * multiARe;
                multiARe *= a[idx];
            }
            b[0] = multiARe;

            return b;
        }

        // 用库函数绕过除法限制
        public int[] constructArr1(int[] a) {
            if (a == null) {
                return null;
            }
            int zeroNum = 0;  // 记录 0 的个数, 超过一个, 碰到 0 结果就是 0, 否则结果是 noZeroMulti
            int noZeroMulti = 1;  // 记录非 0 的乘积
            int multiRes = 1;
            for (int val : a) {
                multiRes *= val;
                if (val == 0) {
                    ++zeroNum;
                } else {
                    noZeroMulti *= val;
                }
            }
            int[] b = new int[a.length];
            for (int idx = 0; idx < b.length; ++idx) {
                if (a[idx] == 0 && zeroNum > 1) {
                    b[idx] = 0;
                } else if (a[idx] == 0 && zeroNum == 1) {
                    b[idx] = noZeroMulti;
                } else {
                    b[idx] = Math.floorDiv(multiRes, a[idx]);
                }
            }
            return b;
        }
    }
}
