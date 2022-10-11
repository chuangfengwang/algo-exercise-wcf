package com.helipy.leetcodecn.jzof2;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcJzof43
 * Desc: 剑指 Offer 43. 1～n 整数中 1 出现的次数
 * https://leetcode.cn/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/
 * User:       chuangfengwang
 * CreateTime: 2022-08-06 00:59
 */
public class LtcJzof43 {
    static
    class Solution {
        /**
         * 找规律,依次计算每一位上出现 1 的次数:
         * n 切分成 [pre][cur][post]: cur是当前考察的那一位. pre 和 post 可能为空(0)
         * pre = n / (base*10). base=10^k. k=0,1,2,3,...
         * 0. 个位: cur>1时, pre*base+1; =1时, pre*base+(post+1); <1时,pre*base
         * 1. 十位: cur>1时, pre*base+base; =1时,pre*base+(post+1); <1时,pre*base
         * 2. 百位: cur>1时, pre*base+base; =1时,pre*base+(post+1); <1时,pre*base
         * k. 最高位(k位)(pre=0): cur>1, base; =1时,post  -> 可以和上面合并
         *
         * @param n
         * @return
         */
        public int countDigitOne(int n) {
            if (n < 1) {
                return 0;
            }
            long count = 0;
            int digitNum = digitNum(n);
            for (int k = 0; k < digitNum; ++k) {
                // 分解 n
                long base = (long) Math.pow(10, k);
                int pre = (int) (n / (base * 10));
                int post = (int) (n % base);
                int cur = (int) ((n / base) % 10);
                if (cur > 1) {
                    count += pre * base + base;
                } else if (cur == 1) {
                    count += pre * base + (post + 1);
                } else {
                    count += pre * base;
                }
            }
            return (int) count;
        }

        // 计算数字的总位数
        private int digitNum(int n) {
            final int base = 10, maxDig = 20;
            for (int idx = 1; idx <= maxDig; ++idx) {
                if (n / base == 0) {
                    return idx;
                }
                n /= 10;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        Solution solution = new Solution();
//        System.out.println(solution.countDigitOne(1));  // 1
        System.out.println(solution.countDigitOne(12));  // 5
        System.out.println(solution.countDigitOne(13));  // 6
        System.out.println(solution.countDigitOne(5));  // 1
        System.out.println(solution.countDigitOne(214748367));  // 275627945
        System.out.println(solution.countDigitOne(2147483647));  //
    }
}
