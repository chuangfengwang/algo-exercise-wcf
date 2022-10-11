package com.helipy.common;

import junit.framework.TestCase;

/**
 * Pack:       com.helipy.common
 * File:       BinarySearchTest
 * Desc:
 * User:       chuangfengwang
 * CreateTime: 2022-07-09 17:13
 */
public class BinarySearchTest extends TestCase {

    public void test1_1() {
        int[] nums = new int[]{1, 2, 2, 4, 5};
        int idx = BinarySearch.search(nums, 4);
        assertEquals(3, idx);
        int idxR = BinarySearch.searchRecursion(nums, 4);
        assertEquals(3, idxR);
    }

    public void test1_2() {
        int[] nums = new int[]{1, 2, 2, 4, 5};
        int idx = BinarySearch.search(nums, 6);
        assertEquals(-1, idx);
        int idxR = BinarySearch.searchRecursion(nums, 6);
        assertEquals(-1, idxR);
    }

    public void test1_3() {
        int[] nums = new int[]{1, 2, 2, 4, 5};
        int idx = BinarySearch.search(nums, 2);
        assertTrue(idx == 1 || idx == 2);
        int idxR = BinarySearch.searchRecursion(nums, 2);
        assertTrue(idxR == 1 || idxR == 2);
    }

    public void test2_1() {
        int[] nums = new int[]{1};
        int idx = BinarySearch.search(nums, 1);
        assertEquals(0, idx);
        int idxR = BinarySearch.searchRecursion(nums, 1);
        assertEquals(0, idxR);
    }

    public void test2_2() {
        int[] nums = new int[]{1};
        int idx = BinarySearch.search(nums, 9);
        assertEquals(-1, idx);
        int idxR = BinarySearch.searchRecursion(nums, 9);
        assertEquals(-1, idxR);
    }

    public void test3() {
        int[] nums = new int[]{};
        int idx = BinarySearch.search(nums, 9);
        assertEquals(-1, idx);
        int idxR = BinarySearch.searchRecursion(nums, 9);
        assertEquals(-1, idxR);
    }
}