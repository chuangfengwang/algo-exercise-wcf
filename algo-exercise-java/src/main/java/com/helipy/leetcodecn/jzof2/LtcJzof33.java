package com.helipy.leetcodecn.jzof2;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof33
 * Desc: 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * https://leetcode.cn/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-07-25 19:28
 */
public class LtcJzof33 {
    static
    class Solution {
        public boolean verifyPostorder(int[] postorder) {
            if (postorder == null) {
                return false;
            }
            return verifyPostorderCore(postorder, 0, postorder.length - 1);
        }

        private boolean verifyPostorderCore(int[] postorder, int start, int end) {
            if (start >= end || end >= postorder.length) {
                return true;
            }
            int rootVal = postorder[end];
            int leftEnd = start;
            for (int idx = start; idx <= end - 1; ++idx) {
                if (postorder[idx] > rootVal) {
                    break;
                } else {
                    leftEnd = idx;
                }
            }
            for (int idx = leftEnd + 1; idx <= end - 1; ++idx) {
                if (postorder[idx] < rootVal) {
                    return false;
                }
            }
            return verifyPostorderCore(postorder, start, leftEnd) &&
                    verifyPostorderCore(postorder, leftEnd + 1, end - 1);
        }
    }

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        int[] postorder = new int[]{4, 8, 6, 12, 16, 14, 10};
        Solution solution = new Solution();
        boolean out = solution.verifyPostorder(postorder);
        System.out.println(out);
    }
}
