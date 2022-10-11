package com.helipy.leetcodecn.main;

import com.alibaba.fastjson.JSON;

/**
 * Pack:       com.helipy.leetcodecn.main
 * File:       Ltc221
 * Desc: 221. 最大正方形
 * https://leetcode.cn/problems/maximal-square/
 * User:       chuangfengwang
 * CreateTime: 2022-07-19 16:20
 */
public class Ltc221 {

    static
    class Solution {
        // 暴力法
        public int maximalSquare1(char[][] matrix) {
            if (matrix.length < 1) {
                return 0;
            }
            // (x,y,w) 可以表示一个正方形
            int m = matrix.length, n = matrix[0].length;

            int curMaxW = 0;
            for (int w = 1; w <= Math.min(m, n); ++w) {
                boolean findOne = false;
                OUT:
                for (int x = 0; x <= m - w; ++x) {
                    for (int y = 0; y <= n - w; ++y) {
                        // 判断 (x,y,w) 是否是全1的正方形
                        if (isAll1Square(matrix, x, y, w)) {
                            findOne = true;
                            break OUT;
                        }
                    }
                }
                if (findOne) {
                    curMaxW = w;
                } else {
                    return curMaxW * curMaxW;
                }
            }
            return curMaxW * curMaxW;
        }

        private boolean isAll1Square(char[][] matrix, int x, int y, int w) {
            for (int i = x; i < x + w; ++i) {
                for (int j = y; j < y + w; ++j) {
                    if (matrix[i][j] != '1') {
                        return false;
                    }
                }
            }
            return true;
        }

        // 动态规划
        public int maximalSquare(char[][] matrix) {
            if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
                return 0;
            }
            int rowNum = matrix.length, colNum = matrix[0].length;
            // dp[x][y] 表示: 以(x,y)为右下角的最大正方形边长.
            // if dp[x][y] == 1, dp[x][y]=min(dp[x-1][y],dp[x][y-1],dp[x-1][y-1])+1
            // else dp[x][y]=0
            int[][] dp = new int[rowNum][colNum];
            int maxWidth = 0;
            for (int x = 0; x < rowNum; ++x) {
                for (int y = 0; y < colNum; ++y) {
                    if (matrix[x][y] == '1') {
                        if (x == 0 || y == 0) {
                            dp[x][y] = 1;
                        } else {
                            int minLeftUp = dp[x - 1][y];
                            minLeftUp = Math.min(dp[x][y - 1], minLeftUp);
                            minLeftUp = Math.min(dp[x - 1][y - 1], minLeftUp);
                            dp[x][y] = minLeftUp + 1;
                        }
                        if (dp[x][y] > maxWidth) {
                            maxWidth = dp[x][y];
                        }
                    } else {
                        dp[x][y] = 0;
                    }
                }
            }
            return maxWidth * maxWidth;
        }


        public static void main(String[] args) {
            test1();
            test2();
            test3();
            test4();
        }

        public static void test1() {
            String input = "[[\"1\",\"0\",\"1\",\"0\",\"0\"],[\"1\",\"0\",\"1\",\"1\",\"1\"],[\"1\",\"1\",\"1\",\"1\",\"1\"],[\"1\",\"0\",\"0\",\"1\",\"0\"]]";
            test(input);
        }

        public static void test2() {
            String input = "[[\"0\",\"1\"],[\"1\",\"0\"]]";
            test(input);
        }

        public static void test3() {
            String input = "[[\"0\"]]";
            test(input);
        }

        public static void test4() {
            String input = "[[\"1\",\"1\"],[\"1\",\"1\"]]";
            test(input);
        }

        public static void test(String input) {
            Character[][] matrixOrig = JSON.parseObject(input, Character[][].class);
            char[][] matrix = new char[matrixOrig.length][matrixOrig[0].length];
            for (int x = 0; x < matrixOrig.length; ++x) {
                for (int y = 0; y < matrixOrig[0].length; ++y) {
                    matrix[x][y] = matrixOrig[x][y];
                }
            }
            Solution solution = new Solution();
            int square = solution.maximalSquare(matrix);
            System.out.println(square);
        }
    }
}
