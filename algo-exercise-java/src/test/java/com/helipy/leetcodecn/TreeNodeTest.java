package com.helipy.leetcodecn;

import junit.framework.TestCase;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       TreeNodeTest
 * Desc:
 * User:       chuangfengwang
 * CreateTime: 2022-07-10 12:59
 */
public class TreeNodeTest extends TestCase {

    // 完全二叉树方式 序列化反序列化
    public void testParseTreeFromFullBinaryJsonStr1() {
        String str = "[0,1,2,3,null,null,5,null,8]";
        TreeNode root = TreeNode.parseTreeFromFullBinaryJsonStr(str);
        TreeNode.printAsFullBinaryTree(root);
    }

    public void testParseTreeFromFullBinaryJsonStr2() {
        String str = "[0]";
        TreeNode root = TreeNode.parseTreeFromFullBinaryJsonStr(str);
        TreeNode.printAsFullBinaryTree(root);
    }

    public void testParseTreeFromFullBinaryJsonStr3() {
        String str = "[]";
        TreeNode root = TreeNode.parseTreeFromFullBinaryJsonStr(str);
        TreeNode.printAsFullBinaryTree(root);
    }

    public void testParseTreeFromFullBinaryJsonStr4() {
        String str = "[5,4,8,11,null,13,4,7,2,null,null,null,null,5,1]";
        TreeNode root = TreeNode.parseTreeFromFullBinaryJsonStr(str);
        TreeNode.printAsFullBinaryTree(root);
    }

    // leetcode 方式 序列化
    public void testConvertToLeetCodeJson1() {
        String str = "[5,4,8,11,null,13,4,7,2,null,null,null,null,5,1]";
        TreeNode root = TreeNode.parseTreeFromFullBinaryJsonStr(str);
        String json = TreeNode.convertToLeetCodeJson(root);
        System.out.println(json);  // [5,4,8,11,null,13,4,7,2,null,null,5,1]
    }

    public void testConvertToLeetCodeJson2() {
        String str = "[0,1,2,3,null,null,5,null,8]";
        TreeNode root = TreeNode.parseTreeFromFullBinaryJsonStr(str);
        String json = TreeNode.convertToLeetCodeJson(root);
        System.out.println(json);  // [0,1,2,3,null,null,5,null,8]
    }

    public void testConvertToLeetCodeJson3() {
        String str = "[0]";
        TreeNode root = TreeNode.parseTreeFromFullBinaryJsonStr(str);
        String json = TreeNode.convertToLeetCodeJson(root);
        System.out.println(json);  // [0]
    }

    public void testConvertToLeetCodeJson4() {
        String str = "[]";
        TreeNode root = TreeNode.parseTreeFromFullBinaryJsonStr(str);
        String json = TreeNode.convertToLeetCodeJson(root);
        System.out.println(json);  // []
    }

    // leetcode 方式 反序列化
    public void testParseTreeFromLeetCodeJsonStr1() {
        String str = "[5,4,8,11,null,13,4,7,2,null,null,5,1]";
        TreeNode root = TreeNode.parseTreeFromLeetCodeJsonStr(str);
        TreeNode.printAsFullBinaryTree(root);
        System.out.println();
        String json = TreeNode.convertToLeetCodeJson(root);
        System.out.println(json);  // [5,4,8,11,null,13,4,7,2,null,null,5,1]
    }

    public void testParseTreeFromLeetCodeJsonStr2() {
        String str = "[0,1,2,3,null,null,5,null,8]";
        TreeNode root = TreeNode.parseTreeFromLeetCodeJsonStr(str);
        TreeNode.printAsFullBinaryTree(root);
        System.out.println();
        String json = TreeNode.convertToLeetCodeJson(root);
        System.out.println(json);  // [0,1,2,3,null,null,5,null,8]
    }

    public void testParseTreeFromLeetCodeJsonStr3() {
        String str = "[2]";
        TreeNode root = TreeNode.parseTreeFromLeetCodeJsonStr(str);
        TreeNode.printAsFullBinaryTree(root);
        System.out.println();
        String json = TreeNode.convertToLeetCodeJson(root);
        System.out.println(json);  // [2]
    }

    public void testParseTreeFromLeetCodeJsonStr4() {
        String str = "[]";
        TreeNode root = TreeNode.parseTreeFromLeetCodeJsonStr(str);
        TreeNode.printAsFullBinaryTree(root);
        System.out.println();
        String json = TreeNode.convertToLeetCodeJson(root);
        System.out.println(json);  // []
    }
}