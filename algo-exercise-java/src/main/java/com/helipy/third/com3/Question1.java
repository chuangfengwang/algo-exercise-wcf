package com.helipy.third.com3;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;


/**
 * Pack:       com.helipy.third.paradigm4
 * File:       Question1
 * Desc: 给定整数数组,生成该数组的所有子集
 * User:       chuangfengwang
 * CreateTime: 2022-08-04 11:02
 */
public class Question1 {

    // 假定数组中元素会重复
    public List<List<Integer>> compose2(List<Integer> nums) {
        if (nums == null || nums.isEmpty()) {
            return new LinkedList<>();
        }
        nums.sort(null);
        List<List<Integer>> carryOut = new LinkedList<>();
        LinkedList<Integer> cur = new LinkedList<>();
        composeCore2(nums, carryOut, cur, 0, false);
        return carryOut;
    }

    /**
     * 生成子集:
     * 依次考虑每个元素要不要加入当前生成的集合.
     * 如果当前元素和上一个相同,且上一个没有加入当前集合,则跳过当前元素
     * 生成的子集按 nums 的字典序递增. 不含空集
     *
     * @param nums     输入输入
     * @param carryOut 携带结果
     * @param cur      当前考察的元素集合
     * @param idx      本次调用考虑第几个元素:要不要加入考察集合
     */
    private void composeCore2(List<Integer> nums, List<List<Integer>> carryOut,
                              LinkedList<Integer> cur, int idx, boolean lastUsed) {
        if (idx >= nums.size()) {
            return;
        }
        // 不加入当前元素递归
        composeCore2(nums, carryOut, cur, idx + 1, false);

        // 如果当前元素和上一个相同,且上一个没有加入当前集合,则跳过当前元素. 在 "不加入当前元素递归" 之后判断, 不会提前终止后续不同元素的添加
        if (!lastUsed && idx > 0 && Objects.equals(nums.get(idx), nums.get(idx - 1))) {
            return;
        }
        // 加入当前元素,生成一个结果,然后继续递归
        cur.add(nums.get(idx));  // 加入当前元素
        carryOut.add(new ArrayList<>(cur));
        composeCore2(nums, carryOut, cur, idx + 1, true);
        cur.pollLast();  // 弹出当前元素
    }


    // 假定数组中元素不重复
    public List<List<Integer>> compose1(List<Integer> nums) {
        if (nums == null || nums.isEmpty()) {
            return new LinkedList<>();
        }
        nums.sort(null);
        List<List<Integer>> carryOut = new LinkedList<>();
        LinkedList<Integer> cur = new LinkedList<>();
        composeCore1(nums, carryOut, cur, 0);
        return carryOut;
    }

    /**
     * 生成子集:
     * 依次考虑每个元素要不要加入当前生成的集合
     * 生成的子集按 nums 的字典序递增. 不含空集
     *
     * @param nums     输入输入
     * @param carryOut 携带结果
     * @param cur      当前考察的元素集合
     * @param idx      本次调用考虑第几个元素:要不要加入考察集合
     */
    private void composeCore1(List<Integer> nums, List<List<Integer>> carryOut, LinkedList<Integer> cur, int idx) {
        if (idx >= nums.size()) {
            return;
        }
        // 加入当前元素,生成一个结果,然后继续递归
        cur.add(nums.get(idx));  // 加入当前元素
        carryOut.add(new ArrayList<>(cur));
        composeCore1(nums, carryOut, cur, idx + 1);
        cur.pollLast();  // 弹出当前元素
        // 不加入当前元素递归
        composeCore1(nums, carryOut, cur, idx + 1);
    }

    public static void main(String[] args) {

        test1();
        test2();
    }

    private static void test1() {
        Question1 question1 = new Question1();
        int[] numArr = new int[]{0, 1, 2};
        List<Integer> nums = new ArrayList<>(numArr.length);
        for (int val : numArr) {
            nums.add(val);
        }
        List<List<Integer>> compose = question1.compose1(nums);
        System.out.println(JSON.toJSONString(compose));
    }

    private static void test2() {
        Question1 question1 = new Question1();
        int[] numArr = new int[]{0, 1, 1, 2};
        List<Integer> nums = new ArrayList<>(numArr.length);
        for (int val : numArr) {
            nums.add(val);
        }
        List<List<Integer>> compose = question1.compose2(nums);
        System.out.println(JSON.toJSONString(compose));
    }
}
