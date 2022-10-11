package com.helipy.common;

import java.util.List;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       FullBinaryTree
 * Desc: 完全二叉树. 索引位置 0 是根节点. 层数编号从 0 开始
 * User:       chuangfengwang
 * CreateTime: 2022-07-10 13:27
 */
public class FullBinaryTree {

    // 父节点索引
    public static int fatherIdx(int idx) {
        if (idx <= 0) {
            throw new RuntimeException("no father node for idx:" + idx);
        }
        return (idx + 1) / 2 - 1;
    }

    // 获取父节点元素
    public static <T> T fatherIdx(int idx, List<T> data) {
        return data.get(fatherIdx(idx));
    }

    // 左孩子节点索引
    public static int leftIdx(int idx) {
        return 2 * idx + 1;
    }

    // 左孩子节点索引
    public static int leftIdx(int idx, int nodeNum) {
        int child = leftIdx(idx);
        if (child >= nodeNum) {
            return -1;
        }
        return child;
    }

    // 获取左孩子节点元素
    public static <T> T left(int idx, List<T> data) {
        int leftIdx = leftIdx(idx, data.size());
        if (leftIdx < 0) {
            return null;
        }
        return data.get(leftIdx);
    }

    // 右孩子节点索引
    public static int rightIdx(int idx) {
        return 2 * idx + 2;
    }

    // 右孩子节点索引
    public static int rightIdx(int idx, int nodeNum) {
        int child = rightIdx(idx);
        if (child >= nodeNum) {
            return -1;
        }
        return child;
    }

    // 获取右孩子节点元素
    public static <T> T right(int idx, List<T> data) {
        int rightIdx = rightIdx(idx, data.size());
        if (rightIdx < 0) {
            return null;
        }
        return data.get(rightIdx);
    }

    // 从节点数计算层数,层数从 0 开始编号: floor(log2(n))
    public static int layerNum(int nodeNum) {
        return Double.valueOf(Math.floor(Math.log(nodeNum) / Math.log(2))).intValue();
    }
}
