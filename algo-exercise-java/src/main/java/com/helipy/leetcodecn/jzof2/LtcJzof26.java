package com.helipy.leetcodecn.jzof2;

import com.helipy.leetcodecn.TreeNode;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof26
 * Desc: 剑指 Offer 26. 树的子结构
 * https://leetcode.cn/problems/shu-de-zi-jie-gou-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-07-10 11:36
 */
public class LtcJzof26 {

    static
    class Solution {
        // A 是否包含子树 B
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            if (B == null || A == null) {
                // 空树不是任意一个树的子结构, 空树没有子结构
                return false;
            }
            return isSubStructureCore(A, B);  // A!=null && B!=null
        }

        // 认为空树是任意树的子树
        boolean isSubStructureCore(TreeNode A, TreeNode B) {
            if (B == null) {
                return true;
            }
            if (A == null) {  // B != null
                return false;
            }
            boolean res = isRootSubStructure(A, B);  // A!=null && B!=null
            if (res) {
                return true;
            }
            return isSubStructureCore(A.left, B) || isSubStructureCore(A.right, B);
        }

        // A 与 B 是否在根上能重合(A覆盖B)
        boolean isRootSubStructure(TreeNode A, TreeNode B) {
            // B 是叶节点
            if (B.left == null && B.right == null) {
                return B.val == A.val;
            }
            // 判断根节点
            if (B.val != A.val) {
                return false;
            }
            // B 有左子树
            boolean res = true;
            if (B.left != null) {
                if (A.left == null) {
                    return false;
                } else {
                    res = isRootSubStructure(A.left, B.left);
                }
            }
            if (!res) {
                return false;
            }
            // B 有右子树
            if (B.right != null) {
                if (A.right == null) {
                    return false;
                } else {
                    res = isRootSubStructure(A.right, B.right);
                }
            }
            return res;
        }

    }


    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        String jsonA = "[1,0,1,-4,-3]";
        String jsonB = "[1,-4]";
        TreeNode A = TreeNode.parseTreeFromFullBinaryJsonStr(jsonA);
        TreeNode B = TreeNode.parseTreeFromFullBinaryJsonStr(jsonB);

        Solution solution = new Solution();
        boolean res = solution.isSubStructure(A, B);
        System.out.println(res);  // false
    }
}
