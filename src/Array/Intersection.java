package Array;

import java.util.*;

/**
 * @program: LeetCode_J
 * @description: 给定两个数组，编写一个函数来计算它们的交集。
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 * @author: huangrui
 * @create: 2020-07-13 15:48
 **/

/**
 * 思路：构造两个map,其中key为nums1和nums2中的元素,value则为对应的下标列表
 * 使用map判断两者是否存在交集,为保证元素出现次数相同,仅当该元素第一次出现时才加入结果集中
 */
public class Intersection {

    public static int[] intersect(int[] nums1, int[] nums2) {

        if (nums1.length >= nums2.length) {     //nums1始终为两者中较短的数组
            int[] temp = nums2;
            nums2 = nums1;
            nums1 = temp;
        }
        Map<Integer, List<Integer>> nums1Map = toMap(nums1);
        Map<Integer, List<Integer>> nums2Map = toMap(nums2);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            if (nums2Map.containsKey(nums1[i])) {
                List<Integer> position1 = nums1Map.get(nums1[i]);
                List<Integer> position2 = nums2Map.get(nums1[i]);
                if (i == position1.get(0)) {
                    if (position1.size() <= position2.size()) {
                        for (Integer j : position1) {
                            result.add(nums1[j]);
                        }
                    } else {
                        for (Integer j : position2) {
                            result.add(nums2[j]);
                        }
                    }
                }
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private static Map<Integer, List<Integer>> toMap(int[] nums) {
        Map<Integer, List<Integer>> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numsMap.containsKey(nums[i])) {
                List<Integer> values = numsMap.get(nums[i]);
                values.add(i);
                numsMap.put(nums[i], values);
            } else {
                List<Integer> value = new ArrayList<>();
                value.add(i);
                numsMap.put(nums[i], value);
            }
        }
        return numsMap;
    }

    public static void main(String[] args) {

        int[] nums1 = {};
        int[] nums2 = {};

        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }
}
