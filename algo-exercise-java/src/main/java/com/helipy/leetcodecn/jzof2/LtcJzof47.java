package com.helipy.leetcodecn.jzof2;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof47
 * Desc: 剑指 Offer 47. 礼物的最大价值
 * https://leetcode.cn/problems/li-wu-de-zui-da-jie-zhi-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-07-10 18:57
 */
public class LtcJzof47 {
    class Solution {
        public int maxValue(int[][] grid) {
            if (grid.length == 0) {
                return 0;
            }
            if (grid[0].length == 0) {
                return 0;
            }
            int f[][] = new int[grid.length][grid[0].length];  // f[x][y] 表示在 (x,y)位置能拿到的最大价值
            f[0][0] = grid[0][0];
            // 初始化 f 的第 0 列
            for (int idx = 1; idx < grid.length; ++idx) {
                f[idx][0] = f[idx - 1][0] + grid[idx][0];
            }
            // 初始化 f 的第 0 行
            for (int idx = 1; idx < grid[0].length; ++idx) {
                f[0][idx] = f[0][idx - 1] + grid[0][idx];
            }
            // 迭代计算其他 f
            int maxV = Math.max(f[0][grid[0].length - 1], f[grid.length - 1][0]);
            for (int x = 1; x < grid.length; ++x) {
                for (int y = 1; y < grid[0].length; ++y) {
                    f[x][y] = Math.max(f[x - 1][y] + grid[x][y], f[x][y - 1] + grid[x][y]);
                    if (f[x][y] > maxV) {
                        maxV = f[x][y];
                    }
                }
            }
            return maxV;
        }
    }
}
