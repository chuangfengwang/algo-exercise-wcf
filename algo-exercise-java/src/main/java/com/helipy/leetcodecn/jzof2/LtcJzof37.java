package com.helipy.leetcodecn.jzof2;

import com.helipy.leetcodecn.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof37
 * Desc:
 * User:       chuangfengwang
 * CreateTime: 2022-07-18 20:00
 */
public class LtcJzof37 {
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            List<Integer> integerList = convertToLeetCodeList(root);
            // 序列化 integerList
            if (integerList.size() < 1) {
                return "[]";
            }
            StringBuilder sb = new StringBuilder("[");
            sb.append(integerList.get(0));
            for (int idx = 1; idx < integerList.size(); ++idx) {
                sb.append(",");
                Integer val = integerList.get(idx);
                if (val == null) {
                    sb.append("null");
                } else {
                    sb.append(val);
                }
            }
            sb.append("]");
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            // data 转 integer list
            ArrayList<Integer> integerList = new ArrayList<>();
            data = data.substring(1, data.length() - 1);  // 去除首尾的 []
            if (data.equals("")){
                return parseTreeFromLeetCodeList(integerList);
            }
            String[] pieceArray = data.split(",");
            for (String piece : pieceArray) {
                if ("null".equals(piece)) {
                    integerList.add(null);
                } else {
                    Integer val = Integer.valueOf(piece);
                    integerList.add(val);
                }
            }

            return parseTreeFromLeetCodeList(integerList);
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
    }
}
