package com.helipy.leetcodecn.jzof2;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof12
 * Desc: 剑指 Offer 12. 矩阵中的路径
 * https://leetcode.cn/problems/ju-zhen-zhong-de-lu-jing-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-07-18 10:44
 */
public class LtcJzof12 {
    class Solution {
        public boolean exist(char[][] board, String word) {
            if (board.length < 1) {
                return false;
            }
            boolean[][] visited = new boolean[board.length][board[0].length];  // java 默认初始化为 0 值
            // 初始化,也可以没有
            for (int x = 0; x < visited.length; ++x) {
                for (int y = 0; y < visited[0].length; ++y) {
                    visited[x][y] = false;
                }
            }
            // 遍历
            for (int x = 0; x < visited.length; ++x) {
                for (int y = 0; y < visited[0].length; ++y) {
                    boolean isFound = existCore(board, word, visited, x, y, 0);
                    if (isFound) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean existCore(char[][] board, String word, boolean[][] visited, int x, int y, int wordIdx) {
            char aimChar = word.charAt(wordIdx);
            if (board[x][y] == aimChar && !visited[x][y]) {
                visited[x][y] = true;
                if (wordIdx >= word.length() - 1) {
                    // 已经是最后一个字符
                    return true;
                }
                // 上下左右 找下一个字符
                boolean isFound = false;
                if (x > 0 && !visited[x - 1][y]) {
                    isFound = existCore(board, word, visited, x - 1, y, wordIdx + 1);
                }
                if (x < board.length - 1 && !visited[x + 1][y]) {
                    isFound = isFound || existCore(board, word, visited, x + 1, y, wordIdx + 1);
                }
                if (y > 0 && !visited[x][y - 1]) {
                    isFound = isFound || existCore(board, word, visited, x, y - 1, wordIdx + 1);
                }
                if (y < board[0].length - 1 && !visited[x][y + 1]) {
                    isFound = isFound || existCore(board, word, visited, x, y + 1, wordIdx + 1);
                }
                if (isFound) {
                    return true;
                } else {
                    visited[x][y] = false;
                }
            }
            return false;
        }
    }
}
