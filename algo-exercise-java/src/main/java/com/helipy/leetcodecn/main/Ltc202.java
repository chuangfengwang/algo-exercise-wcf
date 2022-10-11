package com.helipy.leetcodecn.main;

import java.util.HashSet;
import java.util.Set;


/**
 * Pack:       com.helipy.leetcodecn.main
 * File:       Ltc202
 * Desc: 202. 快乐数
 * https://leetcode.cn/problems/happy-number/
 * User:       chuangfengwang
 * CreateTime: 2022-07-27 23:36
 */
public class Ltc202 {
    static
    class Solution {

        // 快慢变换判断是否存在循环
        public boolean isHappy(int n) {
            if (n <= 0) {
                return false;
            }
            int slow = n, fast = digitSquareSum(n);
            while (slow != 1 && slow != fast) {
                slow = digitSquareSum(slow);
                fast = digitSquareSum(digitSquareSum(fast));
            }
            return slow == 1;
        }

        // 用 set 记录是否产生循环
        public boolean isHappy1(int n) {
            if (n <= 0) {
                return false;
            }
            Set<Integer> set = new HashSet<>();
            int next = digitSquareSum(n);
            while (next != 1 && !set.contains(next)) {
                set.add(next);
                next = digitSquareSum(next);
            }
            return next == 1;
        }

        private int digitSquareSum(int n) {
            assert n > 0;
            int sum = 0;
            while (n > 0) {
                int d = n % 10;
                sum += d * d;
                n /= 10;
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    private static void test1() {
        Solution solution = new Solution();
        boolean out = solution.isHappy(7);
        System.out.println(out);
        assert out == true;
    }

    private static void test2() {
        Solution solution = new Solution();
        boolean out = solution.isHappy(19);
        System.out.println(out);
        assert out == true;
    }

    private static void test3() {
        Solution solution = new Solution();
        boolean out = solution.isHappy(2);
        System.out.println(out);
        assert out == false;
    }

    private static void test4() {
        Solution solution = new Solution();
        boolean out = solution.isHappy(1);
        System.out.println(out);
        assert out == true;
    }

}
