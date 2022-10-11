package com.helipy.leetcodecn.jzof2;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof04
 * Desc: 剑指 Offer 04. 二维数组中的查找
 * https://leetcode.cn/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-07-09 14:38
 */
public class LtcJzof04 {

    class Solution {
        // 递归写法
        public boolean findNumberIn2DArray1(int[][] matrix, int target) {
            int rowNum = matrix.length;  // 行数
            if (rowNum < 1) {
                // 没有数据
                return false;
            }
            int colNum = matrix[0].length;  // 列数
            if (colNum < 1) {
                // 没有数据
                return false;
            }
            return findNumberCore(matrix, target, rowNum - 1, 0, colNum - 1);
        }

        // 在右上角(rtX, rtY)到左下角(maxRowInx,0)的巨型范围内递归查找
        private boolean findNumberCore(int[][] matrix, int target, int maxRowIdx, int rtX, int rtY) {
            if (rtX > maxRowIdx || rtY < 0) {
                return false;
            }
            if (matrix[rtX][rtY] > target) {
                // 排除最后一列
                return findNumberCore(matrix, target, maxRowIdx, rtX, rtY - 1);
            }
            if (matrix[rtX][rtY] < target) {
                // 排除最前一行
                return findNumberCore(matrix, target, maxRowIdx, rtX + 1, rtY);
            }
            return true;
        }

        // 迭代写法
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            int rowNum = matrix.length;  // 行数
            if (rowNum < 1) {
                // 没有数据
                return false;
            }
            int colNum = matrix[0].length;  // 列数
            if (colNum < 1) {
                // 没有数据
                return false;
            }
            int rtx = 0, rty = colNum - 1;  // 右上角座标
            while (rtx < rowNum && rty >= 0) {
                if (matrix[rtx][rty] > target) {
                    // 排除最后一列
                    --rty;
                } else if (matrix[rtx][rty] < target) {
                    // 排除最前一行
                    ++rtx;
                } else {
                    return true;
                }
            }
            return false;
        }
    }
}
