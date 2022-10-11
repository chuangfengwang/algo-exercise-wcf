package com.helipy.leetcodecn.jzof2;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof21
 * Desc: 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * https://leetcode.cn/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-07-17 20:15
 */
public class LtcJzof21 {
    class Solution {
        public int[] exchange(int[] nums) {
            int prev = 0, post = nums.length - 1;
            while (prev < post) {
                if ((nums[prev] % 2) != 0) {  // prev是奇数
                    ++prev;
                    continue;
                }
                if ((nums[post] % 2) == 0) {  // post是偶数
                    --post;
                    continue;
                }
                // prev 是偶数, post 是奇数, 交换
                int tmp = nums[prev];
                nums[prev] = nums[post];
                nums[post] = tmp;
            }
            return nums;
        }
    }
}
