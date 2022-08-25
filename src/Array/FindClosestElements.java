package Array;

import Common.PrintUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author huangrui
 * @date 2022/8/25
 */
public class FindClosestElements {

    /**
     * sliding window
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int len = arr.length;
        if (len == k) {
            return Arrays.stream(arr).boxed().collect(Collectors.toList());
        }
        int begin = 0, end = begin + k;
        while (end < len && arr[end] < x) {
            begin++;
            end++;
        }
        while (end < len && Math.abs(arr[begin] - x) > Math.abs(arr[end] - x)) {
            begin++;
            end++;
        }
        return Arrays.stream(arr).boxed().collect(Collectors.toList()).subList(begin, end);
    }

    public static void main(String[] args) {
        FindClosestElements findClosestElements = new FindClosestElements();
        System.out.println(findClosestElements.findClosestElements(new int[] {3,5,8,10}, 2, 15).toString());
    }
}
