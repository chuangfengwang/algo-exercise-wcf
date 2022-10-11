package com.helipy.leetcodecn;

import com.alibaba.fastjson.JSON;
import com.helipy.common.FullBinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       TreeNode
 * Desc: 二叉树
 * User:       chuangfengwang
 * CreateTime: 2022-07-10 12:41
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }

    ///////////////////////////////////////////////////////////////////////////
    // leetcode 二叉树格式

    // leetcode 格式的二叉树序列化:
    // 层次遍历二叉树, 并用 null 终结叶节点和空的子节点, 末层叶节点的 null 被忽略
    public static String convertToLeetCodeJson(TreeNode root) {
        return JSON.toJSONString(convertToLeetCodeList(root));
    }

    public static List<Integer> convertToLeetCodeList(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        LinkedList<TreeNode> curList = new LinkedList<>();
        convertToLeetCodeListCore(root, curList);
        // 删除末尾的 null
        while (curList.peekLast() == null) {
            curList.removeLast();
        }
        // 取出 curList 里的 val
        List<Integer> valList = new ArrayList<>(curList.size());
        for (TreeNode node : curList) {
            if (node == null) {
                valList.add(null);
            } else {
                valList.add(node.val);
            }
        }
        return valList;
    }

    private static void convertToLeetCodeListCore(TreeNode root, List<TreeNode> curList) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            curList.add(node);
            if (node != null) {
                queue.add(node.left);
                queue.add(node.right);
            }
        }
    }

    // 从 leetcode 格式的二叉树序列化结果 反序列化出二叉树
    public static TreeNode parseTreeFromLeetCodeJsonStr(String jsonStr) {
        List<Integer> itemList = JSON.parseArray(jsonStr, Integer.class);
        return parseTreeFromLeetCodeList(itemList);
    }

    public static TreeNode parseTreeFromLeetCodeList(List<Integer> itemList) {
        if (itemList == null || itemList.isEmpty()) {
            return null;
        }
        Integer first = itemList.get(0);
        assert first != null;
        TreeNode root = new TreeNode(first);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        TreeNode curNode = queue.poll();
        boolean isLeftNode = true;
        for (int idx = 1; idx < itemList.size(); ++idx) {
            assert curNode != null;
            Integer nextValue = itemList.get(idx);
            if (nextValue != null && isLeftNode) {
                // 生成左节点
                curNode.left = new TreeNode(nextValue);
                queue.add(curNode.left);
            } else if (nextValue != null) {
                // 生成右节点, 取底层节点的下一个
                curNode.right = new TreeNode(nextValue);
                queue.add(curNode.right);
                curNode = queue.poll();
            }
            if (nextValue == null && !isLeftNode) {
                // 右节点为 null, 取底层节点的下一个
                curNode = queue.poll();
            }
            isLeftNode = !isLeftNode;
            // nextValue == null 不做处理
        }
        return root;
    }

    ///////////////////////////////////////////////////////////////////////////
    // 完全二叉树格式

    // 从完全二叉树的 json 构造树
    public static TreeNode parseTreeFromFullBinaryJsonStr(String jsonStr) {
        List<Integer> itemList = JSON.parseArray(jsonStr, Integer.class);
        return parseTreeFromFullBinaryTree(itemList);
    }

    // 从数组形式的完全二叉树构造二叉树
    public static TreeNode parseTreeFromFullBinaryTree(List<Integer> itemList) {
        if (itemList.isEmpty()) {
            return null;
        }
        int nodeNum = itemList.size();
        TreeNode root = new TreeNode(itemList.get(0));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> idxQueue = new LinkedList<>();
        nodeQueue.add(root);
        idxQueue.add(0);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            Integer idx = idxQueue.poll();
            assert idx != null && node != null;

            Integer left = null;
            int leftIdx = FullBinaryTree.leftIdx(idx, nodeNum);
            if (leftIdx >= 0) {
                left = itemList.get(leftIdx);
            }
            if (left != null) {
                TreeNode leftNode = new TreeNode(left);
                node.left = leftNode;
                nodeQueue.add(leftNode);
                idxQueue.add(leftIdx);
            }
            Integer right = null;
            int rightIdx = FullBinaryTree.rightIdx(idx, nodeNum);
            if (rightIdx >= 0) {
                right = itemList.get(rightIdx);
            }
            if (right != null) {
                TreeNode rightNode = new TreeNode(right);
                node.right = rightNode;
                nodeQueue.add(rightNode);
                idxQueue.add(rightIdx);
            }
        }
        return root;
    }

    // 把二叉树转换成数组形式的完全二叉树
    public static List<Integer> convertToFullBinaryTree(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(0);
        }
        Map<TreeNode, Integer> nodeIdxMap = new HashMap<>();  // 节点的编号
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        nodeIdxMap.put(root, 0);
        int maxNodeIdx = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            Integer curNodeIdx = nodeIdxMap.get(node);
            if (node.left != null) {
                // 左孩子的节点编号
                int leftIdx = FullBinaryTree.leftIdx(curNodeIdx);
                maxNodeIdx = Math.max(leftIdx, maxNodeIdx);
                nodeIdxMap.put(node.left, leftIdx);

                queue.add(node.left);
            }
            if (node.right != null) {
                // 右孩子的节点编号
                int rightIdx = FullBinaryTree.rightIdx(curNodeIdx);
                maxNodeIdx = Math.max(rightIdx, maxNodeIdx);
                nodeIdxMap.put(node.right, rightIdx);
                queue.add(node.right);
            }
        }
        ArrayList<Integer> data = new ArrayList<>(maxNodeIdx + 1);  // 数组形式的完全二叉树
        for (int idx = 0; idx <= maxNodeIdx; ++idx) {
            data.add(null);
        }
        for (Map.Entry<TreeNode, Integer> entry : nodeIdxMap.entrySet()) {
            Integer idx = entry.getValue();
            TreeNode node = entry.getKey();
            data.set(idx, node.val);
        }

        return data;
    }


    // 以完全二叉树的形式逐层打印二叉树,如遇空值,打印 null
    public static void printAsFullBinaryTree(TreeNode root) {
        List<Integer> data = convertToFullBinaryTree(root);
        // 打印完全二叉树
        int curLayerNodeNum = 1;
        int curLayerNodeIdx = 0;
        for (Integer item : data) {
            if (curLayerNodeIdx != 0) {
                // 不是第一个元素, 打印分割符
                System.out.print(",");
            }
            System.out.print(item);
            ++curLayerNodeIdx;

            if (curLayerNodeIdx >= curLayerNodeNum) {
                // 当前行已打印完成
                System.out.println();
                curLayerNodeNum *= 2;
                curLayerNodeIdx = 0;
            }
        }
    }
}
