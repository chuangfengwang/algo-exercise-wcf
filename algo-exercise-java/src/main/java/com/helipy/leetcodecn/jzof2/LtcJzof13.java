package com.helipy.leetcodecn.jzof2;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof13
 * Desc: 剑指 Offer 13. 机器人的运动范围
 * https://leetcode.cn/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-07-18 11:26
 */
public class LtcJzof13 {
    class Solution {
        public static class Count {
            public int count;

            public Count(int count) {
                this.count = count;
            }
        }

        public int movingCount(int m, int n, int k) {
            boolean[][] visited = new boolean[m][n];
            Count count = new Count(0);
            moving(0, 0, k, visited, count);
            return count.count;
        }

        // 在座标 (x,y) 能到达的格子数
        private void moving(int x, int y, int k, boolean[][] visited, Count count) {
            if (!visited[x][y] && canEnter(x, y, k)) {
                visited[x][y] = true;
                ++count.count;

                // 上下左右探查
//                if (x > 0 && !visited[x - 1][y]) {
//                    moving(x - 1, y, k, visited, count);
//                }
                if (x < visited.length - 1 && !visited[x + 1][y]) {
                    moving(x + 1, y, k, visited, count);
                }
//                if (y > 0 && !visited[x][y - 1]) {
//                    moving(x, y - 1, k, visited, count);
//                }
                if (y < visited[0].length - 1 && !visited[x][y + 1]) {
                    moving(x, y + 1, k, visited, count);
                }
            }
        }

        // 是否能进入 (x,y) 座标
        private boolean canEnter(int x, int y, int k) {
            int digitSum = 0;
            while (x > 0) {
                digitSum += x % 10;
                x /= 10;
            }
            while (y > 0) {
                digitSum += y % 10;
                y /= 10;
            }
            return digitSum <= k;
        }
    }
}
