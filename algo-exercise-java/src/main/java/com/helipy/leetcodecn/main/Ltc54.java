package com.helipy.leetcodecn.main;

import com.alibaba.fastjson.JSON;
import com.helipy.leetcodecn.LtcUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Pack:       com.helipy.leetcodecn.main
 * File:       Ltc54
 * Desc: 54. 螺旋矩阵
 * https://leetcode.cn/problems/spiral-matrix/
 * User:       chuangfengwang
 * CreateTime: 2022-08-02 01:22
 */
public class Ltc54 {
    static
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return new ArrayList<>(0);
            }
            int rowNum = matrix.length, colNum = matrix[0].length;
            List<Integer> out = new ArrayList<>(rowNum * colNum);
            int x = 0, y = -1, layer = 1;
            while (layer <= (Math.min(rowNum, colNum) + 1) / 2) {
                // 向右,一定会走
                ++y;
                while (y < colNum - layer + 1) {
                    out.add(matrix[x][y++]);
                }
                --y;
                // 向下,不一定会走
                ++x;
                boolean hasDown = false;
                while (x < rowNum - layer + 1) {
                    out.add(matrix[x++][y]);
                    hasDown = true;
                }
                --x;
                // 向左,不一定会走
                --y;
                boolean hasLeft = false;
                while (hasDown && y >= layer - 1) {
                    out.add(matrix[x][y--]);
                    hasLeft = true;
                }
                ++y;
                // 向上,不一定会走
                --x;
                while (hasLeft && x > layer - 1) {
                    out.add(matrix[x--][y]);
                }
                ++x;
                // 下一层
                ++layer;
            }
            return out;
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
        List<Integer> list = solution.spiralOrder(matrix);
        System.out.println(JSON.toJSONString(list));
        // [1,2,3,6,9,8,7,4,5]
    }

    private static void test2() {
        String input = "[[1,2,3,4],[5,6,7,8],[9,10,11,12]]";
        int[][] matrix = LtcUtil.buildIntMatrix(input);
        Solution solution = new Solution();
        List<Integer> list = solution.spiralOrder(matrix);
        System.out.println(JSON.toJSONString(list));
        // [1,2,3,4,8,12,11,10,9,5,6,7]
    }

    private static void test3() {
        String input = "[[1,2,3],[4,5,6],[7,8,9],[10,11,12]]";
        int[][] matrix = LtcUtil.buildIntMatrix(input);
        Solution solution = new Solution();
        List<Integer> list = solution.spiralOrder(matrix);
        System.out.println(JSON.toJSONString(list));
        // [1,2,3,6,9,12,11,10,7,4,5,8]
    }

    private static void test4() {
        String input = "[[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]]";
        int[][] matrix = LtcUtil.buildIntMatrix(input);
        Solution solution = new Solution();
        List<Integer> list = solution.spiralOrder(matrix);
        System.out.println(JSON.toJSONString(list));
        // [1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10]
    }

    private static void test5() {
        String input = "[[1,2,3]]";
        int[][] matrix = LtcUtil.buildIntMatrix(input);
        Solution solution = new Solution();
        List<Integer> list = solution.spiralOrder(matrix);
        System.out.println(JSON.toJSONString(list));
        // [1,2,3]
    }

    private static void test6() {
        String input = "[[1],[2],[3]]";
        int[][] matrix = LtcUtil.buildIntMatrix(input);
        Solution solution = new Solution();
        List<Integer> list = solution.spiralOrder(matrix);
        System.out.println(JSON.toJSONString(list));
        // [1,2,3]
    }
}
