package com.helipy.leetcodecn;

import com.alibaba.fastjson.JSON;

/**
 * Pack:       com.helipy.leetcodecn.jzof2
 * File:       LtcUtil
 * Desc:
 * User:       chuangfengwang
 * CreateTime: 2022-07-28 18:44
 */
public class LtcUtil {

    // 从 json 构造整数矩阵
    static public int[][] buildIntMatrix(String json) {
        Integer[][] integerArray = JSON.parseObject(json, Integer[][].class);
        int[][] arr = new int[integerArray.length][];
        for (int idx = 0; idx < integerArray.length; ++idx) {
            arr[idx] = new int[integerArray[idx].length];
            for (int j = 0; j < integerArray[idx].length; ++j) {
                arr[idx][j] = integerArray[idx][j];
            }
        }
        return arr;
    }
}
