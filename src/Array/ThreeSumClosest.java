package Array;

import java.util.Arrays;

/**
 * @program: LeetCode_J
 * @description: 最接近的三数之和
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。
 * 返回这三个数的和。假定每组输入只存在唯一答案。
 * 思路：利用双指针
 * @author: huangrui
 * @create: 2020-12-09 10:20
 **/

public class ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        int minLength = 3;
        int sum = 0;
        if (nums.length <= minLength) {
            for (int num : nums) {
                sum += num;
            }
            return sum;
        }
        Arrays.sort(nums);
        int result = 100000;
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
                if (sum == target) {
                    return sum;
                }
                if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] nums = {3,-2,-5,3,-4};
        int target = -1;
        System.out.println(threeSumClosest(nums, target));
    }
}
