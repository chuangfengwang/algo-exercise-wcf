package com.helipy.leetcodecn.jzof2;

import com.alibaba.fastjson.JSON;
import com.helipy.leetcodecn.LtcUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof29
 * Desc: 剑指 Offer 29. 顺时针打印矩阵
 * https://leetcode.cn/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-07-28 17:21
 */
public class LtcJzof29 {
    static
    class Solution {
        public int[] spiralOrder(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return new int[0];
            }
            int rowNum = matrix.length;
            int colNum = matrix[0].length;
            if (colNum == 0) {
                return new int[0];
            }
            List<Integer> list = new ArrayList<>(rowNum * colNum);
            int x = 0, y = -1;
            int layer = 1, maxLayer = (Math.min(rowNum, colNum) + 1) / 2;  // 层数与最大层数
            for (; layer <= maxLayer; ++layer) {
                // 向右
                ++y;
                while (y <= colNum - layer) {
                    list.add(matrix[x][y]);
                    ++y;
                }
                --y;
                // 向下
                boolean lastDirUsed = false;  // 记录上一个方向是否走过
                ++x;
                while (x <= rowNum - layer) {
                    list.add(matrix[x][y]);
                    ++x;
                    lastDirUsed = true;
                }
                --x;
                // 向左
                if (lastDirUsed) {
                    lastDirUsed = false;
                    --y;
                    while (y >= layer - 1) {
                        list.add(matrix[x][y]);
                        --y;
                        lastDirUsed = true;
                    }
                    ++y;
                }
                // 向上
                if (lastDirUsed) {
                    --x;
                    while (x >= layer) {
                        list.add(matrix[x][y]);
                        --x;
                    }
                    ++x;
                }
                // 下一层
            }
            return list.stream().mapToInt(val -> val).toArray();
        }
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }

    private static void test1() {
        String input = "[[1,2,3],[4,5,6],[7,8,9]]";
        int[][] matrix = LtcUtil.buildIntMatrix(input);
        Solution solution = new Solution();
        int[] list = solution.spiralOrder(matrix);
        System.out.println(JSON.toJSONString(list));
        // [1,2,3,6,9,8,7,4,5]
    }

    private static void test2() {
        String input = "[[1,2,3,4],[5,6,7,8],[9,10,11,12]]";
        int[][] matrix = LtcUtil.buildIntMatrix(input);
        Solution solution = new Solution();
        int[] list = solution.spiralOrder(matrix);
        System.out.println(JSON.toJSONString(list));
        // [1,2,3,4,8,12,11,10,9,5,6,7]
    }

    private static void test3() {
        String input = "[[1,2,3],[4,5,6],[7,8,9],[10,11,12]]";
        int[][] matrix = LtcUtil.buildIntMatrix(input);
        Solution solution = new Solution();
        int[] list = solution.spiralOrder(matrix);
        System.out.println(JSON.toJSONString(list));
        // [1,2,3,6,9,12,11,10,7,4,5,8]
    }

    private static void test4() {
        String input = "[[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]]";
        int[][] matrix = LtcUtil.buildIntMatrix(input);
        Solution solution = new Solution();
        int[] list = solution.spiralOrder(matrix);
        System.out.println(JSON.toJSONString(list));
        // [1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10]
    }

    private static void test5() {
        String input = "[[1,2,3]]";
        int[][] matrix = LtcUtil.buildIntMatrix(input);
        Solution solution = new Solution();
        int[] list = solution.spiralOrder(matrix);
        System.out.println(JSON.toJSONString(list));
        // [1,2,3]
    }

    private static void test6() {
        String input = "[[1],[2],[3]]";
        int[][] matrix = LtcUtil.buildIntMatrix(input);
        Solution solution = new Solution();
        int[] list = solution.spiralOrder(matrix);
        System.out.println(JSON.toJSONString(list));
        // [1,2,3]
    }

}
