package com.huangrui.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/**
 * @author lingjiancong
 * @since 2021-04-26
 */
public class PrintUtils {

    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "-");
            head = head.next;
        }
        System.out.println();
    }

    public static <T> void print(List<List<T>> res) {
        if (res == null) {
            return;
        }
        for (List<T> re : res) {
            System.out.println(Arrays.toString(re.toArray()));
        }
        System.out.println();
    }

    public static void printInOrder(int[][] arr) {
        if (arr == null) {
            return;
        }
        List<int[]> list = new ArrayList<>();
        for (int[] ints : arr) {
            list.add(ints);
        }
        Collections.sort(list, Comparator.comparing(ints -> ints[0]));
        for (int[] ints : list) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();
    }

    public static void print(int[][] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; ++i) {
            print(arr[i]);
        }
        System.out.println();
    }

    public static void print(int[] nums) {
        System.out.println(Arrays.toString(nums));
    }

    public static <T> void printList(List<T> nums) {
        System.out.println(Arrays.toString(nums.toArray()));
    }
}
