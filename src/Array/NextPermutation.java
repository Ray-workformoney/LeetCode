package Array;

import java.util.Arrays;
/**
 * [31]下一个排列
 * @author : huangrui
 * @version :
 * @date : 2021-09-27 14:56
 **/
public class NextPermutation {

    public static void nextPermutation(int[] nums) {

        if (nums.length == 1) {
            return;
        }
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                // 找到两个升序排列的数 左边的是较小的数
                int j = nums.length - 1;
                while (j > i - 1 && nums[j] <= nums[i - 1]) {
                    // 从后往前找到比较小的数大的数作为较大的数
                    j--;
                }
                // 交换较小数和较大数
                int temp = nums[i - 1];
                nums[i - 1] = nums[j];
                nums[j] = temp;
                // 交换后 右边的数肯定是降序的 直接revers
                revers(nums, i, nums.length - 1);
                return;
            }
        }
        // 找不到 直接逆序
        revers(nums, 0, nums.length - 1);
    }

    private static void revers(int[] nums, int low, int high) {
        for (; low <= high; low++, high--) {
            // 找不到 升序排序
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1};
        nextPermutation(nums);
        Arrays.stream(nums).forEach(System.out::print);
    }

}
