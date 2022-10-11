package com.helipy.leetcodecn.jzof2;

import com.alibaba.fastjson.JSON;
import com.helipy.leetcodecn.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof34
 * Desc: 剑指 Offer 34. 二叉树中和为某一值的路径
 * https://leetcode.cn/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-07-18 13:46
 */
public class LtcJzof34 {

    static
    class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int target) {
            if (root == null) {
                return new ArrayList<>();
            }
            int curSum = 0;
            LinkedList<TreeNode> curPath = new LinkedList<>();
            List<List<Integer>> pathList = new LinkedList<>();
            preRoot(root, curPath, curSum, target, pathList);
            return pathList;
        }

        // 先根遍历. 保证 root 不为 null
        private void preRoot(TreeNode root, LinkedList<TreeNode> curPath, int curSum, int target,
                             List<List<Integer>> pathList) {
            curSum += root.val;
            curPath.addLast(root);

            if (root.left == null && root.right == null) {
                // 叶节点
                if (curSum == target) {
                    // 找到一个路径
                    List<Integer> res = new ArrayList<>(curPath.size());
                    for (TreeNode node : curPath) {
                        res.add(node.val);
                    }
                    pathList.add(res);
                }
            }

            if (root.left != null) {
                preRoot(root.left, curPath, curSum, target, pathList);
            }
            if (root.right != null) {
                preRoot(root.right, curPath, curSum, target, pathList);
            }
            // 访问完左右子树,弹出当前节点,路径上最后一个节点
            curPath.removeLast();
        }


        public static void main(String[] args) {
            Solution solution = new Solution();
            solution.test1();
            solution.test2();
            solution.test3();
        }

        public void test1() {
            String input = "[5,4,8,11,null,13,4,7,2,null,null,null,null,5,1]";
            int target = 22;
            TreeNode root = TreeNode.parseTreeFromFullBinaryJsonStr(input);
            TreeNode.printAsFullBinaryTree(root);
            List<Integer> integerList = TreeNode.convertToFullBinaryTree(root);
            System.out.println();
            System.out.println(integerList);
            List<List<Integer>> lists = pathSum(root, target);
            printResult(lists);  // [[5,4,11,2],[5,8,4,5]]
        }

        public void test2() {
            String input = "[1,2,3]";
            int target = 5;
            TreeNode root = TreeNode.parseTreeFromFullBinaryJsonStr(input);
            List<List<Integer>> lists = pathSum(root, target);
            printResult(lists);  // []
        }

        public void test3() {
            String input = "[1,2]";
            int target = 0;
            TreeNode root = TreeNode.parseTreeFromFullBinaryJsonStr(input);
            List<List<Integer>> lists = pathSum(root, target);
            printResult(lists);  // []
        }

        public void printResult(List<List<Integer>> lists) {
            String output = JSON.toJSONString(lists);
            System.out.println(output);
        }
    }
}
