package com.helipy.leetcodecn.main;

import com.helipy.leetcodecn.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Pack:       com.helipy.leetcodecn.main
 * File:       Ltc0001
 * Desc: 1. 两数之和
 * https://leetcode.cn/problems/two-sum/
 * User:       chuangfengwang
 * CreateTime: 2022-07-02 20:18
 */
public class Ltc0001 {

    // 暴力遍历
    public int[] twoSum1(int[] nums, int target) {
        int length = nums.length;
        for (int idx = 0; idx < length - 1; idx++) {
            int aim = target - nums[idx];
            for (int bidx = idx + 1; bidx < length; bidx++) {
                if (aim == nums[bidx]) {
                    return new int[]{nums[idx], nums[bidx]};
                }
            }
        }
        return new int[]{-1, -1};
    }

    // 先排序后查找
    public int[] twoSum2(int[] nums, int target) {
        ArrayList<Pair<Integer, Integer>> sortedPairList = sortWithIndex(nums);
        Pair<Integer, Integer>[] sortedPairArray = sortedPairList.toArray(new Pair[sortedPairList.size()]);
        for (int idx = 0; idx < sortedPairArray.length - 1; idx++) {
            int aim = target - sortedPairArray[idx].getKey();
            int aimIdx = Arrays.binarySearch(sortedPairArray, idx + 1, nums.length, new Pair<>(aim, -1),
                    (left, right) -> {
                        return left.getKey().compareTo(right.getKey());
                    });
            if (aimIdx > 0) {
                return new int[]{sortedPairList.get(idx).getValue(), sortedPairList.get(aimIdx).getValue()};
            }
        }
        return new int[]{-1, -1};
    }

    // 返回 list 里, Pair.key: 原值, Pair.value: 原位置索引(从0开始)
    private ArrayList<Pair<Integer, Integer>> sortWithIndex(int[] nums) {
        ArrayList<Pair<Integer, Integer>> list = new ArrayList<>(nums.length);
        for (int idx = 0; idx < nums.length; idx++) {
            list.add(new Pair<>(nums[idx], idx));
        }
        list.sort(Comparator.comparing(Pair::getKey));
        return list;
    }

    // 用 map 存查看过的位置
    public int[] twoSum3(int[] nums, int target) {
        int[] res = {-1, -1};
        Map<Integer, Integer> map = new HashMap<>();
        for (int leftIdx = 0; leftIdx < nums.length; leftIdx++) {
            int aim = target - nums[leftIdx];
            if (map.containsKey(aim)) {
                // 已经存入 map 里的先出现, 索引放前面
                res[0] = map.get(aim);
                res[1] = leftIdx;
                return res;
            }
            // key:value 数值:位置
            map.put(nums[leftIdx], leftIdx);
        }
        return res;
    }

    // 双向遍历
    public int[] twoSum(int[] nums, int target) {
        int[] res = {-1, -1};
        Map<Integer, Integer> map = new HashMap<>();
        // 根据假设:必有答案, leftIdx == rightIdx 时, 必在内部 left 侧返回; 因一次跳过2个元素,奇数个元素会漏掉一次检查
        for (int leftIdx = 0, rightIdx = nums.length - 1; leftIdx <= rightIdx; leftIdx++, rightIdx--) {
            // 检查 left 匹配
            int aim = target - nums[leftIdx];
            if (map.containsKey(aim)) {
                int aimIdx = map.get(aim);
                res[0] = Math.min(leftIdx, aimIdx);
                res[1] = Math.max(leftIdx, aimIdx);
                return res;
            } else {
                // key:value 数值:位置
                map.put(nums[leftIdx], leftIdx);
            }
            // 检查 right 匹配
            aim = target - nums[rightIdx];
            if (map.containsKey(aim)) {
                int aimIdx = map.get(aim);
                res[0] = Math.min(rightIdx, aimIdx);
                res[1] = Math.max(rightIdx, aimIdx);
                return res;
            } else {
                // key:value 数值:位置
                map.put(nums[rightIdx], rightIdx);
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
