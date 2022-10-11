package com.helipy.leetcodecn.main;

import java.util.ArrayList;
import java.util.List;

/**
 * Pack:       com.helipy.leetcodecn.main
 * File:       Ltc412
 * Desc: 412. Fizz Buzz
 * https://leetcode.cn/problems/fizz-buzz/
 * User:       chuangfengwang
 * CreateTime: 2022-07-18 23:57
 */
public class Ltc412 {
    class Solution {
        public List<String> fizzBuzz(int n) {
            List<String> list = new ArrayList<>(n);
            for (int idx = 0; idx < n; ++idx) {
                if ((idx + 1) % 3 == 0 && (idx + 1) % 5 == 0) {
                    list.add("FizzBuzz");
                } else if ((idx + 1) % 3 == 0) {
                    list.add("Fizz");
                } else if ((idx + 1) % 5 == 0) {
                    list.add("Buzz");
                } else {
                    list.add(String.valueOf(idx + 1));
                }
            }
            return list;
        }
    }
}
